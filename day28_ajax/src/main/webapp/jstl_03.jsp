<%@page import="web.model.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	//Controller에서 작업한 내용
	String[] strArr = {"사자", "호랑이", "고양이", "개", "독수리"};
	request.setAttribute("strArr", strArr);
	
	int intVar = 20;
	
	// ArrayList
	List<String> list = new ArrayList<String>();
	list.add("java");
	list.add("python");
	list.add("C++");
	list.add("Spring");
	list.add("JSP");
	
	request.setAttribute("list", list);
	
	MemberDTO dto = new MemberDTO();
	
	dto.setNo(1);
	dto.setName("홍길동");
	dto.setEmail("test@gmail.com");
	dto.setPhone("010-1212-1234");
	
	request.setAttribute("dto", dto);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 /* ${strArr} == request.getAttribute("strArr");
 	객체바인딩한 값을 꺼내오는 것과 같다.
 */
%>
<hr>
<c:forEach var="animal" items="${strArr}">
	${animal}<br/>
</c:forEach>
<hr>
<c:forEach var="lang" items="${list}">
	${lang}<br/>
</c:forEach>
<hr>
<table>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>이메일</th>
		<th>전화번호</th>
	</tr>
	<tr>
	   <%-- <% MemberDTO dto = (MemberDTO)request.getAttribute("dto"); %> --%>
	   
		<td>${dto.no}</td> <%--  == <%=dto.getNo()%> --%>
		<td>${dto.name}</td>
		<td>${dto.email}</td>
		<td>${dto.phone}</td><%-- == <%=dto.getPhone()%> --%>
	</tr>
</table>


</body>
</html>