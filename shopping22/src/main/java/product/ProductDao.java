package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.oreilly.servlet.MultipartRequest;

public class ProductDao {
	private Connection conn = null;
	
	private static ProductDao instance;
	public static ProductDao getInstance() {
		if(instance == null) {
			instance = new ProductDao();
		}
		return instance;
	}
	
	private ProductDao(){
		try {
			/* Context.xml�� ������� ������ �о�� */
			Context initContext = new InitialContext();
			/* ���� ������ Context.xml ������ comp/env �̷� �����ȿ� ����� */
			Context envContext = (Context) initContext.lookup("java:comp/env"); // java:comp/env �� ���� ������ ����Ǵ°� ���� ���Ƿ� ������ �� ����.
			/* �� �������� jbdc/OracleDb �̸����� ������ ���������Ͷ� */
			DataSource ds = (DataSource) envContext.lookup("jdbc/OracleDB");
			// ����ڰ� ����Ʈ�� �����ϸ� ���ؼ� ��ü�� ����. �׸��� �� ���ؼ� ��ü�� ������ �α����� �ϰ� �ڽð� �ϴ°���. ����� DB�۾�
			conn = ds.getConnection(); // ���� ������ ������ ������ �����ؼ� Connection 
			System.out.println("conn :" + conn);
		} catch (NamingException e) {
			System.out.println("CategoryDao 커넥션 객체를 불러오는 중 오류 발생");
		} catch (SQLException e) {
			System.out.println("CategoryDao 커넥션 객체를 불러오는 중 오류 발생");
		}
	}
	
