package ez.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.model.MemberDAO;
import web.model.MemberDTO;

public class MemberController implements Controller {
	// public class MemberController{
	
	// memberDelete
	@RequestMapping("/memberDel.do")
	public String memberDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ctx = request.getContextPath(); // --> /day07
		
		// 삭제할 회원 no 파라미터 수집
		int no = Integer.parseInt(request.getParameter("no"));
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.delMember(no);
		
		String viewPage = null;
		
		if(cnt > 0) {
//						System.out.println("회원 삭제 완료!!");
			// 회원리스트 페이지 이동
			//response.sendRedirect("/day06/memberList.do");
//			viewPage = "redirect:/day06_2/memberList.do";
			viewPage = "redirect:"+ctx+"/memberList.do";
		}else {
			throw new ServletException("회원 삭제 실패!!");
		}
		return viewPage;
	}
	
	// memberInfo
	@RequestMapping("/memberInfo.do")
	public String memberInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println(no);
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.memberInfo(no);
		
		// Object Binding
		request.setAttribute("dto", dto);
		
		// prefix(접두어) : /WEB-INF/member/
		// suffix(접미어) : .jsp
		// 실제 물리적인 경로  : prefix + 파일명 + suffix 
		// 물리적인 경로를 만들어내는 클래스 : ViewResolver라고 한다.
		
//		return "/WEB-INF/member/memberInfo.jsp";
		return "memberInfo";
	}
	
	// memberInsert
	@RequestMapping("/memberInsert.do")
	public String memberInsert(HttpServletRequest request, HttpServletResponse response)
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
		
		
		// DTO로 묶기
//		MemberDTO dto = new MemberDTO();
////		dto.setNo(no);
//		dto.setId(id);
//		dto.setPw(pw);
//		dto.setName(name);
//		dto.setAge(age);
//		dto.setEmail(email);
//		dto.setPhone(phone);
		
		MemberDTO dto = new MemberDTO(id, pw, name, age, email, phone, zipcode, roadAddr, jibunAddr, detailAddr);
		
		System.out.println(dto);
		
		
		// 2.비즈니스 로직 (DB에 저장)
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberInsert(dto);
				
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
	
	// memberList
	@RequestMapping("/memberList.do")
	public String memberList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// FrontController의 업무를 대신 정의
		
		// DB에 있는 회원정보 가져오기(Model 연동)
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> memberList = dao.memberList();
		
		// Object Binding
		request.setAttribute("list", memberList);
		
		// View page
//		return "/WEB-INF/member/memberList.jsp";
		return "memberList";
	}
	
	// memberUpdate
	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ctx = request.getContextPath();
		
		// 파라미터 수집
		int no = Integer.parseInt(request.getParameter("no"));
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		// dto로 묶기
		MemberDTO dto = new MemberDTO();
		dto.setNo(no);
		dto.setAge(age);
		dto.setEmail(email);
		dto.setPhone(phone);
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberUpdate(dto);
		
		String viewPage = null;
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
	
	// memberRegister
	@RequestMapping("/memberRegister.do")
	public String memberRegister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
//		return "/WEB-INF/member/register.html";
		return "register";
	}
}
