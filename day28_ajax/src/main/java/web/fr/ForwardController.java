package web.fr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.model.MemberDTO;

@WebServlet("/fwd.do")
public class ForwardController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name ="Kim";
		int age = 22;
		String email = "test@naver.com";
		
		MemberDTO dto = new MemberDTO();
		dto.setName(name);
		dto.setAge(age);
		dto.setEmail(email);
		
		//Object Binding
		request.setAttribute("dto", dto);
		
		// forward
		RequestDispatcher rd = request.getRequestDispatcher("view/forward.jsp");
		rd.forward(request, response);
		
	}

}
