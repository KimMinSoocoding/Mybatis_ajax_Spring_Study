<%@page import="ez.web.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 회원정보 DB 입력 -->
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="dto" class="ez.web.model.MemberDTO"/>

<!-- 폼에서 전송된 모든 프로퍼티를 dto에 설정 -->
<jsp:setProperty name="dto" property="*" />

<%
	MemberDAO dao = MemberDAO.getInstance();
	int n = dao.memberInsert(dto);
	if(n == MemberDAO.MEMBER_JOIN_SUCCESS){
		session.setAttribute("id", dto.getId());
%>
	<script>
		alert("회원 가입 처리 되었습니다!!");
		document.location.href="user_login.jsp";
	</script>
<% } else { %>
	<script>
		alert("회원 가입 실패!!");
		document.location.href="user_join.jsp";
	</script>
<%
	}// if문
%>	
    