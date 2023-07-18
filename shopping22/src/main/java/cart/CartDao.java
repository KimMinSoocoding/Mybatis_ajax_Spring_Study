package cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CartDao {
	private Connection conn = null;

	private static CartDao instance;

	public static CartDao getInstance() {
		if (instance == null) {
			instance = new CartDao();
		}
		return instance;
	}

	private CartDao(){
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env"); // java:comp/env �� ���� ������ ����Ǵ°� ���� ���Ƿ� ������ �� ����.
			DataSource ds = (DataSource) envContext.lookup("jdbc/OracleDB");
			conn = ds.getConnection(); // ���� ������ ������ ������ �����ؼ� Connection 
			System.out.println("conn :" + conn);
		} catch (NamingException e) {
			System.out.println("CategoryDao 커넥션 객체를 불러오는 중 오류 발생");
		} catch (SQLException e) {
			System.out.println("CategoryDao 커넥션 객체를 불러오는 중 오류 발생");
		}
	}
	
	public ArrayList<CartBean> getAllItem(int mno){
		
		ArrayList<CartBean> ctlist = new ArrayList<CartBean>(); 
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		/* ��� ���� ó���ϴ� �κ� */
		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "select ct.no, pro.name, ct.opname, pro.discprice, ct.qty, pro.mainimgn\r\n"
					+ "from product pro inner join cart ct\r\n"
					+ "on pro.no = ct.pno\r\n"
					+ "where mno=?";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, mno);

			// 4. SQL�� ����
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CartBean ctbean = new CartBean();
				
				ctbean.setNo(rs.getInt("no"));
				ctbean.setPname(rs.getString("name"));
				ctbean.setOneprice(rs.getInt("discprice"));
				ctbean.setOpname(rs.getString("opname"));
				ctbean.setQty(rs.getInt("qty"));
				ctbean.setMainimgn(rs.getString("mainimgn"));
				
				ctlist.add(ctbean);
			}

		} catch (

		SQLException e) {
			System.out.println(e);
			System.out.println("getAllItem() SQL 연결 중 오류 발생");
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println("접속 연결 실패");
			}
		}
		return ctlist;
	}
	
	public CartBean getItem(int no){
		
		CartBean ctbean = null; 
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		/* ��� ���� ó���ϴ� �κ� */
		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "select ct.no, pro.name, ct.opname, ct.pno, pro.discprice, ct.qty, pro.mainimgn\r\n"
					+ "from product pro inner join cart ct\r\n"
					+ "on pro.no = ct.pno where ct.no=?";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, no);

			// 4. SQL�� ����
			rs = ps.executeQuery();
			
			if(rs.next()) {
				ctbean = new CartBean();

				ctbean.setNo(rs.getInt("no"));
				ctbean.setPname(rs.getString("name"));
				ctbean.setPno(rs.getInt("pno"));
				ctbean.setOneprice(rs.getInt("discprice"));
				ctbean.setOpname(rs.getString("opname"));
				ctbean.setQty(rs.getInt("qty"));
				ctbean.setMainimgn(rs.getString("mainimgn"));
			}

		} catch (

		SQLException e) {
			System.out.println(e);
			System.out.println("getItem() SQL 연결 중 오류 발생");
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println("접속 연결 실패");
			}
		}
		return ctbean;
	}
	
	public int insertItem(int mno, int pno, int qty, String opname) {
		
		int cnt = -1;

		PreparedStatement ps = null;

		/* ��� ���� ó���ϴ� �κ� */
		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "insert into cart values(cartseq.nextval,?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, mno);
			ps.setInt(2, pno);
			ps.setString(3, opname);
			ps.setInt(4, qty);

			// 4. SQL�� ����
			cnt = ps.executeUpdate();

		} catch (

		SQLException e) {
			System.out.println(e);
			System.out.println("insertItem() SQL 연결 중 오류 발생");
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
	
	public int countItemInCart(int mno) { // �ش� ����ڰ� ��ٱ��Ͽ� ����ִ� ��ǰ�� �� ���� 
		
		int result = -1;

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		/* ��� ���� ó���ϴ� �κ� */
		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "select count(*) from cart where mno=" + mno;
			ps = conn.prepareStatement(sql);

			// 4. SQL�� ����
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}

		} catch (

		SQLException e) {
			System.out.println(e);
			System.out.println("countItemInCart() SQL 연결 중 오류 발생");
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println("접속 연결 실패");
			}
		}
		return result;
	}
	
	public int deleteItem(int itemno) {
		
		int cnt = -1;

		PreparedStatement ps = null;

		/* ��� ���� ó���ϴ� �κ� */
		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "delete from cart where no=" + itemno;
			ps = conn.prepareStatement(sql);

			// 4. SQL�� ����
			cnt = ps.executeUpdate();

		} catch (

		SQLException e) {
			System.out.println(e);
			System.out.println("deleteItem() SQL 연결 중 오류 발생");
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
	
	public int updateItem(int no, int qty){
		int cnt = -1;

		PreparedStatement ps = null;

		/* ��� ���� ó���ϴ� �κ� */
		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "update cart set qty = ? where no=?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, qty);
			ps.setInt(2, no);
			
			// 4. SQL�� ����
			cnt = ps.executeUpdate();

		} catch (

		SQLException e) {
			System.out.println(e);
			System.out.println("updateItem() SQL 연결 중 오류 발생");
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
	
	public int getMaxCtno(int mno) {
		int maxCtno = -1;
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		/* ��� ���� ó���ϴ� �κ� */
		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "select max(no) from cart where mno=?";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, mno);

			// 4. SQL�� ����
			rs = ps.executeQuery();
			
			if(rs.next()) {
				maxCtno = rs.getInt(1);
			}

		} catch (

		SQLException e) {
			System.out.println(e);
			System.out.println("getAllItem() SQL 연결 중 오류 발생");
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println("접속 연결 실패");
			}
		}
		return maxCtno;
	}
}
