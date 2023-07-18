package ez.web.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class StudentDAO {
   Connection conn;
   PreparedStatement ps;
   ResultSet rs;
   DataSource ds;
   
   public Connection getConnect() {
      Context ctx;
      try {
         ctx = new InitialContext();
         ds = (DataSource)ctx.lookup("java:comp/env/jdbc_mysql");
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
   
   // 전체 학생수(레코드 수) 
   public int getListCount() {
	   int n = 0;
	   
	   getConnect();
	   String sql = "SELECT count(*) FROM student";
	   
	   try {
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			n = rs.getInt(1);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		dbClose();
	}
	   
	   return n;
   }
   
   
   
   // 학생 등록
   public void register(String sName, int sAge, String sGender, 
                   String sEmail, String sMajor) {
      String sql = "INSERT INTO student(sName, sAge, sGender, sEmail, sMajor)"
            + " VALUES(?,?,?,?,?)";
      
      // 커넥션 얻어오기
      getConnect();
      
      try {
         ps = conn.prepareStatement(sql);
         ps.setString(1, sName);
         ps.setInt(2, sAge);
         ps.setString(3, sGender);
         ps.setString(4, sEmail);
         ps.setString(5, sMajor);
         
         ps.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         dbClose();
      }
   }
   
   // 학생 리스트
//   public ArrayList<StudentDTO> list(){
	   public ArrayList<StudentDTO> list(int currentPage, int limit){
	   ArrayList<StudentDTO>  dtos = new ArrayList<StudentDTO>();
	   String sql = "SELECT * FROM student ORDER BY sid LIMIT ?, ?";
	   
	   getConnect();
	   
	   try {
		
		   // current Page = 1, 2, 3, ...... 
		   // begin = 0, 10, 20, 30 ..... 
		// LIMIT 0,10 => 실제 처리는 0+1 학생부터 10명 출력 
		 // LIMIT 10, 10 => 실제 처리는 10+1 학생부터 10명  출력 
		 // LIMIT 20, 10 => 실제 처리는 20+1 학생부터 10명  출력 
		   int begin = (currentPage -1)*limit;
		 
		ps = conn.prepareStatement(sql);
		ps.setInt(1, begin);
		ps.setInt(2, limit);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			int sId = rs.getInt("sid");
			String sName = rs.getString("sName");
			int sAge = rs.getInt("sAge");
			String sGender = rs.getString("sGender");
			String sEmail = rs.getString("sEmail");
			String sMajor = rs.getString("sMajor");
			
			StudentDTO dto = new StudentDTO(sId, sName, sAge, sGender, sEmail, sMajor);
			dtos.add(dto);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
        dbClose();
     }
	   
	   return dtos;
   }
   
   
   // 학생정보 가져오기 
   public StudentDTO info(int ssid) {
	   StudentDTO dto = new StudentDTO();
	   String sql = "SELECT * FROM student WHERE sid = ?";
	   getConnect();
	   
	   try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, ssid);
		rs = ps.executeQuery();
		
		if(rs.next()) {
			int sid = rs.getInt("sid");
			String sName = rs.getString("sName");
			int sAge = rs.getInt("sAge");
			String sGender = rs.getString("sGender");
			String sEmail = rs.getString("sEmail");
			String sMajor = rs.getString("sMajor");
			
			dto = new StudentDTO(sid, sName, sAge, sGender, sEmail, sMajor);
		}
	   } catch (SQLException e) {
		   e.printStackTrace();
	   }finally {
		   dbClose();
	   }
	   
	   return dto; 
   }
   
   // 학생정보 수정 
   public void update(int sid, String sEmail, String sMajor) {
	   String sql = "UPDATE student SET sEmail=?, sMajor=? WHERE sid=?";
	   
	   getConnect();
	   
	   try {
		ps = conn.prepareStatement(sql);
		ps.setString(1, sEmail);
		ps.setString(2, sMajor);
		ps.setInt(3, sid);
		ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		dbClose();
	}

   }
			
	// 학생정보 삭제하기 
   public void delete(int sid) {
	   String sql = "DELETE FROM student WHERE sid = ?";
	   getConnect();
	   
	  try {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, sid);
		ps.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		dbClose();
	}
   }
   
   // 학생정보 검색하기
   public ArrayList<StudentDTO> search(String ssName){
	   ArrayList<StudentDTO>  dtos = new ArrayList<StudentDTO>();
	   String sql = "SELECT * FROM student WHERE sName=? ORDER BY sid";
	   
	   getConnect();
	   
	   try {
		ps = conn.prepareStatement(sql);
		ps.setString(1, ssName);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			int sId = rs.getInt("sid");
			String sName = rs.getString("sName");
			int sAge = rs.getInt("sAge");
			String sGender = rs.getString("sGender");
			String sEmail = rs.getString("sEmail");
			String sMajor = rs.getString("sMajor");
			
			StudentDTO dto = new StudentDTO(sId, sName, sAge, sGender, sEmail, sMajor);
			dtos.add(dto);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
        dbClose();
     }
	   
	   return dtos;
   }
   
   
   
   
   
   
   
}