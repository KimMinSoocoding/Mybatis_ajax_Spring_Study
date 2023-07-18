package ez.web.frontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.command.BaddReplyCommand;
import ez.web.command.Bcommand;
import ez.web.command.BdeleteCommand;
import ez.web.command.BlistCommand;
import ez.web.command.BreplyViewCommand;
import ez.web.command.BupdateCommand;
import ez.web.command.BviewCommand;
import ez.web.command.BwriteCommand;

// @WebServlet("*.do")
public class BoardFrontController_old extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();		
		String ctx = request.getContextPath();
		String cmd = uri.substring(ctx.length());
		System.out.println("cmd : " + cmd);
		
		Bcommand command = null;
		String viewPage = null;
		
		if(cmd.equals("/writeView.do")) {
			viewPage = "write_form";
		}else if(cmd.equals("/write.do")) {
			command = new BwriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}else if(cmd.equals("/list.do")) {
			command = new BlistCommand();
			command.execute(request, response);
			viewPage = "list";
		}else if(cmd.equals("/view.do")) {
			command = new BviewCommand();
			command.execute(request, response);
//			viewPage = "WEB-INF/board/view.jsp";
			viewPage = "view";
		}else if(cmd.equals("/update.do")) {
			command = new BupdateCommand();
			command.execute(request, response);
			
			viewPage = "list.do";
		}else if(cmd.equals("/delete.do")) {
			command = new BdeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}else if(cmd.equals("/replyView.do")) {
			command = new BreplyViewCommand();
			command.execute(request, response);
			
//			viewPage = "WEB-INF/board/reply_form.jsp";
			viewPage = "reply_form";
		}else if(cmd.equals("/addReply.do")) {
			command = new BaddReplyCommand();
			command.execute(request, response);
			
			viewPage = "list.do";
		}
		
		RequestDispatcher rd = null;
		if(viewPage.indexOf(".do") !=-1) {
			rd = request.getRequestDispatcher(viewPage);
		}else {
			rd = request.getRequestDispatcher("WEB-INF/board/"+viewPage+".jsp");
		}
		
		
//		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}
}
