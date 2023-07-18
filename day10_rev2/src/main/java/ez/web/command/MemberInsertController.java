package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.MemberDAO;
import ez.web.model.MemberDTO;

public class MemberInsertController implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		// 1.요청 파라미터 수집
//		int no = Integer.parseInt(request.getParameter("no"));
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		// 형변환의 경우
		int age = Integer.parseInt( request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		// DTO로 묶기
		MemberDTO dto = new MemberDTO();
//		dto.setNo(no);
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.setAge(age);
		dto.setEmail(email);
		dto.setPhone(phone);
		
		System.out.println(dto);
		
		
		// 2.비즈니스 로직 (DB에 저장)
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberInsert(dto);		
		
	}
}
