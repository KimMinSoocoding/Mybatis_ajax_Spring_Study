<%@page import="web.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDTO dto = (MemberDTO)request.getAttribute("dto");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Controller에서 전송된 값 <br/>
이름 : <%=dto.getName()%><br/>
나이 : <%=dto.getAge()%><br/>
이메일 : <%=dto.getEmail()%>

</body>
</html>