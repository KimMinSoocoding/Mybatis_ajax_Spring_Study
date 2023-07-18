package web.fr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rd.do")
public class RedirectController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strData = "Hello World!!";
		
		String name = "kang";
		int age = 30;
		String email = "test@gmail.com";
		
		// View Page로 Data를 전달
		// Controller에서 View로 페이지 전환
		// 1. redirect
		// 2. forward
		
		// sendRedirect는 request 전달을 하지 않기 때문에 객체바인딩을 할 수 없다.
//		request.setAttribute("data", strData);
//		response.sendRedirect("view/redirect.jsp");
		
		response.sendRedirect("view/redirect.jsp?data="+strData+"&name="+name+"&age="+age+"&email="+email);
	}

}
