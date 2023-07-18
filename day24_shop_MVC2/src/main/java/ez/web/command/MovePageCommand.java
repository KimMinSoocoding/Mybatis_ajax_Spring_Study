package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MovePageCommand implements ShopCommand {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//FrontController에서 바인딩한 cmd를 가져오기 
		String cmd = (String)request.getAttribute("cmd");
		
		String viewPage = null;
		if(cmd.equals("/adminLogin.do")) {
			viewPage="/admin/ad_login.jsp";
		}else if(cmd.equals("/adminCatInput.do")) {
			viewPage = "/admin/cat_input.jsp";
		}else if(cmd.equals("adminMain.do")) {
		viewPage = "/admin/ad_main.jsp";
		}
		
		return viewPage;
	}

}
