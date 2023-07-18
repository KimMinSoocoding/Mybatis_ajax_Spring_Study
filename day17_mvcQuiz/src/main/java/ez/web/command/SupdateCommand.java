package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.StudentDAO;

public class SupdateCommand implements Scommand {


	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("sid"));
		String sEmail = request.getParameter("sEmail");
		String sMajor = request.getParameter("sMajor");
		
		StudentDAO dao = new StudentDAO();
		dao.update(sid,sEmail,sMajor);
		

	}

}
