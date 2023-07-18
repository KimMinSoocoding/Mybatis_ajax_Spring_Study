package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.BoardDAO;
import ez.web.model.BoardDTO;

public class BreplyViewCommand implements Bcommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bid = request.getParameter("bid");
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.replyView(bid);
		
		request.setAttribute("replyView", dto);
	}
}
