package ez.web.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.MemberDAO;
import ez.web.model.MemberDTO;

public class MemberListController implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// FrontController의 업무를 대신 정의
		
		// DB에 있는 회원정보 가져오기(Model 연동)
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> memberList = dao.memberList();
		
		// Object Binding
		request.setAttribute("list", memberList);
		
		
	}
}
