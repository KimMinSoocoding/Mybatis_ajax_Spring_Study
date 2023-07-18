package ez.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.model.MemberDAO;
import web.model.MemberDTO;

public class MemberIdCheckController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id"); // {"id":id} 데이터를 받음
		MemberDAO dao = new MemberDAO();
		String resChk = dao.memberIdChk(id); // Y or N
		
		// ajax함수에서 만든 콜백함수 duplicateChk()인자로 전송
		response.getWriter().print(resChk);
		
		// 비동기 처리를 위해서 페이지명이 없도록 null 처리
		return null;
	}
}
