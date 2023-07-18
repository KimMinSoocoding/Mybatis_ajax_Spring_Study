package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.BookDAO;

public class BookUpdateCommand implements BookCommand {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		String title = request.getParameter("title");
		String bookInfo = request.getParameter("bookInfo");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		int price = Integer.parseInt(request.getParameter("price"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		
		BookDAO dao = new BookDAO();
		dao.update(bnum, title, bookInfo, author, publisher, price, qty);
	}
}
