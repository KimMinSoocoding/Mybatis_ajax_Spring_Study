package product.stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.collections.bag.SynchronizedSortedBag;

import com.oreilly.servlet.MultipartRequest;

public class StockDao {
	private Connection conn = null;

	private static StockDao instance;

	public static StockDao getInstance() {
		if (instance == null) {
			instance = new StockDao();
		}
		return instance;
	}

	private StockDao(){
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
	
	public ArrayList<StockBean> getAllStockByPno(int pno){
		
		int cnt = -1;
		ArrayList<StockBean> list = new ArrayList<StockBean>();
				
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "select * from stock where pno=? order by no";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, pno);

			// 4. SQL�� ����
			rs = ps.executeQuery();
			
			while(rs.next()) {
				StockBean sbean = new StockBean();
				sbean.setNo(rs.getInt("no"));
				sbean.setPno(rs.getInt("pno"));
				sbean.setOpname(rs.getString("opname"));
				sbean.setCount(rs.getInt("count"));
				
				list.add(sbean);
			}

			
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("getAllStockByPno() SQL 연결 중 오류 발생");
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

	public int insertStock(MultipartRequest multi) {

		int cnt = -1;

		PreparedStatement ps = null;

		
		/* ��� ���� ó���ϴ� �κ� */
		try {
			String preParseStr = multi.getParameter("opnums");
			//System.out.println("preParseStr:" + preParseStr);
			
			String[] strArr = preParseStr.split(",");
			for(String s : strArr){
				//System.out.println(s + " abc");
				String opname = multi.getParameter("opn_" + s); // ������ ���� ��� �κ�
				int count = Integer.parseInt(multi.getParameter("stock_" + s));
				System.out.println(opname + " " + count);
				
				// 3. SQL �ۻ� �� �м�
				String sql = "insert into stock values(stockseq.nextval,(select last_number-1 from user_sequences where sequence_name = 'PRODSEQ'),?,?)";
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, opname);
				ps.setInt(2, count);
				
				// 4. SQL�� ����
				cnt = ps.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("insertStock() SQL 연결 중 오류 발생");
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
	
	
	public int insertStockForUpdate(MultipartRequest multi) {
		
		int cnt = -1;

		PreparedStatement ps = null;

		
		/* ��� ���� ó���ϴ� �κ� */
		try {
			String preParseStr = multi.getParameter("opnums");
			//System.out.println("preParseStr:" + preParseStr);
			
			String[] strArr = preParseStr.split(",");
			for(String s : strArr){
				//System.out.println(s + " abc");
				String opname = multi.getParameter("opn_" + s); // ������ ���� ��� �κ�
				int count = Integer.parseInt(multi.getParameter("stock_" + s));
				//System.out.println(opname + " " + count);
				
				// 3. SQL �ۻ� �� �м�
				String sql = "insert into stock values(stockseq.nextval,?,?,?)";
				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, Integer.parseInt(multi.getParameter("pno")));
				ps.setString(2, opname);
				ps.setInt(3, count);
				
				// 4. SQL�� ����
				cnt = ps.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("insertStock() SQL 연결 중 오류 발생");
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
	
	
	public int deleteAllStock(int pno) {
		
		int cnt = -1;

		PreparedStatement ps = null;

		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "delete from stock where pno=" + pno;
			ps = conn.prepareStatement(sql);
			
			// 4. SQL�� ����
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("deleteStock() SQL 연결 중 오류 발생");
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
	
	public int updateByOrder(int pno, String opname, int qty) {
		
		int cnt = -1;

		PreparedStatement ps = null;

		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "update stock set count=count-? where pno=? and opname=?"; // stock���� ��� qty�� ������ �� ������� ��?
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, qty);
			ps.setInt(2, pno);
			ps.setString(3, opname);
			
			// 4. SQL�� ����
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("updateByOrder() SQL 연결 중 오류 발생");
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
