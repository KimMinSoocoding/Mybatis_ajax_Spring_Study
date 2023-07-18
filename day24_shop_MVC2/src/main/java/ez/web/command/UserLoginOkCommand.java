package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ez.web.model.MemberDAO;
import ez.web.model.MemberDTO;

public class UserLoginOkCommand implements ShopCommand {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = MemberDAO.getInstance();
		int chkLogin = dao.memberCheck(id, pw);
		
		HttpSession session =request.getSession();
		
		if(chkLogin == MemberDAO.MEMBER_LOGIN_NOT){
			request.setAttribute("loginErr", "idErr");
		}else if(chkLogin == MemberDAO.MEMBER_LOGIN_NOT_PASSWORD){
			request.setAttribute("loginErr", "pwErr");
			session.setAttribute("id", id);
		}else if(chkLogin == MemberDAO.MEMBER_LOGIN_SUCCESS){
			MemberDTO dto = dao.getMember(id);
			if(dto == null){
				
			}else{ 
		  		String name = dto.getName();
		  		
		  		session.setAttribute("id", id);
		  		session.setAttribute("name", name);
		  		
		  		// 로그인 체크를 위한 설정
		  		session.setAttribute("isLogin", "yes");
		  		session.setAttribute("memberInfo", "user");
		  		session.setAttribute("isLogin", "yes");
		  		
//		  		response.sendRedirect("user_main.jsp");
			}// if문
		}
		String viewPage = null;
		if(request.getAttribute("loginErr") !=null) {
			viewPage = "/customer/user_login.jsp";
		}else { // 로그인 성공
			viewPage = "/customer/user_main.jsp";
		}
		
		return viewPage;
	}
}
