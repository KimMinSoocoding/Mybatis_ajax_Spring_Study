package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.StudentDAO;

public class SupdateCommand implements Scommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sId = Integer.parseInt(request.getParameter("sId"));
		String sEmail = request.getParameter("sEmail");
		String sMajor = request.getParameter("sMajor");
		
		System.out.println("sId : " + sId);
		
		
		StudentDAO dao = new StudentDAO();
		dao.update(sId, sEmail, sMajor);
		
	}
}
