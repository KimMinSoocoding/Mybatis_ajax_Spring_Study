package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.StudentDAO;
import ez.web.model.StudentDTO;

public class SinfoCommand implements Scommand {


	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sid = Integer.parseInt(request.getParameter("sid"));
		
		StudentDAO dao = new StudentDAO();
		StudentDTO dto = dao.info(sid);
		
		// 오브젝트 바인딩 
		request.setAttribute("dto", dto);
	}

}
