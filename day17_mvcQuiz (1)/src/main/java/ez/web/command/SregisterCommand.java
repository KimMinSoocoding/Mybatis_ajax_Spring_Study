package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.StudentDAO;

public class SregisterCommand implements Scommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sName = request.getParameter("sName");
		int sAge = Integer.parseInt(request.getParameter("sAge"));
		String sGender = request.getParameter("sGender");
		String sEmail = request.getParameter("sEmail");
		String sMajor = request.getParameter("sMajor");
		
		StudentDAO dao = new StudentDAO();
		dao.register(sName, sAge, sGender, sEmail, sMajor);
		
//		for(int i = 1; i <=100; i++) {
//			dao.register(sName + i, sAge, sGender, sEmail, sMajor+i);
//		}
	}
}
