<%@page import="ez.web.model.AdminDTO"%>
<%@page import="ez.web.model.AdminDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	AdminDAO dao = AdminDAO.getInstance();
	int chkNum = dao.adminCheck(id, pw);
	
	if(chkNum == dao.ADMIN_LOGIN_NOT){
%>    
	<script type="text/javascript">
		alert("관리자만 접속할 수 있습니다...!!!");
		history.back();
	</script>
<% }else if(chkNum == dao.ADMIN_LOGIN_PW_FAIL){
%>
	<script type="text/javascript">
		alert("비밀번호가 일치하지 않습니다...!!!");
		history.back();
	</script>
<%}else if(chkNum == dao.ADMIN_LOGIN_SUCCESS){
	AdminDTO dto = dao.getAdminInfo(id);
	
	String name = dto.getName();
	session.setAttribute("id", id);
	session.setAttribute("name", name);
	session.setAttribute("isLogin", "yes");
	// user와 관리자를 구분하기 위한 용도
	session.setAttribute("memberInfo", "admin");
	response.sendRedirect("ad_main.jsp");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>