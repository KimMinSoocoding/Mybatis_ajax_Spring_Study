package flower.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	public static final int MEMBER_JOIN_SUCCESS=1;
	public static final int MEMBER_JOIN_FAIL=0;
	public static final int MEMBER_LOGIN_SUCCESS=1;
	public static final int MEMBER_LOGIN_NOT_PASSWORD=0;
	public static final int MEMBER_LOGIN_NOT=-1;
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	DataSource ds = null;
	
	// 싱글톤 패턴 적용하기
	private static MemberDAO instance;
	
	private MemberDAO() {}
	
	public static MemberDAO getInstance() {
		if(instance == null) {
			instance = new MemberDAO();
		}
		
		return instance;
	}
	
	public Connection getConnection() {
		Context ctx = null;
//		DataSource ds = null;
//		Connection conn = null;
		
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
	
	
	// 회원저장
	public int memberInsert(MemberDTO dto) {
		String sql = "INSERT INTO flower_shopMember VALUES(?,?,?,?,?,?,sysdate)";
		
		// Connection 객체 생성
		getConnection();
		
		int cnt = -1;
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getTel());
			ps.setString(5, dto.getEmail());
			ps.setString(6, dto.getAddr());
			
			// 정상적으로 수행되면 리턴값은 0 보다 큼
			ps.executeUpdate();
			cnt = MemberDAO.MEMBER_JOIN_SUCCESS;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return cnt;
	}
	
	// 로그인 체크
	public int memberCheck(String id, String pw) {
		int n = -1;
		
		String sql = "SELECT pw FROM flower_shopMember WHERE id = ?";
		
		conn = getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {// 아이디가 존재
				String dbPw = rs.getString("pw");
				if(dbPw.equals(pw)) { // 로그인 성공
					n = MemberDAO.MEMBER_LOGIN_SUCCESS;
				}else { // 비밀번호가 틀림
					n = MemberDAO.MEMBER_LOGIN_NOT_PASSWORD;
				}
			}else { // 아이디가 존재하지 않는 경우
				n = MemberDAO.MEMBER_LOGIN_NOT;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return n;
	}
	
	
	// 회원 정보 가져오기
	public MemberDTO getMember(String id) {
		MemberDTO dto = null;
		String sql = "SELECT * FROM flower_shopMember WHERE id = ?";
		getConnection();
		
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			// 한회원에 대한 정보만 가져오기 때문에 while문 필요없음.
			// ArrayList도 필요없음.
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setEmail(rs.getString("email"));
				dto.setAddr(rs.getString("addr"));
				dto.setRdate(rs.getTimestamp("rDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		// 한 회원정보를 반환
		return dto;
	}
	
}
