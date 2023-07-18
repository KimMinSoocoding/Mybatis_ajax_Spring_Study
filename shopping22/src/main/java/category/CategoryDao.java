package category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CategoryDao {
	
	private Connection conn = null;
	
	private static CategoryDao instance;
	public static CategoryDao getInstance() {
		if(instance == null) {
			instance = new CategoryDao();
		}
		return instance;
	}
	
	private CategoryDao(){
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:comp/env"); 
			DataSource ds = (DataSource) envContext.lookup("jdbc/OracleDB");
			conn = ds.getConnection();
			System.out.println("conn :" + conn);
		} catch (NamingException e) {
			System.out.println("CategoryDao 커넥션 연결 중 오류 발생");
		} catch (SQLException e) {
			System.out.println("CategoryDao 커넥션 연결 중 오류 발생");
		}
	}
	
	public ArrayList<CategoryBean> getAllCategory(){
		
		ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "select lcate.no as lno, lcate.name as lname, lcate.step as lstep, scate.no as sno, scate.name as sname, scate.step as sstep\r\n"
					+ "from (select * from lcategory order by step asc) lcate left outer join (select * from scategory order by lcno asc, step asc) scate\r\n"
					+ "on lcate.no = scate.lcno\r\n"
					+ "order by lstep asc, sstep asc"; 
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CategoryBean cbean = new CategoryBean();
		
				cbean.setLno(rs.getInt("lno"));
				cbean.setLname(rs.getString("lname"));
				cbean.setLstep(rs.getInt("lstep"));
				cbean.setSno(rs.getInt("sno"));
				cbean.setSname(rs.getString("sname"));
				cbean.setSstep(rs.getInt("sstep"));
				
				list.add(cbean);
			}

		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("getAllCategory() ");
		} finally {
			try {
				if (ps != null)
					ps.close();
				
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				System.out.println(e);
				System.out.println("접속 연결 실패");
			}
		}
		return list;
	}//getAllCategory()
	
	public ArrayList<CategoryBean> getOnlyLargeCategory(){
		
		ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "select * from lcategory order by step asc"; 
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CategoryBean cbean = new CategoryBean();
				
				cbean.setLno(rs.getInt("no"));
				cbean.setLname(rs.getString("name"));
				cbean.setLstep(rs.getInt("step"));
				
				list.add(cbean);
			}

		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("getAllCategory() 오류 발생");
		} finally {
			try {
				if (ps != null)
					ps.close();
				
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				System.out.println(e);
				System.out.println("접속 연결 실패");
			}
		}
		return list;
	}//getOnlyLargeCategory()
	
	public ArrayList<CategoryBean> getOnlySmallCategory(int lno){
		
		ArrayList<CategoryBean> list = new ArrayList<CategoryBean>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "select * from scategory where lcno=? order by lcno asc, step asc"; 
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, lno);
			
			// 4. SQL�� ����
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CategoryBean cbean = new CategoryBean();
				
				cbean.setSno(rs.getInt("no"));
				cbean.setSname(rs.getString("name"));
				cbean.setSstep(rs.getInt("step"));
				cbean.setLno(rs.getInt("lcno"));
				
				list.add(cbean);
			}

		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("getAllCategory() 연결 중 오류 발생");
		} finally {
			try {
				if (ps != null)
					ps.close();
				
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				System.out.println(e);
				System.out.println("접속 연결 실패");
			}
		}
		return list;
	}//getOnlySmallCategory()
	
	
	
	public int countLcategory() {
		int cnt = -1;
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "select count(*) as cnt from lcategory";
			ps = conn.prepareStatement(sql);

			// 4. SQL�� ����
			rs = ps.executeQuery();

			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			System.out.println("countLcategory() SQL 연결 중 오류 발생");
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				System.out.println("접속 연결 실패");
			}
		}
		return cnt;
	}
	
	public int countScategory(int lno) { // scategory ���̺��� ��� ���� ���� ��ȯ
		int cnt = -1;
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 3. SQL �ۻ� �� �м�
			String sql = "select count(*) as cnt from scategory where lcno=" + lno;
			ps = conn.prepareStatement(sql);

			// 4. SQL�� ����
			rs = ps.executeQuery();

			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			System.out.println("countScategory() SQL 접속 연결 중 오류 발생");
		} finally {
			try {
				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				System.out.println("접속 연결 실패");
			}
		}
		return cnt;
	}
	
	public int updateDownLStep(int lno, int lstep) { // 2  1
		int cnt = -1;
		
		PreparedStatement ps = null;

		try {
			// 3. SQL �ۻ� �� �м�
			// 2) lno�� step���� 1 ū ������ step�� 1 ���ҽ�Ų��.
			String sql_1 = "update lcategory set step = step-1 where step = ? + 1";
			ps = conn.prepareStatement(sql_1);
			ps.setInt(1, lstep);
			
			// 4. SQL�� ����
			cnt = ps.executeUpdate();
			ps.close();
			
			// 1) lno�� step�� 1 ������Ų��.
			String sql_2 = "update lcategory set step = step+1 where no=?";
			ps = conn.prepareStatement(sql_2);
			ps.setInt(1, lno);
			
			// 4. SQL�� ����
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("updateDownLStep() SQL 접속 연결 중 오류 발생");
		} finally {
			try {
				// �̷��� null �񱳸� ���ְ� ��� ��ȯ�ϸ� �� �Ϻ��ϴٰ� �Ͻ�
				//if (conn != null)
				//	conn.close();

				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println("접속 연결 실패");
			}
		}
		return cnt;
	}
	
	public int updateUpLStep(int lno, int lstep) {
		int cnt = -1;
		
		PreparedStatement ps = null;

		try {
			// 3. SQL �ۻ� �� �м�
			// 2) lno�� step���� 1 ���� ������ step�� 1 ������Ų��.
			String sql_1 = "update lcategory set step = step+1 where step = ? - 1";
			ps = conn.prepareStatement(sql_1);
			ps.setInt(1, lstep);
			
			// 4. SQL�� ����
			cnt = ps.executeUpdate();
			ps.close();
			
			// 1) lno�� step�� 1 ���ҽ�Ų��.
			String sql_2 = "update lcategory set step = step-1 where no=?";
			ps = conn.prepareStatement(sql_2);
			ps.setInt(1, lno);
			
			// 4. SQL�� ����
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("updateUpLStep() SQL 접속 연결 중 오류 발생");
		} finally {
			try {
				// �̷��� null �񱳸� ���ְ� ��� ��ȯ�ϸ� �� �Ϻ��ϴٰ� �Ͻ�
				//if (conn != null)
				//	conn.close();

				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				System.out.println("접속 연결 실패");
			}
		}
		return cnt;
	}
	
	public int updateDownSStep(int lno, int sno, int sstep) {
		int cnt = -1;
		
		PreparedStatement ps = null;

		try {
			// 3. SQL �ۻ� �� �м�
			String sql_1 = "update scategory set step = step-1 where step = ? + 1 and lcno=?";
			ps = conn.prepareStatement(sql_1);
			ps.setInt(1, sstep);
			ps.setInt(2, lno);
			
			// 4. SQL�� ����
			cnt = ps.executeUpdate();
			ps.close();
			
			String sql_2 = "update scategory set step = step+1 where no=?";
			ps = conn.prepareStatement(sql_2);
			ps.setInt(1, sno);
			
			// 4. SQL�� ����
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("updateDownLStep() SQL 접속 연결 중 오류 발생");
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
	
	public int updateUpSStep(int lno, int sno, int sstep) {
		
		int cnt = -1;
		
		PreparedStatement ps = null;

		try {
			// 3. SQL �ۻ� �� �м�
			String sql_1 = "update scategory set step = step+1 where step = ? - 1 and lcno=?";
			ps = conn.prepareStatement(sql_1);
			ps.setInt(1, sstep);
			ps.setInt(2, lno);
			
			// 4. SQL�� ����
			cnt = ps.executeUpdate();
			ps.close();
			
			String sql_2 = "update scategory set step = step-1 where no=?";
			ps = conn.prepareStatement(sql_2);
			ps.setInt(1, sno);
			
			// 4. SQL�� ����
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("updateDownLStep() SQL 연결 중 오류 발생");
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
	
	public int insertLCategory(String lcname) {
		int cnt = -1;

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// 3. SQL �ۻ� �� �м�
			String sql_1 = "select max(step) from lcategory";
			ps = conn.prepareStatement(sql_1);

			int maxStep = -1;

			// 4. SQL�� ����
			rs = ps.executeQuery();
			if (rs.next()) {
				maxStep = rs.getInt(1); // ���ڵ尡 �ƹ��͵� �������� ������ 0�� ��ȯ��
			}
			ps.close();

			String sql_2 = "insert into lcategory values(lcateseq.nextval, ?, ?)";
			ps = conn.prepareStatement(sql_2);
			ps.setString(1, lcname);
			ps.setInt(2, maxStep + 1);

			// 4. SQL�� ����
			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("insertSCategory() SQL 연결 중 오류 발생");
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
	
	public int insertSCategory(int lno, String scname) {
		
		int cnt = -1;
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 3. SQL �ۻ� �� �м�
			String sql_1 = "select max(step) from scategory where lcno=" + lno;
			ps = conn.prepareStatement(sql_1);
			
			int maxStep = -1;
			
			// 4. SQL�� ����
			rs = ps.executeQuery();
			if(rs.next()) {
				maxStep = rs.getInt(1); // ���ڵ尡 �ƹ��͵� �������� ������ 0�� ��ȯ��
			}
			ps.close();
			
			String sql_2 = "insert into scategory values(scateseq.nextval, ?, ?, ?)";
			ps = conn.prepareStatement(sql_2);
			ps.setString(1, scname);
			ps.setInt(2, maxStep+1);
			ps.setInt(3, lno);
			
			// 4. SQL�� ����
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("insertSCategory() SQL 연결 중 오류 발생");
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
	
	public int deleteSCategory(int sno, int sstep){
		
		int cnt = -1;
		
		PreparedStatement ps = null;
		
		try {
			
			// 3. SQL �ۻ� �� �м�
			String sql_1 = "update scategory set step=step-1 where lcno=(select lcno from scategory where no=?) and step>?";
			ps = conn.prepareStatement(sql_1);
			ps.setInt(1, sno);
			ps.setInt(2, sstep);
			
			// 4. SQL�� ����
			cnt = ps.executeUpdate();
			ps.close();
			
			// 3. SQL �ۻ� �� �м�
			String sql_2 = "delete from scategory where no=" + sno;
			ps = conn.prepareStatement(sql_2);
			
			// 4. SQL�� ����
			cnt = ps.executeUpdate();
			ps.close();
			
			

		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("deleteSCategory() SQL 연결 중 오류 발생");
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
	
	
	public int deleteLCategory(int lno, int lstep){
		
		int cnt = -1;
		
		PreparedStatement ps = null;
		
		try {
			
			// 3. SQL �ۻ� �� �м�
			String sql_1 = "update lcategory set step=step-1 where step>?";
			ps = conn.prepareStatement(sql_1);
			ps.setInt(1, lstep);
			
			// 4. SQL�� ����
			cnt = ps.executeUpdate();
			ps.close();
			
			// 3. SQL �ۻ� �� �м�
			String sql_2 = "delete from lcategory where no=" + lno;
			ps = conn.prepareStatement(sql_2);
			
			// 4. SQL�� ����
			cnt = ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("deleteLCategory() SQL 연결 중 오류 발생");
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
	
	public int updateLCategoryName(int lno, String lcname) {
		
		int cnt = -1;
		
		PreparedStatement ps = null;
		
		try {
			
			// 3. SQL �ۻ� �� �м�
			String sql = "update lcategory set name=? where no=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, lcname);
			ps.setInt(2, lno);
			
			// 4. SQL�� ����
			cnt = ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("updateLCategoryName() SQL 연결 중 오류 발생");
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
	
	public int updateSCategoryName(int sno, String scname) {
		
		int cnt = -1;

		PreparedStatement ps = null;

		try {

			// 3. SQL �ۻ� �� �м�
			String sql = "update scategory set name=? where no=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, scname);
			ps.setInt(2, sno);

			// 4. SQL�� ����
			cnt = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("updateLCategoryName() SQL 연결 중 오류 발생");
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

