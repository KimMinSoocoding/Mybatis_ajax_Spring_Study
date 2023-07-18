package ez.web.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.BoardDAO;
import ez.web.model.BoardDTO;

public class BlistCommand implements Bcommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> dtos=dao.list();
		
		// 바인딩 처리
		request.setAttribute("list", dtos);
		
		return "list";
	}
}
