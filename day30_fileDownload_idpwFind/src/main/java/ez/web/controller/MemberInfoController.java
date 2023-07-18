package ez.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.model.MemberDAO;
import web.model.MemberDTO;

public class MemberInfoController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println(no);
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.memberInfo(no);
		
		// Object Binding
		request.setAttribute("dto", dto);
		
		// prefix(접두어) : /WEB-INF/member/
		// suffix(접미어) : .jsp
		// 실제 물리적인 경로  : prefix + 파일명 + suffix 
		// 물리적인 경로를 만들어내는 클래스 : ViewResolver라고 한다.
		
//		return "/WEB-INF/member/memberInfo.jsp";
		return "memberInfo";
	}
}
