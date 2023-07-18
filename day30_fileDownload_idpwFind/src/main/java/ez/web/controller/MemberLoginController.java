package ez.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.model.MemberDAO;
import web.model.MemberDTO;

public class MemberLoginController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ctx = request.getContextPath();
		
		String userId = request.getParameter("user_id");
		String pw = request.getParameter("pw");
		
		MemberDTO dto = new MemberDTO();
		dto.setId(userId);
		dto.setPw(pw);
		
		MemberDAO dao = new MemberDAO();
		String userName = dao.memberLogin(dto);
		
		System.out.println("userName : " + userName);
		
		HttpSession session = request.getSession();
		String viewPage = null;
		if(userName !=null) { //인증성공
			//session.setAttribute("msg", "로그인성공!!");
			
			session.setAttribute("userId", userId);
			session.setAttribute("userName", userName);
			viewPage = "index";
			
		}else { //인증 실패
			session.setAttribute("msg", "아이디 또는 비밀번호가 올바르지 않습니다!!");
			viewPage = "redirect:"+ctx+"/memberList.do";
		}
		
		return viewPage;
	}
}