	public ArrayList<ProductBean> getAllProduct() {
		
		ArrayList<ProductBean> list = new ArrayList<ProductBean>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "select pro.NO, pro.LCNAME, scate.name as SCNAME, pro.NAME, pro.ORIPRICE, pro.DISCPRICE, pro.INFO, pro.MAINIMGN, pro.DETAILIMGN1, pro.DETAILIMGN2, pro.DETAILIMGN3, pro.DETAILIMGN4 \r\n"
					+ "from scategory scate inner join (select pro.NO, lcate.NAME as lcname, pro.SCNO, pro.NAME, pro.ORIPRICE, pro.DISCPRICE, pro.INFO, pro.MAINIMGN, pro.DETAILIMGN1, pro.DETAILIMGN2, pro.DETAILIMGN3, pro.DETAILIMGN4\r\n"
					+ "from lcategory lcate inner join product pro\r\n"
					+ "on lcate.no = pro.lcno) pro\r\n"
					+ "on scate.no = pro.scno";
			ps = conn.prepareStatement(sql);
			
			// 4. SQL�� ����
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ProductBean pbean = new ProductBean();
				
				pbean.setNo(rs.getInt("no"));
				pbean.setLcname(rs.getString("lcname"));
				pbean.setScname(rs.getString("scname"));
				pbean.setName(rs.getString("name"));				
				pbean.setOriprice(rs.getInt("oriprice"));				
				pbean.setDiscprice(rs.getInt("discprice"));
				pbean.setInfo(rs.getString("info"));
				pbean.setMainImgN(rs.getString("mainImgN"));				
				pbean.setDetailImgN1(rs.getString("detailImgN1"));
				pbean.setDetailImgN2(rs.getString("detailImgN2"));
				pbean.setDetailImgN3(rs.getString("detailImgN3"));
				pbean.setDetailImgN4(rs.getString("detailImgN4"));
				
				list.add(pbean);
			}

		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("getAllProduct() 연결 중 오류 발생");
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println("접속 연결 실패");
			}
		}
		return list;
	}// getAllProduct()
	
	public ArrayList<ProductBean> getAllProductByLcno(int lcno){
		ArrayList<ProductBean> list = new ArrayList<ProductBean>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "select pro.NO, pro.LCNAME, scate.name as scname, pro.NAME, pro.ORIPRICE, pro.DISCPRICE, pro.INFO, pro.MAINIMGN, pro.DETAILIMGN1, pro.DETAILIMGN2, pro.DETAILIMGN3, pro.DETAILIMGN4 \r\n"
					+ "from scategory scate inner join \r\n"
					+ "(select pro.NO, lcate.NAME as lcname, pro.SCNO, pro.NAME, pro.ORIPRICE, pro.DISCPRICE, pro.INFO, pro.MAINIMGN, pro.DETAILIMGN1, pro.DETAILIMGN2, pro.DETAILIMGN3, pro.DETAILIMGN4\r\n"
					+ "from lcategory lcate inner join product pro\r\n"
					+ "on lcate.no = pro.lcno where lcate.no=? ) pro\r\n"
					+ "on scate.no = pro.scno";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, lcno);
			
			// 4. SQL�� ����
			rs = ps.executeQuery();
			System.out.println("여기까지 잘 옴");
			
			while(rs.next()) {
				ProductBean pbean = new ProductBean();
				
				pbean.setNo(rs.getInt("no"));
				pbean.setLcname(rs.getString("lcname"));
				pbean.setScname(rs.getString("scname"));
				pbean.setName(rs.getString("name"));				
				pbean.setOriprice(rs.getInt("oriprice"));				
				pbean.setDiscprice(rs.getInt("discprice"));
				pbean.setInfo(rs.getString("info"));
				pbean.setMainImgN(rs.getString("mainImgN"));				
				pbean.setDetailImgN1(rs.getString("detailImgN1"));
				pbean.setDetailImgN2(rs.getString("detailImgN2"));
				pbean.setDetailImgN3(rs.getString("detailImgN3"));
				pbean.setDetailImgN4(rs.getString("detailImgN4"));
				
				list.add(pbean);
			}

		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("getAllProductByLcno() SQL 연결 중 오류 발생");
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println("접속 연결 실패");
			}
		}
		return list;
	}
	
	public ArrayList<ProductBean> getAllProductByScno(int scno){
		ArrayList<ProductBean> list = new ArrayList<ProductBean>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "select pro.NO, pro.LCNAME, scate.name as scname, pro.NAME, pro.ORIPRICE, pro.DISCPRICE, pro.INFO, pro.MAINIMGN, pro.DETAILIMGN1, pro.DETAILIMGN2, pro.DETAILIMGN3, pro.DETAILIMGN4 \r\n"
					+ "from scategory scate inner join \r\n"
					+ "(select pro.NO, lcate.NAME as lcname, pro.SCNO, pro.NAME, pro.ORIPRICE, pro.DISCPRICE, pro.INFO, pro.MAINIMGN, pro.DETAILIMGN1, pro.DETAILIMGN2, pro.DETAILIMGN3, pro.DETAILIMGN4\r\n"
					+ "from lcategory lcate inner join product pro\r\n"
					+ "on lcate.no = pro.lcno) pro\r\n"
					+ "on scate.no = pro.scno where scate.no=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, scno);
			
			// 4. SQL�� ����
			rs = ps.executeQuery();
			System.out.println("여기까지 잘 옴");
			
			while(rs.next()) {
				ProductBean pbean = new ProductBean();
				
				pbean.setNo(rs.getInt("no"));
				pbean.setLcname(rs.getString("lcname"));
				pbean.setScname(rs.getString("scname"));
				pbean.setName(rs.getString("name"));				
				pbean.setOriprice(rs.getInt("oriprice"));				
				pbean.setDiscprice(rs.getInt("discprice"));
				pbean.setInfo(rs.getString("info"));
				pbean.setMainImgN(rs.getString("mainImgN"));				
				pbean.setDetailImgN1(rs.getString("detailImgN1"));
				pbean.setDetailImgN2(rs.getString("detailImgN2"));
				pbean.setDetailImgN3(rs.getString("detailImgN3"));
				pbean.setDetailImgN4(rs.getString("detailImgN4"));
				
				list.add(pbean);
			}

		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("getAllProductByScno() SQL 연결 중 오류 발생");
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println("접속 연결 실패");
			}
		}
		return list;
	}
	
	public ArrayList<ProductBean> getAllProductByName(String search){
		
		ArrayList<ProductBean> list = new ArrayList<ProductBean>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "select * from\r\n"
					+ "(select pro.NO, pro.LCNAME, scate.name as scname, pro.NAME, pro.ORIPRICE, pro.DISCPRICE, pro.INFO, pro.MAINIMGN, pro.DETAILIMGN1, pro.DETAILIMGN2, pro.DETAILIMGN3, pro.DETAILIMGN4 \r\n"
					+ "from scategory scate inner join \r\n"
					+ "(select pro.NO, lcate.NAME as lcname, pro.SCNO, pro.NAME, pro.ORIPRICE, pro.DISCPRICE, pro.INFO, pro.MAINIMGN, pro.DETAILIMGN1, pro.DETAILIMGN2, pro.DETAILIMGN3, pro.DETAILIMGN4\r\n"
					+ "from lcategory lcate inner join product pro\r\n"
					+ "on lcate.no = pro.lcno) pro\r\n"
					+ "on scate.no = pro.scno)\r\n"
					+ "where upper(lcname) like ? or upper(scname) like ? or upper(name) like ?";
			ps = conn.prepareStatement(sql);
			
			search = search.toUpperCase(); // �빮�ڷ� ��ȯ
			
			ps.setString(1, "%" + search + "%");
			ps.setString(2, "%" + search + "%");
			ps.setString(3, "%" + search + "%");
			
			// 4. SQL�� ����
			rs = ps.executeQuery();
			System.out.println("������� �� ��");
			
			while(rs.next()) {
				ProductBean pbean = new ProductBean();
				
				pbean.setNo(rs.getInt("no"));
				pbean.setLcname(rs.getString("lcname"));
				pbean.setScname(rs.getString("scname"));
				pbean.setName(rs.getString("name"));				
				pbean.setOriprice(rs.getInt("oriprice"));				
				pbean.setDiscprice(rs.getInt("discprice"));
				pbean.setInfo(rs.getString("info"));
				pbean.setMainImgN(rs.getString("mainImgN"));				
				pbean.setDetailImgN1(rs.getString("detailImgN1"));
				pbean.setDetailImgN2(rs.getString("detailImgN2"));
				pbean.setDetailImgN3(rs.getString("detailImgN3"));
				pbean.setDetailImgN4(rs.getString("detailImgN4"));
				
				list.add(pbean);
			}

		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("getAllProductByName() SQL 연결 중 오류 발생");
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println("접속 연결 실패");
			}
		}
		return list;
	}
	
	public int insertProduct(MultipartRequest multi) {
		
		int cnt = -1;

		PreparedStatement ps = null;

		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "insert into product values(prodseq.nextval,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(multi.getParameter("selLargeCategory")));
			ps.setInt(2, Integer.parseInt(multi.getParameter("selSmallCategory")));
			ps.setString(3, multi.getParameter("name"));
			ps.setInt(4, Integer.parseInt(multi.getParameter("oriprice")));
			ps.setInt(5, Integer.parseInt(multi.getParameter("discprice")));
			ps.setString(6, multi.getParameter("info"));
			ps.setString(7, multi.getFilesystemName("mainImg"));
			ps.setString(8, multi.getFilesystemName("detailImg1"));
			ps.setString(9, multi.getFilesystemName("detailImg2"));
			ps.setString(10, multi.getFilesystemName("detailImg3"));
			ps.setString(11, multi.getFilesystemName("detailImg4"));
			
			//System.out.println(Integer.parseInt(multi.getParameter("selLargeCategory")));
			//System.out.println(Integer.parseInt(multi.getParameter("selSmallCategory")));
			//System.out.println("������� �Ѿ��");
			
			// 4. SQL�� ����
			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("insertProduct() SQL 연결 중 오류 발생");
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println("접속 연결 실패");
			}
		}
		return cnt;
	}
	
	public ProductBean getProduct(int no) {
		
		ProductBean pbean = null;

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "select pro.NO, pro.LCNAME, scate.name as scname, pro.NAME, pro.ORIPRICE, pro.DISCPRICE, pro.INFO, pro.MAINIMGN, pro.DETAILIMGN1, pro.DETAILIMGN2, pro.DETAILIMGN3, pro.DETAILIMGN4 \r\n"
					+ "from scategory scate inner join \r\n"
					+ "(select pro.NO, lcate.NAME as lcname, pro.SCNO, pro.NAME, pro.ORIPRICE, pro.DISCPRICE, pro.INFO, pro.MAINIMGN, pro.DETAILIMGN1, pro.DETAILIMGN2, pro.DETAILIMGN3, pro.DETAILIMGN4\r\n"
					+ "from lcategory lcate inner join product pro\r\n"
					+ "on lcate.no = pro.lcno where pro.no=?) pro\r\n"
					+ "on scate.no = pro.scno";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			
			// 4. SQL�� ����
			rs = ps.executeQuery();

			if (rs.next()) {
				pbean = new ProductBean();

				pbean.setNo(rs.getInt("no"));
				pbean.setLcname(rs.getString("lcname"));
				pbean.setScname(rs.getString("scname"));
				pbean.setName(rs.getString("name"));
				pbean.setOriprice(rs.getInt("oriprice"));
				pbean.setDiscprice(rs.getInt("discprice"));
				pbean.setInfo(rs.getString("info"));
				pbean.setMainImgN(rs.getString("mainImgN"));
				pbean.setDetailImgN1(rs.getString("detailImgN1"));
				pbean.setDetailImgN2(rs.getString("detailImgN2"));
				pbean.setDetailImgN3(rs.getString("detailImgN3"));
				pbean.setDetailImgN4(rs.getString("detailImgN4"));
			}

		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("getProduct() SQL 연결 중 오류 발생");
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println("접속 연결 실패");
			}
		}
		return pbean;
	}
	
	public int deleteProduct(int pno) {
		
		int cnt = -1;

		PreparedStatement ps = null;

		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "delete from product where no=" + pno;
			ps = conn.prepareStatement(sql);
			
			// 4. SQL�� ����
			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("deleteProduct() SQL 연결 중 오류 발생");
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println("접속 연결 실패");
			}
		}
		return cnt;
	}
	
	public int updateProduct(MultipartRequest multi) {
		int cnt = -1;

		PreparedStatement ps = null;

		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "update product set lcno=?, scno=?, name=?, oriprice=?, discprice=?, info=?, mainimgn=?, detailimgn1=?, detailimgn2=?, detailimgn3=?, detailimgn4=? where no=?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(multi.getParameter("selLargeCategory")));
			ps.setInt(2, Integer.parseInt(multi.getParameter("selSmallCategory")));
			ps.setString(3, multi.getParameter("name"));
			ps.setInt(4, Integer.parseInt(multi.getParameter("oriprice")));
			ps.setInt(5, Integer.parseInt(multi.getParameter("discprice")));
			ps.setString(6, multi.getParameter("info"));
			
			if(multi.getFilesystemName("mainImg") == null) {
				ps.setString(7, multi.getParameter("beforeMainImg"));
			}else {
				ps.setString(7, multi.getFilesystemName("mainImg"));
			}
			
			if(multi.getFilesystemName("detailImg1") == null) {
				ps.setString(8, multi.getParameter("beforeImg1"));
			}else {
				ps.setString(8, multi.getFilesystemName("detailImg1"));
			}
			
			if(multi.getFilesystemName("detailImg2") == null) {
				ps.setString(9, multi.getParameter("beforeImg2"));
			}else {
				ps.setString(9, multi.getFilesystemName("detailImg2"));
			}
			
			if(multi.getFilesystemName("detailImg3") == null) {
				ps.setString(10, multi.getParameter("beforeImg3"));
			}else {
				ps.setString(10, multi.getFilesystemName("detailImg3"));
			}
			
			if(multi.getFilesystemName("detailImg3") == null) {
				ps.setString(11, multi.getParameter("beforeImg4"));
			}else {
				ps.setString(11, multi.getFilesystemName("detailImg4"));
			}
			
			ps.setInt(12, Integer.parseInt(multi.getParameter("pno")));

			// 4. SQL�� ����
			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("updateProduct() SQL 연결 중 오류 발생");
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println("접속 연결 실패");
			}
		}
		return cnt;
	}
}
