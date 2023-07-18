package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.BoardDAO;
import ez.web.model.BoardDTO;

public class BviewCommand implements Bcommand {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.view(bid);
		
		request.setAttribute("dto", dto);
		
		return "view";
	}
}
