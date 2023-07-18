package ez.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.model.MemberDAO;
import web.model.MemberDTO;

public class MemberListController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// FrontController의 업무를 대신 정의
		
		// DB에 있는 회원정보 가져오기(Model 연동)
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> memberList = dao.memberList();
		
		// Object Binding
		request.setAttribute("list", memberList);
		
		// View page
//		return "/WEB-INF/member/memberList.jsp";
		return "memberList";
	}
}
