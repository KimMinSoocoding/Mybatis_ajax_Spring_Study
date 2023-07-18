package ez.web.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.BookDAO;
import ez.web.model.BookDTO;

public class BookListCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
			
		BookDAO dao = new BookDAO();
		ArrayList<BookDTO> dtos = dao.list();
		
		// Binding
		request.setAttribute("bookList", dtos);
	}
}
