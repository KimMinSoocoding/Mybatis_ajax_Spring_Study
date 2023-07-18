package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDao {
	private Connection conn = null;

	private static MemberDao instance;

	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}

	private MemberDao(){
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
	
	public int insertMember(MemberBean mbean) {
	
		int cnt = -1;
		
		PreparedStatement ps = null;
		
		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "insert into member values(memseq.nextval,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);

			ps.setString(1, mbean.getId());
			ps.setString(2, mbean.getPassword());
			ps.setString(3, mbean.getName());
			ps.setString(4, mbean.getRrn1());
			ps.setString(5, mbean.getRrn2());
			ps.setString(6, mbean.getHp1());
			ps.setString(7, mbean.getHp2());
			ps.setString(8, mbean.getHp3());
			ps.setString(9, mbean.getZip());
			ps.setString(10, mbean.getAddr1());
			ps.setString(11, mbean.getAddr2());

			// 4. SQL�� ����
			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println("insertMember() 연결 중 오류 발생");
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
	
	public MemberBean getMemberByInfo(String id, String password) {
		// 2.

		PreparedStatement ps = null;
		ResultSet rs = null;

		MemberBean mbean = null;

		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "select * from member where id=? and password=?";
			ps = conn.prepareStatement(sql);

			ps.setString(1, id);
			ps.setString(2, password);
			
			// 4. SQL�� ����
			rs = ps.executeQuery();
			
			if (rs.next()) {
				mbean = new MemberBean();
				
				mbean.setNo(rs.getInt("no"));
				mbean.setId(rs.getString("id"));
				mbean.setPassword(rs.getString("password"));
				mbean.setRrn1(rs.getString("rrn1"));
				mbean.setRrn2(rs.getString("rrn2"));
				mbean.setHp1(rs.getString("hp1"));
				mbean.setHp2(rs.getString("hp2"));
				mbean.setHp3(rs.getString("hp3"));
				mbean.setZip(rs.getString("zip"));
				mbean.setAddr1(rs.getString("addr1"));
				mbean.setAddr2(rs.getString("addr2"));	
			}
		} catch (SQLException e) {
			System.out.println("getMemberByInfo() 연결 중 오류 발생");
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
		return mbean;
	}
	
	public MemberBean getMemberById(String id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		MemberBean mbean = null;

		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "select * from member where id=?";
			ps = conn.prepareStatement(sql);

			ps.setString(1, id);
			
			// 4. SQL�� ����
			rs = ps.executeQuery();

			if (rs.next()) {
				mbean = new MemberBean();
				
				mbean.setNo(rs.getInt("no"));
				mbean.setId(rs.getString("id"));
				mbean.setPassword(rs.getString("password"));
				mbean.setName(rs.getString("name"));
				mbean.setRrn1(rs.getString("rrn1"));
				mbean.setRrn2(rs.getString("rrn2"));
				mbean.setHp1(rs.getString("hp1"));
				mbean.setHp2(rs.getString("hp2"));
				mbean.setHp3(rs.getString("hp3"));
				mbean.setZip(rs.getString("zip"));
				mbean.setAddr1(rs.getString("addr1"));
				mbean.setAddr2(rs.getString("addr2"));
			}
		} catch (SQLException e) {
			System.out.println("getMemberById() 연결 중 오류 발생");
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
		return mbean;
	}
}
