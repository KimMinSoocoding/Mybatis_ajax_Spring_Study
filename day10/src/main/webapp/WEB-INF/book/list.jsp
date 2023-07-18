<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css' rel='stylesheet'>
<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js'></script>
</head>
<body>
<%@ include file="/nav/navbar.jsp" %>
	<div class="container">
		<h3>도서 목록</h3>
			<table class="table table-borderless">
				<thead class="table-primary">
					<tr>
						<th>도서번호</th>
						<th>도서명</th>
						<th>저자</th>
						<th>출판사</th>
						<th>가격</th>
						<th>입고일자</th>
					</tr>
				</thead>
				<tbody>
				<!--${bookList} == request.getAttribute("bookList") -->
				<c:forEach var="dto" items="${bookList}">
					<tr>
						<td>${dto.bnum}</td>
						<td>
							<a href="bookView.do?bnum=${dto.bnum}">${dto.title}</a>
						</td>
						<td>${dto.author}</td>
						<td>${dto.publisher}</td>
						<td>${dto.price}</td>
						<td>
							<fmt:formatDate type="date" pattern="yy-MM-dd" value="${dto.regDate}"/>
						</td>
					</tr>
				</c:forEach>	
				</tbody>
			</table>
			<div class="text-center">
				<a href="bookAddForm.do" class="btn btn-primary">도서등록</a>
			</div>
	</div>

</body>
</html>