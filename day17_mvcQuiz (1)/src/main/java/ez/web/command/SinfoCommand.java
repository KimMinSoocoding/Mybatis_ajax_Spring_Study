package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.StudentDAO;
import ez.web.model.StudentDTO;

public class SinfoCommand implements Scommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sId = Integer.parseInt(request.getParameter("sId"));
		
		StudentDAO dao = new StudentDAO();
		StudentDTO dto = dao.info(sId);
		
		// Object Binding
		request.setAttribute("dto", dto);
	}
}
