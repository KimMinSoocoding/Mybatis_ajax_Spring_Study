package board.model;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.JdbcUtil;

public class BoardDAO {
	private JdbcUtil ju;
	
	public BoardDAO() {
		ju = JdbcUtil.getInstance();
	}
	
	//삽입c
	public int insert(BoardDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "Insert into board (num, title, writer, content, regdate, cnt)\n"
				+ "values(board_seq.nextval,?,?,?,sysdate,0)";
		// 문제가 생길상황을 대비하여 변수를 만들어둔다 0또는 문제가 있다면 -1
		int ret = -1;
		try {
			// jdbcutil로 부터 커넥션을 얻어오면 됨 
			con = ju.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getContent());
			ret = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
				if(con!=null) {
					try {
						con.close();
				} catch (SQLException e) {
						e.printStackTrace();
				}
			}
		}
		return ret;
	}

	
	//조회r
	public List<BoardDTO> selectAll(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "select num, title, writer, content, regdate, cnt from board";
		ArrayList<BoardDTO> ls = new ArrayList<BoardDTO>();
		try {
			con = ju.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			// 가져온 레코드 수 만큼 반복을 하게함 
			while(rs.next()) {
				BoardDTO dto = new BoardDTO(
						rs.getInt(1),
						rs.getString(2),
						rs.getNString(3),
						rs.getNString(4),
						new Date(rs.getDate(5).getTime()),
						rs.getInt(6));
				// 가져온 객체들을 ls(ArrayList에 담는다)
				ls.add(dto);
						
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs !=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
				if(con!=null) {
					try {
						con.close();
				} catch (SQLException e) {
						e.printStackTrace();
				}
			}
		}
		return ls;
	}
	//조회r
		public BoardDTO selectOne(int num){
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String query = "select num, title, writer, content, regdate, cnt from board where num =?";
			BoardDTO dto = null;
			try {
				con = ju.getConnection();
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, num);
				rs = pstmt.executeQuery();
				// 가져온 레코드 수 만큼 반복을 하게함 
				if(rs.next()) {
					 dto = new BoardDTO(
							rs.getInt(1),
							rs.getString(2),
							rs.getNString(3),
							rs.getNString(4),
							new Date(rs.getDate(5).getTime()),
							rs.getInt(6));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally{
				if(rs !=null) {
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}	
				if(pstmt!=null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}	
					if(con!=null) {
						try {
							con.close();
					} catch (SQLException e) {
							e.printStackTrace();
					}
				}
			}
			return dto;
		}
		
	
	//수정u
	
	//삭제d
} 
