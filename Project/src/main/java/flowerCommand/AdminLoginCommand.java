package flowerCommand;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import flower.model.AdminDAO;
import flower.model.AdminDTO;


public class AdminLoginCommand implements FlowerCommand{

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println(pw);
		System.out.println(id);
		
		AdminDAO dao = AdminDAO.getInstance();
		int chkNum = dao.adminOk(id, pw);
		
		// 세션 (웹 브라우저 값을 저장 혹은 불러오기)
		HttpSession session = request.getSession();
		
		if(chkNum == dao.ADMIN_LOGIN_NOT) {
			request.setAttribute("loginErr", "idErr");
		}else if(chkNum == dao.ADMIN_LOGIN_PW_FAIL) {
			request.setAttribute("loginErr", "pwErr");
			session.setAttribute("id", id);
		}else if(chkNum == dao.ADMIN_LOGIN_SUCCESS) {
			AdminDTO dto = dao.getAdminInfo(id);
			
			String name = dto.getName();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("isLogin", "yes");
			// 일반회원과 관리자를 구분하기 위한 용도 
			session.setAttribute("memberInfo", "admin");
		}
		
		String viewPage = null;
		
		// 로그인 실패 
		if(request.getAttribute("loginErr") != null) {
			viewPage = "/floweradmin/ad_login.jsp";
		}else { // 로그인 성공 
			viewPage = "/floweradmin/ad_main.jsp";
		}
		

		return viewPage;
	}

}
