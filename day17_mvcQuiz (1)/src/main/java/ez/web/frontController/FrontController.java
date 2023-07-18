package ez.web.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.command.Scommand;
import ez.web.command.SdeleteCommand;
import ez.web.command.SinfoCommand;
import ez.web.command.SlistCommand;
import ez.web.command.SregisterCommand;
import ez.web.command.SsearchCommand;
import ez.web.command.SupdateCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String cmd = uri.substring(ctx.length());
		
		Scommand command = null;
		String viewPage = null;
		
		if(cmd.equals("/register.do")) {
			command = new SregisterCommand();
			command.execute(request, response);
			
			viewPage = "list.do";
		}else if(cmd.equals("/registerView.do")) {
			viewPage = "student/register.jsp";
			
		}else if(cmd.equals("/list.do")) {
			command = new SlistCommand();
			command.execute(request, response);
			
			viewPage = "student/list.jsp";
		}else if(cmd.equals("/info.do")) {
			command = new SinfoCommand();
			command.execute(request, response);
			
			viewPage = "student/info.jsp";
		}else if(cmd.equals("/update.do")) {
			command = new SupdateCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}else if(cmd.equals("/delete.do")) {
			command = new SdeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}else if(cmd.equals("/search.do")) {
			command = new SsearchCommand();
			command.execute(request, response);
			
			viewPage = "student/list.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}
}
