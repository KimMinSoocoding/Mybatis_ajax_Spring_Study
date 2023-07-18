package ez.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class StudentDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	DataSource ds;
	
	public StudentDAO() {
		try {
//			Context ic = new InitialContext();
//			Context ctx = (Context)ic.lookup("java:comp/env")
//			ds = (DataSource)ctx.lookup("jdbc_mysql");
			
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc_mysql");
		} catch (NamingException e) {			
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
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
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 학생 insert
	public int insertStudent(StudentDTO dto) {
		String stuNo = dto.getStuNo();
		String pw = dto.getPw();
		String name = dto.getName();
		String tel = dto.getTel();
		
		int n = this.insertStudent(stuNo, pw, name, tel);
		
		return n;
	}
	
	public int insertStudent(String stuNo, String pw, String name, String tel) {
		String sql = "INSERT INTO tbl_stu VALUES(?,?,?,?)";
		getConnection();
		
		int n = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, stuNo);
			ps.setString(2, pw);
			ps.setString(3, name);
			ps.setString(4, tel);
			
			n = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return n;
	}
	
	// 학생 전체 리스트
	public ArrayList<StudentDTO> selectAll(){
//		List<StudentDTO> lists = new ArrayList<StudentDTO>();
		ArrayList<StudentDTO> lists = new ArrayList<StudentDTO>();
		String sql = "SELECT * FROM tbl_stu";
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String stuNo = rs.getString("stuNo");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				
				StudentDTO dto = new StudentDTO(stuNo, pw, name, tel);
				System.out.println(dto);
				lists.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		
		return lists;
	}
	
	// 회원 검색 결과 가져오기
	public ArrayList<StudentDTO> findByName(String fName){
		ArrayList<StudentDTO> dtos = new ArrayList<StudentDTO>();
		String sql = "SELECT * FROM tbl_stu WHERE name = ?";
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, fName);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String stuNo = rs.getString("stuNo");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				
				StudentDTO dto = new StudentDTO(stuNo, pw, name, tel);
				dtos.add(dto);
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return dtos;
	}
	
	// 학생 삭제
	public int delStudent(String stuNo) {
		String sql = "DELETE FROM tbl_stu WHERE stuNo = ?";
		getConnection();
		
		int n = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, stuNo);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return n;
	}
}
