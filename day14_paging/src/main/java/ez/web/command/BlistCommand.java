package ez.web.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.BoardDAO;
import ez.web.model.BoardDTO;

public class BlistCommand implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		
		
		// 전체게시글 수 구하기
		int totalCnt =  dao.getListCount();
		System.out.println("전체 게시글 수 : "+ totalCnt);
		
		int currentPage = 1; // 현재페이지 1부터 시작
		int currentBlock = 0; // 블럭은 0부터 시작
		int blockSize = 5; // 블럭 사이즈 설정
		int limit = 10; // 한페이지당 보여줄 게시글 수
		
		// 전체 페이지 수(번호)
		int totalPage = (int)Math.ceil((double)totalCnt/limit);

		// 뷰에서 페이지번호를 클릭했을 때 처리, 이전 / 다음 버튼을 클릭했을 때 처리
		if(request.getParameter("currentPage") !=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
			
			// 이전/ 다음 버튼 클릭시 블럭위치 계산
			currentBlock = (currentPage - 1)/blockSize;
		}
		
//		ArrayList<BoardDTO> dtos=dao.list();
		ArrayList<BoardDTO> dtos=dao.list(currentPage, limit);
		
		// 블럭의 시작페이지 번호(currentBlock에 따라 계산)
		int blockStart = currentBlock * blockSize + 1;
		
		// 블럭의 마지막페이지 번호
		int blockEnd = blockStart +(blockSize - 1);
		
		// 블럭의 마지막페이지 번호는 전체페이지번호를 초과할 수 없다.
		if(blockEnd > totalPage) blockEnd = totalPage;
		
		
		
		int prevPage = blockStart - 1;
		int nextPage = blockEnd + 1;
		
		if(nextPage > totalPage) nextPage = totalPage;
		
		// 바인딩 처리
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("prevPage", prevPage);
		request.setAttribute("nextPage", nextPage);
		request.setAttribute("blockStart", blockStart);
		request.setAttribute("blockEnd", blockEnd);		
		request.setAttribute("list", dtos);
	}
}
