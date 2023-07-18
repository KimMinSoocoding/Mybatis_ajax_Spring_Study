package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.BoardDAO;

public class BwriteCommand implements Bcommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardDAO dao = new BoardDAO();
		dao.write(bname, btitle, bcontent);
		
		return "list.do";
	}
}
