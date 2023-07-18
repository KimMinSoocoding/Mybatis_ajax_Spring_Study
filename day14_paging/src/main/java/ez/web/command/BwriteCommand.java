package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.BoardDAO;

public class BwriteCommand implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardDAO dao = new BoardDAO();
		dao.write(bname, btitle, bcontent);
		
//		for(int i=1; i<=100; i++) {
//			dao.write(bname+i, btitle+"---------------"+i, bcontent);
//		}
	}
}
