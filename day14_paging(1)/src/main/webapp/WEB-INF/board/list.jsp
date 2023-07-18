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
<%@ include file="/inc/navbar.jsp" %>
	<div class="container mt-5">
	<h3 class="text-center">리스트</h3>
		<table class="table table-border">
			<thead class="table-dark">
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
			</thead>
			
			<tbody>
				<c:forEach var="dto" items="${list}">
				<tr>
					<td>${dto.bid}</td>
					<td>
						<c:forEach begin="1" end="${dto.bindent}">└</c:forEach>
						<a href="view.do?bid=${dto.bid}">${dto.btitle}</a>
					</td>
					<td>${dto.bname}</td>
					<td>
						<fmt:formatDate type="date" pattern="yy-MM-dd" value="${dto.bdate}"/>
					</td>
					<td>${dto.bhit}</td>
				</tr>
				</c:forEach>
				<!-- pagination : page navigation -->
				<tr>
					<td colspan="5">
						<c:if test="${prevPage > 0}">
							<a href="list.do?currentPage=${prevPage}">[이전]</a>						
						</c:if>
					
						<c:forEach var="pno" begin="${blockStart}" end="${blockEnd}">
							<a href="list.do?currentPage=${pno}">[${pno}]</a>
						</c:forEach>
						
						<c:if test="${blockEnd < totalPage}">
							<a href="list.do?currentPage=${nextPage}">[다음]</a>						
						</c:if>
						
					</td>
				</tr>
				
			</tbody>
		</table>
		<div class="text-center">
			<a href="writeView.do" class="btn btn-primary">글쓰기</a>
		</div>
		
		<ul class="pagination mt-4 mb-5 justify-content-center">
		  <li class="page-item ${prevPage <= 0  ? 'disabled' : ''}">
		  	<a class="page-link" href="list.do?currentPage=${prevPage}">이전</a>
		  </li>
		  
		  <c:forEach var="i" begin="${blockStart}" end="${blockEnd}">
		  	<li class="page-item ${currentPage == i ? 'active':''}">
		  		<a class="page-link" href="list.do?currentPage=${i}">${i}</a>
		  	</li>
		  </c:forEach>
		  
		  <li class="page-item ${blockEnd >= totalPage  ? 'disabled' : ''}">
		  	<a class="page-link" href="list.do?currentPage=${nextPage}">다음</a>
		  </li>
		</ul>

		
	</div>
</body>
</html>