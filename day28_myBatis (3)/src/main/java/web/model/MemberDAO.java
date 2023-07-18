package web.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	private static SqlSessionFactory sqlSessionFactory;
	
	// static 초기화 블럭 : application 실행시 한번만 실행되는 코드 블럭
	static {
		try {
			String resource = "ez/web/mybatis/config.xml";
			InputStream is = Resources.getResourceAsStream(resource);
			
			// build()는 config.xml을 이용해서 커넥션 풀을 만듦
			// sqlSessionFactory 는 커넥션 풀(Connection Pool)을 가리키는 객체 			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // static block
	
	// 회원 전체리스트 가져오기
	public List<MemberDTO> memberList(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// SqlSession = Connection + PreparedStatement
		// + dto로 모으는 기능까지 한꺼번 처리
		List<MemberDTO> list = sqlSession.selectList("memberList");
		sqlSession.close(); // 반납
		return list;
	}
	
	// 회원저장
	public int memberInsert(MemberDTO dto) {
		// openSession()의 기본 인자값은 false, 여기서는 false 생략됨
		SqlSession sqlSession=sqlSessionFactory.openSession();
		int cnt = sqlSession.insert("memberInsert", dto);
		// DB 내용이 수정되기때문에 commit이 필요함
		// openSession(true)이면 AutoCommit이 true이기 때문에 commit() 생략가능
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}
	
	// 회원삭제
	public int delMember(int no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.delete("delMember", no);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}
	
	// 회원정보 상세보기
	public MemberDTO memberInfo(int no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		MemberDTO dto = sqlSession.selectOne("memberInfo", no);
		sqlSession.close();
		return dto;
	}
	
	// 회원정보 수정하기
	public int memberUpdate(MemberDTO dto) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int cnt = sqlSession.update("memberUpdate", dto);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}
	
	// 회원로그인
	public String memberLogin(MemberDTO dto) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String userName = sqlSession.selectOne("memberLogin", dto);
		sqlSession.close();
		return userName;
	}
	
	
}
