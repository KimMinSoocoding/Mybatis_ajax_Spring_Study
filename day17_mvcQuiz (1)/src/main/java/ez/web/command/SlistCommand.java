package ez.web.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.StudentDAO;
import ez.web.model.StudentDTO;


public class SlistCommand implements Scommand{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		
		// 전체 학생 수
		int totalCnt = dao.getListCount();
		
		int currentPage = 1;
		int currentBlock = 0;
		int blockSize = 5;
		int limit = 10; // 한페이지 당 보여줄 학생수
		
		// 전체 페이지
		int totalPage =(int)Math.ceil((double)totalCnt/limit);
		
		/////////////////////////////////////////////.
		// 이전, 다음 버튼 클릭, 페이지번호 클릭시 currentPage 재설정, currentBlock 재설정
		if(request.getParameter("currentPage") !=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			currentBlock = (currentPage - 1)/blockSize;
		}
		
		
		//////////////////////////////////////////////
		
		
//		ArrayList<StudentDTO> dtos =dao.list();
		ArrayList<StudentDTO> dtos =dao.list(currentPage, limit);
		
		int blockStart = currentBlock*blockSize + 1;
		
		int blockEnd = blockStart + (blockSize - 1);
		
		if(blockEnd > totalPage) blockEnd = totalPage;
		
		int prevPage = blockStart -1;
		int nextPage = blockEnd + 1;
		
		if(nextPage > totalPage) nextPage = totalPage;
		
		
		//object Binding
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("prevPage", prevPage);
		request.setAttribute("nextPage", nextPage);
		request.setAttribute("blockStart", blockStart);
		request.setAttribute("blockEnd", blockEnd);
		request.setAttribute("list", dtos);
	}
}
