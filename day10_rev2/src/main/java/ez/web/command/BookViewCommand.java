package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.BookDAO;
import ez.web.model.BookDTO;

public class BookViewCommand implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		BookDAO dao = new BookDAO();
		BookDTO dto = dao.view(bnum);
		
		// Binding
		request.setAttribute("dto", dto);
	}
}
