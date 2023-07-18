package order;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cart.CartBean;
import member.MemberBean;

public class OrderDao {
	private Connection conn = null;

	private static OrderDao instance;

	public static OrderDao getInstance() {
		if (instance == null) {
			instance = new OrderDao();
		}
		return instance;
	}

	private OrderDao(){
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
	
	public ArrayList<OrderBean> getAllOrder(){
		
		ArrayList<OrderBean> list = new ArrayList<OrderBean>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "select o.no, o.id, p.name, p.mainimgn, o.opname, o.qty, o.price, to_char(o.time, 'YYYY-MM-DD HH24:MI:SS') as time, o.receiver, o.rv_hp1, o.rv_hp2, o.rv_hp3, o.rv_zip, o.rv_addr1, o.rv_addr2, o.memo\r\n"
					+ "from product p inner join (select o.no, m.id, o.pno, o.opname, o.qty, o.price, o.time, o.receiver, o.rv_hp1, o.rv_hp2, o.rv_hp3, o.rv_zip, o.rv_addr1, o.rv_addr2, o.memo\r\n"
					+ "from member m inner join orderlist o\r\n"
					+ "on m.no = o.mno) o\r\n"
					+ "on p.no = o.pno";
			ps = conn.prepareStatement(sql);

			// 4. SQL�� ����
			rs = ps.executeQuery();

			while(rs.next()) {
				OrderBean obean = new OrderBean();
				
				obean.setNo(rs.getInt("no"));
				obean.setId(rs.getString("id"));
				obean.setName(rs.getString("name"));
				obean.setMainimgn(rs.getString("mainimgn"));
				obean.setOpname(rs.getString("opname"));
				obean.setQty(rs.getInt("qty"));
				obean.setPrice(rs.getInt("price"));
				obean.setTime(rs.getString("time"));
				obean.setReceiver(rs.getString("receiver"));
				obean.setRv_hp1(rs.getString("rv_hp1"));
				obean.setRv_hp2(rs.getString("rv_hp2"));
				obean.setRv_hp3(rs.getString("rv_hp3"));
				obean.setRv_zip(rs.getString("rv_zip"));
				obean.setRv_addr1(rs.getString("rv_addr1"));
				obean.setRv_addr2(rs.getString("rv_addr2"));
				obean.setMemo(rs.getString("memo"));
				
				list.add(obean);
			}
			
		} catch (SQLException e) {
			System.out.println("getAllOrder() 연결 중 오류 발생");
			System.out.println(e);
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return list;
	}
	
	public ArrayList<OrderBean> getAllOrderById(String id){
		
		ArrayList<OrderBean> list = new ArrayList<OrderBean>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "select o.no, o.id, p.name, p.mainimgn, o.opname, o.qty, o.price, to_char(o.time, 'YYYY-MM-DD HH24:MI:SS') as time, o.receiver, o.rv_hp1, o.rv_hp2, o.rv_hp3, o.rv_zip, o.rv_addr1, o.rv_addr2, o.memo\r\n"
					+ "from product p inner join (select o.no, m.id, o.pno, o.opname, o.qty, o.price, o.time, o.receiver, o.rv_hp1, o.rv_hp2, o.rv_hp3, o.rv_zip, o.rv_addr1, o.rv_addr2, o.memo\r\n"
					+ "from member m inner join orderlist o\r\n"
					+ "on m.no = o.mno) o\r\n"
					+ "on p.no = o.pno where id=?";
			ps = conn.prepareStatement(sql);

			ps.setString(1, id);
			
			// 4. SQL�� ����
			rs = ps.executeQuery();

			while(rs.next()) {
				OrderBean obean = new OrderBean();
				
				obean.setNo(rs.getInt("no"));
				obean.setId(rs.getString("id"));
				obean.setName(rs.getString("name"));
				obean.setMainimgn(rs.getString("mainimgn"));
				obean.setOpname(rs.getString("opname"));
				obean.setQty(rs.getInt("qty"));
				obean.setPrice(rs.getInt("price"));
				obean.setTime(rs.getString("time"));
				obean.setReceiver(rs.getString("receiver"));
				obean.setRv_hp1(rs.getString("rv_hp1"));
				obean.setRv_hp2(rs.getString("rv_hp2"));
				obean.setRv_hp3(rs.getString("rv_hp3"));
				obean.setRv_zip(rs.getString("rv_zip"));
				obean.setRv_addr1(rs.getString("rv_addr1"));
				obean.setRv_addr2(rs.getString("rv_addr2"));
				obean.setMemo(rs.getString("memo"));
				
				list.add(obean);
			}
			
		} catch (SQLException e) {
			System.out.println("getAllOrderById() 연결 중 오류 발생");
			System.out.println(e);
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return list;
	}
	
	public int insertOrder(CartBean ctbean, MemberBean mbean) {
		int cnt = -1;

		PreparedStatement ps = null;

		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "insert into orderlist values(orderseq.nextval,?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, mbean.getNo());
			ps.setInt(2, ctbean.getPno());
			ps.setString(3, ctbean.getOpname());
			ps.setInt(4, ctbean.getQty());
			ps.setInt(5, ctbean.getOneprice());
			ps.setString(6, mbean.getName());
			ps.setString(7, mbean.getHp1());
			ps.setString(8, mbean.getHp2());
			ps.setString(9, mbean.getHp3());
			ps.setString(10, mbean.getZip());
			ps.setString(11, mbean.getAddr1());
			ps.setString(12, mbean.getAddr2());
			ps.setString(13, mbean.getMemo());

			// 4. SQL�� ����
			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("insertOrder() 연결 중 오류 발생");
			System.out.println(e);
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return cnt;
	}
}