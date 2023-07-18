<%@page import="ez.web.model.MemberDTO"%>
<%@page import="ez.web.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	MemberDAO dao = MemberDAO.getInstance();
	int chkLogin = dao.memberCheck(id,pw);
	
	if(chkLogin == MemberDAO.MEMBER_LOGIN_NOT){
%> 
<script>
	alert("아이디가 존재하지 않습니다!!");
	history.go(-1); // 뒤로이동
</script>
<% }else if(chkLogin == MemberDAO.MEMBER_LOGIN_NOT_PASSWORD){%>
	<script>
		alert("비밀번호가 틀립니다!!");
		history.go(-1); // 뒤로이동
	</script>
<% }else if(chkLogin == MemberDAO.MEMBER_LOGIN_SUCCESS){
	MemberDTO dto = dao.getMember(id);
	
	if(dto == null){
%>		
		<script>
		alert("가입된 회원이 아닙니다 !!");
		history.go(-1); // 뒤로이동
		</script>
<%  }else{
		String name = dto.getName();
		session.setAttribute("id", id);
		session.setAttribute("name", name);
		
		//로그인 체크를 위한 설정
		session.setAttribute("isLogin", "yes");
		session.setAttribute("memberInfo", "user");
		session.setAttribute("isLogin", "yes");
		response.sendRedirect("user_main.jsp");
		} //if문
}//if문 
%>
	
