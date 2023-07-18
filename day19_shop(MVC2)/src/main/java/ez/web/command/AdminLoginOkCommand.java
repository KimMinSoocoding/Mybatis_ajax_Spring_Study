package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ez.web.model.AdminDAO;
import ez.web.model.AdminDTO;

public class AdminLoginOkCommand implements ShopCommand{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		AdminDAO dao = AdminDAO.getInstance();
		
		
		int chkNum = dao.adminCheck(id, pw);
		// 세션객체 만들기 
		HttpSession session = request.getSession();
		
	if(chkNum == dao.ADMIN_LOGIN_NOT){
		request.setAttribute("loginErr", "idErr");
	}else if(chkNum == dao.ADMIN_LOGIN_PW_FAIL){
		request.setAttribute("loginErr", "pwErr");
	}else if(chkNum == dao.ADMIN_LOGIN_SUCCESS){
		AdminDTO dto = dao.getAdminInfo(id);
		
		String name = dto.getName();
		session.setAttribute("id", id);
		session.setAttribute("name", name);
		session.setAttribute("isLogin", "yes");
		
		// user와 관리자를 구분하기 위한 용도 
		session.setAttribute("memberInfo", "admin");
//		response.sendRedirect("ad_main.jsp");
	}
		String viewPage = null; 
		if(request.getAttribute("loginErr") != null ) {	
			viewPage = "/admin/ad_login.jsp";
		}else { // 로그인 성공 
			viewPage = "/admin/ad_min.jsp";
		}
		return viewPage;
}
}