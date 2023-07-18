package ez.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.model.MemberDAO;

public class MemberDeleteController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ctx = request.getContextPath(); // --> /day07
		
		// 삭제할 회원 no 파라미터 수집
		int no = Integer.parseInt(request.getParameter("no"));
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.delMember(no);
		
		String viewPage = null;
		
		if(cnt > 0) {
			// 세션 초기화
			request.getSession().invalidate();
			viewPage = "redirect:"+ctx+"/memberList.do";
		}else {
			throw new ServletException("회원 삭제 실패!!");
		}
		return viewPage;
	}
}
