package test.com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/test.do")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletTest() {
        super();
 
    }
    
    @Override
    	public void init() throws ServletException {
    	System.out.println("init() 메소드 호출");

    	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청메소드를 얻어오기
		String method = request.getMethod();
		
		System.out.println("method:" + method);
		if(method.equals("GET")) {
			doGet(request, response);
		}else {
			doPost(request, response);
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----get방식-----");
		String name = request.getParameter("name");
		System.out.println(name);
		
		// 배열일때 받는 방
		String harr[] = request.getParameterValues("hobby");
		for(String hobby : harr) {
			System.out.println(hobby);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----post방식-----");
		
		// post방식은 한글이 깨지기 때문에 utf로 변환해주어야 한다
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		System.out.println(name);
		
		// 배열일때 받는 방
		String harr[] = request.getParameterValues("hobby");
		for(String hobby : harr) {
			System.out.println(hobby);
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() 메소드 호출");
	}

}
