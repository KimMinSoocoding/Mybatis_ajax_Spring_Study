package web.frontController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.controller.Controller;
import ez.web.controller.MemberDeleteController;
import ez.web.controller.MemberInfoController;
import ez.web.controller.MemberInsertController;
import ez.web.controller.MemberListController;
import ez.web.controller.MemberRegisterController;
import ez.web.controller.MemberUpdateController;
import web.model.MemberDAO;
import web.model.MemberDTO;

@WebServlet("*.do")
public class FrontController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 클라이언트가 어떤 요청을 했는지 파악하기
		String uri = request.getRequestURI();
		System.out.println("uri: " + uri);
		
		// Context Path : /day06
		String ctx = request.getContextPath();
		System.out.println("ctx : " + ctx);
		
		// Client가 실제 요청한 명령
		String command = uri.substring(ctx.length());
		System.out.println("command : " + command);
		
		Controller controller = null;
		String viewPage = null;
		// 요청 명령에 따른 분기 작업 if ~ else if~
//		if(command.equals("/memberList.do")) {
//			controller = new MemberListController();
//			viewPage = controller.requestHandler(request, response);
//		}else if(command.equals("/memberInsert.do")) {
//			controller = new MemberInsertController();
//			viewPage = controller.requestHandler(request, response);			
//		}else if(command.equals("/memberRegister.do")) {
//			controller = new MemberRegisterController();
//			viewPage = controller.requestHandler(request, response);
//		}else if(command.equals("/memberInfo.do")) {
//			controller = new MemberInfoController();
//			viewPage = controller.requestHandler(request, response);
//		}else if(command.equals("/memberUpdate.do")) {
//			controller = new MemberUpdateController();
//			viewPage = controller.requestHandler(request, response);
//		}else if(command.equals("/memberDel.do")) {
//			controller = new MemberDeleteController();
//			viewPage = controller.requestHandler(request, response);
//		}
		
		// HandlerMapping 구현객체
		HandlerMapping hm = new HandlerMapping();
		// command => /memberInfo.do, /memberDel.do, .... 
		controller = hm.getController(command);
		viewPage = controller.requestHandler(request, response);
		
		// forward와 redirect 구별
		if(viewPage !=null) {
			if(viewPage.indexOf("redirect:") != -1) { // redirect
				response.sendRedirect(viewPage.split(":")[1]);
			}else { // forward
//				RequestDispatcher rd = request.getRequestDispatcher(viewPage);
//				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/member/"+viewPage+".jsp");
				RequestDispatcher rd = request.getRequestDispatcher(ViewResolver.getPath(viewPage));
				rd.forward(request, response);
			}
		}
	}
}
