<%@page import="ez.web.model.StudentDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:useBean id="dao" class="ez.web.model.StudentDAO"/>
<jsp:useBean id="dto" class="ez.web.model.StudentDTO"/>
<%
	ArrayList<StudentDTO> sList= dao.selectAll();
	pageContext.setAttribute("list", sList);
%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>                                         
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
   <div class="container mt-5 w-50 border shadow-sm p-4">
      <h4>학생 리스트</h4>
      <div class="text-center mt-3 mb-3">
      	<a href="student.jsp" class="btn btn-sm btn-secondary">등록</a>	
      </div>
      <table class="table">
      	<thead>
      		<tr>
      			<th>학번</th>
      			<th>비밀번호</th>
      			<th>이름</th>
      			<th>전화번호</th>
      		</tr>
      	</thead>
      	<tbody>
      	<c:forEach var="dto" items="${list}">
      		<tr>
      			<td>${dto.stuNo}</td>
      			<td>${dto.pw}</td>
      			<td>${dto.name}</td>
      			<td>${dto.tel}</td>
      		</tr>
      	</c:forEach>
      	</tbody>
      
      </table>
      
   </div>
</body>
</html>