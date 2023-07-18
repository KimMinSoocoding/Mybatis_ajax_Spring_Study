<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="web.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	MemberDTO dto = new MemberDTO();

	dto.setNo(1);
	dto.setName("홍길동");
	dto.setEmail("test@gmail.com");
	dto.setPhone("010-1212-1234");
	
	List<MemberDTO> list = new ArrayList<MemberDTO>();
	list.add(dto);
	list.add(dto);
	list.add(dto);
	list.add(dto);
	list.add(dto);
	
	request.setAttribute("list", list);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>이메일</th>
		<th>전화번호</th>
	</tr>
	<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.no}</td> <%--  == <%=dto.getNo()%> --%>
			<td>${dto.name}</td>
			<td>${dto.email}</td>
			<td>${dto.phone}</td><%-- == <%=dto.getPhone()%> --%>
		</tr>
	</c:forEach>
</table>
</body>
</html>