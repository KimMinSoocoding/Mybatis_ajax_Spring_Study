package ez.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AdminDAO {
	
	public static final int ADMIN_LOGIN_SUCCESS = 1;
	public static final int ADMIN_LOGIN_PW_FAIL = 0;
	public static final int ADMIN_LOGIN_NOT = -1;
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	DataSource ds = null;
	
	// 싱글톤 패턴 적용하기
	private static AdminDAO instance;
	
	private AdminDAO() {}
	
	public static AdminDAO getInstance() {
		if(instance == null) {
			instance = new AdminDAO();
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
	
	// 관리자 로그인 체크
	public int adminCheck(String id, String pw) {
		int n = 0;
		String dbPw;
		
		String sql = "SELECT password FROM tbl_admin WHERE id = ?";
		conn = getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dbPw = rs.getString("password");
				if(dbPw.equals(pw)) { // 로그인 성공(비번 일치)
					n=AdminDAO.ADMIN_LOGIN_SUCCESS;
				}else { // 비번 불일치
					n = AdminDAO.ADMIN_LOGIN_PW_FAIL;
				}
			}else {
				n = AdminDAO.ADMIN_LOGIN_NOT;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		
		return n;
	}
	
	// 관리자 정보 가져오기
	public AdminDTO getAdminInfo(String id) {
		AdminDTO dto = null;
		String sql = "SELECT * FROM tbl_admin WHERE id = ?";
		
		conn = getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new AdminDTO();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return dto;
	}
	
	
}
