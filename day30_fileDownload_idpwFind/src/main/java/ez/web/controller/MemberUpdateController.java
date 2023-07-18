package ez.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.model.MemberDAO;
import web.model.MemberDTO;

public class MemberUpdateController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ctx = request.getContextPath();
		
		// 파라미터 수집
		int no = Integer.parseInt(request.getParameter("no"));
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String fileName = request.getParameter("flieName");
		
		System.out.println("fileName : " + fileName);
		
		// dto로 묶기
		MemberDTO dto = new MemberDTO();
		dto.setNo(no);
		dto.setAge(age);
		dto.setEmail(email);
		dto.setPhone(phone);
		dto.setFileName(fileName);
		
		MemberDAO dao = new MemberDAO();
		
		// 사진첨부시 파일명을 dto에 설정
		if(request.getParameter("mode").equals("fupdate")) {
			String filename = request.getParameter("fileName");
			dto.setFileName(fileName);
		}
		
		int cnt = -1;
		String viewPage = null;
		// 사진 첨부 여부에 따라 메소드 호출
		if(request.getParameter("mode").equals("fupdate")) {
			cnt = dao.memberUpdateFile(dto);
		}else {
			cnt = dao.memberUpdate(dto);
			
		}
		
		if(cnt > 0) {
			// 회원리스트 페이지로 이동
			//response.sendRedirect("/day06_2/memberList.do");
//			viewPage = "redirect:/day06_2/memberList.do";
			viewPage = "redirect:"+ctx+"/memberList.do";
		}else {
			throw new ServletException("update failed!!");
		}
		return viewPage;
	}
}
