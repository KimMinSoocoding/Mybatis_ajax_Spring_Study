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
import ez.web.command.BookAddCommand;
import ez.web.command.BookCommand;
import ez.web.command.BookDeleteCommand;
import ez.web.command.BookListCommand;
import ez.web.command.BookUpdateCommand;
import ez.web.command.BookViewCommand;
import ez.web.command.BreplyViewCommand;
import ez.web.command.BupdateCommand;
import ez.web.command.BviewCommand;
import ez.web.command.BwriteCommand;

@WebServlet("*.do")
public class BookFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);
		String ctx = request.getContextPath();
		System.out.println("ctx : " + ctx);
		String cmd = uri.substring(ctx.length());
		System.out.println("cmd : " + cmd);
		
		BookCommand command = null;
		Bcommand bbsCommand = null;
		String viewPage = null;
		if(cmd.equals("/bookAddForm.do")) {
			viewPage = "WEB-INF/book/bookAdd.jsp";
		}else if(cmd.equals("/bookAdd.do")) {
			command = new BookAddCommand();
			command.execute(request, response);
			
			viewPage = "bookList.do";
		}else if(cmd.equals("/bookList.do")) {
			command = new BookListCommand();
			command.execute(request, response);
			
			viewPage = "WEB-INF/book/list.jsp";
		}else if(cmd.equals("/bookView.do")) {
			command = new BookViewCommand();
			command.execute(request, response);
			
			viewPage = "WEB-INF/book/view.jsp";
		}else if(cmd.equals("/bookUpdate.do")) {
			command = new BookUpdateCommand();
			command.execute(request, response);
			
			viewPage = "bookList.do";
		}else if(cmd.equals("/bookDel.do")) {
			command = new BookDeleteCommand();
			command.execute(request, response);
			
			viewPage = "bookList.do";
		// 게시판 
		}else if(cmd.equals("/writeView.do")) {
			viewPage = "WEB-INF/board/write_form.jsp";
		}else if(cmd.equals("/write.do")) {
			bbsCommand = new BwriteCommand();
			bbsCommand.execute(request, response);
			viewPage = "list.do";
		}else if(cmd.equals("/list.do")) {
			bbsCommand = new BlistCommand();
			bbsCommand.execute(request, response);
			viewPage = "WEB-INF/board/list.jsp";
		}else if(cmd.equals("/view.do")) {
			bbsCommand = new BviewCommand();
			bbsCommand.execute(request, response);
			viewPage = "WEB-INF/board/view.jsp";
//			viewPage = "view";
		}else if(cmd.equals("/update.do")) {
			bbsCommand = new BupdateCommand();
			bbsCommand.execute(request, response);
			
			viewPage = "list.do";
		}else if(cmd.equals("/delete.do")) {
			bbsCommand = new BdeleteCommand();
			bbsCommand.execute(request, response);
			viewPage = "list.do";
		}else if(cmd.equals("/replyView.do")) {
			bbsCommand = new BreplyViewCommand();
			bbsCommand.execute(request, response);
			
			viewPage = "WEB-INF/board/reply_form.jsp";
//			viewPage = "reply_form";
		}else if(cmd.equals("/addReply.do")) {
			bbsCommand = new BaddReplyCommand();
			bbsCommand.execute(request, response);
			
			viewPage = "list.do";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

}
