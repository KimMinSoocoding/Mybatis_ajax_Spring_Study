package ez.web.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.StudentDAO;
import ez.web.model.StudentDTO;

public class SsearchCommand implements Scommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sName = request.getParameter("sName");
		
		StudentDAO dao = new StudentDAO();
		ArrayList<StudentDTO> dtos = dao.search(sName);
		
		request.setAttribute("list", dtos);
	}
}
