package ez.web.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.oreilly.servlet.MultipartRequest;

public class ProductDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	DataSource ds = null;
	
	// 싱글톤 패턴 적용하기
	private static ProductDAO instance;
	
	private ProductDAO() {}
	
	public static ProductDAO getInstance() {
		if(instance == null) {
			instance = new ProductDAO();
		}
		
		return instance;
	}
	
	public Connection getConnection() {
		Context ctx = null;
		DataSource ds = null;
		Connection conn = null;
		
		try {
			// 명부를 관리하는 객체
			ctx = new InitialContext();
			// 명부에서 jdbc_mysql를 찾아서 DataSource로 리턴
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc_oracle11g");
			// 커넥션 요청(톰캣에서 thread를 제공하고 connection 객체를 획득)
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void dbClose() {
		try {
			if(rs !=null) rs.close();
			if(ps !=null) ps.close();
			if(conn !=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 상품 등록
	public int registerProduct(MultipartRequest mr) {
		int n = -1;
		String sql = "INSERT INTO product VALUES(prod_seq.nextVal,?,?,?,?,?,?,?,?,?,sysdate)";
		
		conn = getConnection();
		try {
			ps = conn.prepareStatement(sql);
			String pName = mr.getParameter("pName");
			String pCategory_fk = mr.getParameter("pCategory_fk");
			// getFilesystemName(): 서버의 실제로 업로드된 파일명을 반환
			String pImage = mr.getFilesystemName("pImage");
			String pCompany = mr.getParameter("pCompany");
			String pQty = mr.getParameter("pQty");
			String price = mr.getParameter("price");
			String pSpec = mr.getParameter("pSpec");
			String pContent = mr.getParameter("pContent");
			String pPoint = mr.getParameter("pPoint");
			
			ps.setString(1,pName);
			ps.setString(2,pCategory_fk);
			ps.setString(3,pCompany);
			ps.setString(4,pImage);
			ps.setString(5,pQty);
			ps.setString(6,price);
			ps.setString(7,pSpec);
			ps.setString(8,pContent);
			ps.setString(9,pPoint);
			
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return n;
	}
	
	// 상품 전체 리스트 가져오기
	public ArrayList<ProductDTO> productList(){
		ArrayList<ProductDTO> dtos = null;
		String sql = "SELECT * FROM product ORDER BY pNum DESC";
		
		conn = getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			dtos = getProductList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return dtos;
	}
	
	public ArrayList<ProductDTO> getProductList(ResultSet rs){
		ArrayList<ProductDTO> dtos = new ArrayList<ProductDTO>();
			try {
				while(rs.next()) {
					int pNum = Integer.parseInt(rs.getString("pNum"));
					String pName = rs.getString("pName");
					String pCategory_fk = rs.getString("pCategory_fk");
					String pCompany = rs.getString("pCompany");
					String pImage = rs.getString("pImage");
					int pQty = rs.getInt("pQty");
					int price = rs.getInt("price");
					String pSpec = rs.getString("pSpec");
					String pContent = rs.getString("pContent");
					int pPoint = rs.getInt("pPoint");
					Date rDate= rs.getDate("pInputDate");
					// DB의 Date형식의 날짜를 문자열로 바꾸기
					String pInputDate = rDate.toString();
					
					ProductDTO dto = new ProductDTO(pNum, pName, pCategory_fk, pCompany, 
							pImage, pQty, price, pSpec, pContent, pPoint, pInputDate, 0, 0);
					dtos.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return dtos;
	}
	
	// 검색속도 향상을 위해서 해시맵 사용
	public HashMap<String, ArrayList<ProductDTO>> map =
			new HashMap<String, ArrayList<ProductDTO>>();
	
	ArrayList<ProductDTO> pDtos = null;
	
	// 카테고리 코드별 상품리스트 가져오기
	public ArrayList<ProductDTO> getProductByCategory(String code){
		String sql="SELECT * FROM product WHERE pCategory_fk = ?";
		
		conn = getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, code);
			rs = ps.executeQuery();
			
			pDtos = this.getProductList(rs);
			
			// 해시맵에 추가하기 : 카테고리 코드별로 각각 상품List가 맵에 추가된다. 
			map.put(code, pDtos);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}		
		return pDtos;
	}
	
	
	// 상품 사양에 해당하는 상품 리스트 가져오기
	public ArrayList<ProductDTO> getProductBySpec(String pSpec){
		ArrayList<ProductDTO> pDtos = new ArrayList<ProductDTO>();
		
		String sql = "SELECT * FROM product WHERE pSpec = ?";
		conn = getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pSpec);
			rs = ps.executeQuery();
			
			pDtos = getProductList(rs);
			
			// 상품 사양별로 각각 맵에 저장하기
			map.put(pSpec, pDtos);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return pDtos;
	}
	
		
	
	// pNum에 해당하는 상품가져오기
	public ProductDTO getProduct(String pNum) {
		ProductDTO dto = null;
		String sql = "SELECT * FROM product WHERE pNum = ?";
		
		conn = getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pNum);
			rs = ps.executeQuery();
			
			ArrayList<ProductDTO> dtos =getProductList(rs);
			
			if(dtos !=null && dtos.size() !=0) {
				dto = dtos.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return dto;
	}
	
	// 사용자가 장바구니에 담고자하는 상품 가져오기위한 메소드
		public ProductDTO getProduct(String pNum, String pSpec) {
			System.out.println("pNum---- : " + pNum);
			System.out.println("pSpec---- : " + pSpec);
			
			ArrayList<ProductDTO> pDtos = null;
			
			// 해시맵에서 사양별 상품리스트 가져오기
			if(!map.containsKey(pSpec)) {
				System.out.println("해당 상품 리스트가 없습니다!!!");
			}else {
				pDtos = map.get(pSpec);
			}
			
			// 사양별 상품리스트에서 사용자가 담고자하는 상품번호와 일치하는 상품가져오기
			for(ProductDTO pDto: pDtos) {
//				System.out.println("pDto.getpNum : " + pDto.getpNum());
				
				// String.valueOf(int) : int형을 문자열로 변환
				if(pNum.equals(String.valueOf(pDto.getpNum()))) {
					return pDto;
				}
			}
			
			return null;
		}
	
	
	
	
	// 상품 수정
	public int updateProduct(MultipartRequest mr) {
		int n = -1;
		String pName = mr.getParameter("pName");
		String pCategory_fk = mr.getParameter("pCategory_fk");
		String pCompany = mr.getParameter("pCompany");
		
		// 이미지 수정했을 경우(첨부했을 경우)
		String pImage = mr.getFilesystemName("pImage");
		if(pImage == null) { // 첨부하지 않았을 경우
			pImage = mr.getParameter("pImageOld");
		}
		
		String pQty= mr.getParameter("pQty");
		String price= mr.getParameter("price");
		String pSpec= mr.getParameter("pSpec");
		String pContent= mr.getParameter("pContent");
		String pPoint= mr.getParameter("pPoint");
		String pNum= mr.getParameter("pNum");
		
		String sql = "UPDATE product SET pName=?, pCategory_fk=?,"
				+ "pCompany=?, pImage=?, pQty=?, price=?, pSpec=?,"
				+ "pContent=?, pPoint=?, pInputDate=sysdate "
				+ "WHERE pNum=?";
		
		conn = getConnection();
		
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1,pName);
			ps.setString(2,pCategory_fk);
			ps.setString(3,pCompany);
			ps.setString(4,pImage);
			ps.setString(5,pQty);
			ps.setString(6,price);
			ps.setString(7,pSpec);
			ps.setString(8,pContent);
			ps.setString(9,pPoint);
			ps.setString(10,pNum);
			
			n = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		
		return n;
	}
	
	
	// 상품 삭제
	public int delProduct(String pNum) {
		int n = -1;
		String sql = "DELETE FROM product WHERE pNum = ?";
		
		conn = getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pNum);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return n;
		
	}
	
	
}
