package ez.web.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class BookDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// Connection객체 생성
	public void getConnection() {
		String url = "jdbc:mysql://localhost:3306/sample";
		String user = "testUser";
		String pw = "1234";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pw);
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
	
	// 도서 등록
	public void bookAdd(String title, String bookInfo, String author, String publisher, int price, int qty) {
		String sql = "INSERT INTO book(title, bookInfo, author, publisher, price, regDate, qty) VALUES(?,?,?,?,?, now(), ?)";
		
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, bookInfo);
			ps.setString(3, author);
			ps.setString(4, publisher);
			ps.setInt(5, price);
			ps.setInt(6, qty);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	// 도서 리스트 가져오기
	public ArrayList<BookDTO> list(){
		// DB에 있는 책리스트를 담을 컬렉션 생성
		ArrayList<BookDTO> dtos = new ArrayList<BookDTO>();
		
		String sql = "SELECT * FROM book ORDER BY bnum desc";
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int bnum = rs.getInt("bnum");
				String title = rs.getString("title");
				String bookInfo = rs.getString("bookInfo");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				int price = rs.getInt("price");	
				Timestamp regDate = rs.getTimestamp("regDate");
				int qty = rs.getInt("qty");		
				
				BookDTO dto = new BookDTO(bnum, title, bookInfo, author, publisher, price, regDate, qty);
				
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return dtos;
	}
	
	// 도서 상세보기
	public BookDTO view(int num) {
		String sql = "SELECT * FROM book WHERE bnum = ? ";
		
		getConnection();
		BookDTO dto = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int bnum = rs.getInt("bnum");
				String title = rs.getString("title");
				String bookInfo = rs.getString("bookInfo");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				int price = rs.getInt("price");		
				Timestamp regDate = rs.getTimestamp("regDate");
				int qty = rs.getInt("qty");		
				
				dto = new BookDTO(bnum, title, bookInfo, author, publisher, price, regDate, qty);
				System.out.println(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return dto;
	}
	
	// 도서 정보 수정하기
	public void update(int bnum, String title, String bookInfo, String author, String publisher, int price, int qty) {
		String sql = "UPDATE book SET title=?, bookInfo=?, author=?, publisher=?, price=?, qty=? WHERE bnum = ?";
		
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, bookInfo);
			ps.setString(3, author);
			ps.setString(4, publisher);
			ps.setInt(5, price);
			ps.setInt(6, qty);
			ps.setInt(7, bnum);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
	}
	
	// 도서 삭제
	public void delete(int bnum) {
		String sql = "DELETE FROM book WHERE bnum = ?";
		
		getConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bnum);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	
	
}
