package web.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// DB에 연결하기 위한 Connection 객체 생성
	public void getConnection() {
		String url ="jdbc:mysql://localhost:3306/sys";
		String user = "root";
		String pw = "6845alstn";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 드라이버가 로딩되면 자동으로 DriverManager에 의해 관리된다.
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스 연결!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	   // 회원저장
	   public int memberInsert(MemberDTO dto) {
	      String sql = "INSERT INTO member3(id, pw, name, age, email, phone, zipcode, road_addr, jibun_addr, detail_addr) "
	            + "values(?,?,?,?,?,?,?,?,?,?)";
	      
	      // Connection 객체 생성
	      getConnection();
	      
	      int cnt = -1;
	      
	      try {
	         ps = conn.prepareStatement(sql);
	         
//	         ps.setInt(1, dto.getNo());
	         ps.setString(1, dto.getId());
	         ps.setString(2, dto.getPw());
	         ps.setString(3, dto.getName());
	         ps.setInt(4, dto.getAge());
	         ps.setString(5, dto.getEmail());
	         ps.setString(6, dto.getPhone());
	         ps.setString(7, dto.getZipcode());
	         ps.setString(8, dto.getRoad_addr());
	         ps.setString(9, dto.getJibun_addr());
	         ps.setString(10, dto.getDetail_addr());
	         
	         // 정상적으로 수행되면 리턴값은 0 보다 큼
	         cnt = ps.executeUpdate();
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         dbClose();
	      }
	      
	      return cnt;
	   }
	   
	   // 회원 전체 리스트
	   public ArrayList<MemberDTO> memberList(){
	      ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
	      
	      String sql = "SELECT * FROM member3";
	      // Connection 생성
	      getConnection();
	      
	      try {
	         ps = conn.prepareStatement(sql);
	         rs = ps.executeQuery(); // ResultSet 리턴
	         
	         while(rs.next()) { // 다음 레코드가 존재하면 True, Cursor 이동
	            int no = rs.getInt("no");
	            String id = rs.getString("id");
	            String pw = rs.getString("pw");
	            String name = rs.getString("name");
	            int age = rs.getInt("age");
	            String email = rs.getString("email");
	            String phone = rs.getString("phone");
	            String zipcode = rs.getString("zipcode");
	            String roadAddr = rs.getString("road_addr");
	            String jibunAddr = rs.getString("jibun_addr");
	            String detailAddr = rs.getString("detail_addr");
	            
	            // dto로 모아서 담는다.
	            MemberDTO dto = new MemberDTO(no, id, pw, name, age, email, phone, zipcode, roadAddr, jibunAddr, detailAddr);
	            // ArrayList에 담기
	            list.add(dto);
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         dbClose();
	      }
	      
	      return list;
	   }
	   
	   // 회원 정보 가져오기
	   public MemberDTO memberInfo(int no) {
	      String sql = "SELECT * FROM member3 WHERE no = ?";
	      getConnection();
	      
	      MemberDTO dto = null;
	      
	      try {
	         ps = conn.prepareStatement(sql);
	         ps.setInt(1, no);
	         rs = ps.executeQuery();
	         
	         // 한회원에 대한 정보만 가져오기 때문에 while문 필요없음.
	         // ArrayList도 필요없음.
	         if(rs.next()) {
	            no = rs.getInt("no");
	            String id = rs.getString("id");
	            String pw = rs.getString("pw");
	            String name = rs.getString("name");
	            int age = rs.getInt("age");
	            String email = rs.getString("email");
	            String phone = rs.getString("phone");
	            String zipcode = rs.getString("zipcode");
	            String roadAddr = rs.getString("road_addr");
	            String jibunAddr = rs.getString("jibun_addr");
	            String detailAddr = rs.getString("detail_addr");
	            
	            // dto로 모아서 담는다.
	            dto = new MemberDTO(no, id, pw, name, age, email, phone, zipcode, roadAddr, jibunAddr, detailAddr);
	            System.out.println("dto : " + dto);
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         dbClose();
	      }
	      
	      // 한 회원정보를 반환
	      return dto;
	   }
	   
	   // 회원 삭제
	   public int delMember(int no) {
	      String sql = "DELETE FROM member3 WHERE no = ?";
	      getConnection();
	      int cnt = -1;
	      
	      try {
	         ps = conn.prepareStatement(sql);
	         ps.setInt(1, no);
	         cnt = ps.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         dbClose();
	      }
	      return cnt;
	   }
	   
	   // 회원 수정
	   public int memberUpdate(MemberDTO dto) {
	      String sql = "UPDATE member3 SET age=?, email=?, phone=? zipcode=?, road_addr=?, jibun_addr=?, detail_addr=?"
	            + "WHERE no=?";
	      getConnection();
	      int cnt = -1;
	      
	      try {
	         ps = conn.prepareStatement(sql);
	         ps.setInt(1, dto.getAge());
	         ps.setString(2, dto.getEmail());
	         ps.setString(3, dto.getPhone());
	         ps.setString(4, dto.getZipcode());
	         ps.setString(5, dto.getRoad_addr());
	         ps.setString(6, dto.getJibun_addr());
	         ps.setString(7, dto.getDetail_addr());
	         ps.setInt(8, dto.getNo());
	         
	         cnt = ps.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         dbClose();
	      }
	      return cnt;
	   }
	   
	   
	   // 자원 반납
	   public void dbClose() {
	         try {
	            if(rs!=null) rs.close();
	            if(ps!=null) ps.close();
	            if(conn!=null) conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	   }
	   
	   
	   
	   
	   
	}