package ez.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.model.MemberDAO;
import web.model.MemberDTO;

public class MemberInsertController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String ctx = request.getContextPath();
		
		// 1.요청 파라미터 수집
//		int no = Integer.parseInt(request.getParameter("no"));
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		// 형변환의 경우
		int age = Integer.parseInt( request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String zipcode = request.getParameter("zipcode");
		String roadAddr = request.getParameter("roadAddr");
		String jibunAddr = request.getParameter("jibunAddr");
		String detailAddr = request.getParameter("detailAddr");
		String fileName = request.getParameter("fileName");
		
		
		
		// DTO로 묶기
		MemberDTO dto = new MemberDTO();
//		dto.setNo(no);
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.setAge(age);
		dto.setEmail(email);
		dto.setPhone(phone);
		dto.setZipcode(zipcode);
		dto.setRoadAddr(roadAddr);
		dto.setJibunAddr(jibunAddr);
		dto.setDetailAddr(detailAddr);
		dto.setFileName(fileName);
		
		//MemberDTO dto = new MemberDTO(id, pw, name, age, email, phone, zipcode, roadAddr, jibunAddr, detailAddr);
		
		System.out.println(dto);
		
		
		// 2.비즈니스 로직 (DB에 저장)
		MemberDAO dao = new MemberDAO();
		int cnt = -1;
//		if(request.getParameter("mode").equals("fa")) {
//			cnt = dao.memberInsertFile(dto); // 파일 첨부시
//		}else {
//			cnt = dao.memberInsert(dto);
//		}		
		cnt = dao.memberInsert(dto);
		
		String viewPage = null;
		if(cnt > 0) {
//			out.println("회원 가입 완료!!");
			// 회원리스트 페이지로 이동 => redirect
//			response.sendRedirect("/day06/memberList.do");
			viewPage = "redirect:"+ctx+"/memberList.do";
			
		}else {
			throw new ServletException("가입실패!!");
		}
		
		return viewPage;
	}
}
