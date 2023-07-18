package flowerCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminMainMoveCommand implements FlowerCommand{

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Controller에서 바인딩한 cmd 가져오기
		String cmd = (String)request.getAttribute("cmd");
		
		String viewPage = null;
		if(cmd.equals("/adminLogin.do")) {
			viewPage ="/floweradmin/ad_login.jsp";
		}else if(cmd.equals("/adminCatInput.do")) {
			viewPage ="/floweradmin/cat_input.jsp";
		}else if(cmd.equals("/adminMain.do")) {
			viewPage ="/floweradmin/ad_main.jsp";
		}else if(cmd.equals("/user_login.jsp")) {
			viewPage = "customer/user_login.jsp";
		}else if(cmd.equals("/userJoin.do")) {
			viewPage = "/customer/user_join.jsp";
		}
		return viewPage;
		
	}
}
