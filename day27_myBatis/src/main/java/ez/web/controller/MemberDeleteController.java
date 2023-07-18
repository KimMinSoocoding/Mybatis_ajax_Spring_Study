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
//						System.out.println("회원 삭제 완료!!");
			// 회원리스트 페이지 이동
			//response.sendRedirect("/day06/memberList.do");
//			viewPage = "redirect:/day06_2/memberList.do";
			viewPage = "redirect:"+ctx+"/memberList.do";
		}else {
			throw new ServletException("회원 삭제 실패!!");
		}
		return viewPage;
	}
}
