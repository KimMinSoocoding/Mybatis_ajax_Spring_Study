package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.MemberDAO;
import ez.web.model.MemberDTO;

public class MemberUpdateController implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파라미터 수집
		int no = Integer.parseInt(request.getParameter("no"));
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		// dto로 묶기
		MemberDTO dto = new MemberDTO();
		dto.setNo(no);
		dto.setAge(age);
		dto.setEmail(email);
		dto.setPhone(phone);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberUpdate(dto);
	}
}
