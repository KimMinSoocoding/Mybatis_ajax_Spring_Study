package ez.web.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// Connection 객체 생성
	public void getConnection() {
		String url = "jdbc:mysql://localhost:3306/sys";
		String user = "root";
		String pw = "6845alstn";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,user, pw);
			System.out.println("데이터베이스 연결 성공!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	// 글등록
	public void write(String bname, String btitle, String bcontent) {
		// 등록될 글의 일련번호를 얻어오는 sql
		String sql = "SELECT max(bid)+1 from board";
		getConnection();
		
		int currVal = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// currVal : 새로 등록될 bid 값
			if(rs.next()) currVal = rs.getInt(1);
			
			sql = "INSERT INTO board(bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent) "
				+ "VALUES(?,?,?,now(),0,?,0,0)";
		
			ps = conn.prepareStatement(sql);
			ps.setString(1, bname);
			ps.setString(2, btitle);
			ps.setString(3, bcontent);
			// currVal를 bgroup에 셋팅
			ps.setInt(4, currVal);
			
			ps.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	// 리스트
	public ArrayList<BoardDTO> list(){
		ArrayList<BoardDTO> dtos = new ArrayList<BoardDTO>();
		String sql = "SELECT * FROM board ORDER BY bgroup desc, bstep asc";
		
		getConnection();
		
		try {
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				
				BoardDTO dto = new BoardDTO(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
				
				dtos.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return dtos;
	}
	
	// 게시글 보기
	public BoardDTO view(int inputBid) {
		
		// 조회수 증가
		plusHit(inputBid);
		
		String sql = "SELECT * FROM board WHERE bid = ?";
		getConnection();
		BoardDTO dto = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, inputBid);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				
				dto = new BoardDTO(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
				
				System.out.println(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return dto;
	}
	
	// 게시글 수정
	public void update(String bid, String bname, String btitle, String bcontent) {
		String sql = "UPDATE board SET bname=?, btitle=?, bcontent=? "
				+ "WHERE bid = ?";
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bname);
			ps.setString(2, btitle);
			ps.setString(3, bcontent);
			ps.setString(4, bid);
			
			ps.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	// 게시글 삭제
	public void delete(String bid) {
		String sql = "DELETE FROM board WHERE bid = ?";
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(bid));
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	// 조회수 증가
	public void plusHit(int bid) {
		String sql = "UPDATE board SET bhit = bhit + 1"
				+ " WHERE bid = ?";
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			
			ps.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}
				
	}
	
	// 답글 
	public BoardDTO replyView(String rbid) {
		BoardDTO dto = null;
		String sql = "SELECT * FROM board WHERE bid = ?";
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(rbid));
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				
				dto = new BoardDTO(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return dto;
	}
	
	// 답글 등록
	public void addReply(String bid, String bname, String btitle, String bcontent, String bgroup, String bstep, String bindent) {
		
		replyOrder(bgroup, bstep);
		
		String sql = "INSERT INTO board(bname, btitle, bcontent, bgroup, bstep, bindent) values(?,?,?,?,?,?)";
		
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, bname);
			ps.setString(2, btitle);
			ps.setString(3, bcontent);
			
			ps.setInt(4, Integer.parseInt(bgroup));
			ps.setInt(5, Integer.parseInt(bstep)+1);
			ps.setInt(6, Integer.parseInt(bindent)+1);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	// 새로운 답글이 추가되었을 때 기존에 답글에 1씩 증가
	public void replyOrder(String bgroup, String bstep) {
		// 매개변수 bgroup과 db에 bgroup이 같고 bstep이 큰 레코드를 찾아서 1씩 증가 
		String sql = "UPDATE board SET bstep = bstep+1 "
				+ "WHERE bgroup =? and bstep > ?";
		
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(bgroup));
			ps.setInt(2, Integer.parseInt(bstep));
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	
	
	
	
	
}
