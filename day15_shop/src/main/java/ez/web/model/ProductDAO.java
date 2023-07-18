package ez.web.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
   
   // pNum에 해당하는 상품가져오기 
   public ProductDTO getProduct(String pNum) {
	   ProductDTO dto = null; 
	   String sql = "SELECT * FROM product WHERE pNum = ?";
	   conn = getConnection();
	   try {
		ps = conn.prepareStatement(sql);
		ps.setString(1, pNum);
		rs=ps.executeQuery();
		
		ArrayList<ProductDTO> dtos = getProductList(rs);
		
		if(dtos !=null && dtos.size() != 0) {
			dto = dtos.get(0);
		}
	} catch (SQLException e) {

		e.printStackTrace();
	}finally {
		dbClose();
	}
	   return dto;
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
	}finally {
		dbClose();
	}
	   return n;
   }
   
   
   
}