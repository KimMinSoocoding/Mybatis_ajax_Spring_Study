package ez.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class CategoryDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	DataSource ds = null;
	
	// 싱글톤
	private static CategoryDAO instance;
	
	private CategoryDAO() {}
	
	public static CategoryDAO getInstance() {
		if(instance == null) {
			instance = new CategoryDAO();
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
	
	// 카테고리 등록
	public int insertCategory(String code, String cname) {
		int n = -1;
		String sql = "INSERT INTO category VALUES(cat_seq.nextVal,?,?)";
		conn=getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, code);
			ps.setString(2, cname);
			n = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return n;
	}
	
	// 카테고리 리스트 
	public ArrayList<CategoryDTO> categoryList(){
		ArrayList<CategoryDTO> dtos = new ArrayList<CategoryDTO>();
		
		String sql = "SELECT * FROM category ORDER BY cat_num DESC";
		conn = getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int catNum = rs.getInt("cat_num");
				String code = rs.getString("code");
				String catName = rs.getString("cat_name");
				
				CategoryDTO dto = new CategoryDTO(catNum, code, catName);
				dtos.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return dtos;
	}
	
	// 카테고리 삭제
	public int categoryDel(String catNum) {
		int n = -1;
		String sql = "DELETE FROM category WHERE cat_num = ?";
		conn = getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, catNum);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return n;
	}
	
	
}
