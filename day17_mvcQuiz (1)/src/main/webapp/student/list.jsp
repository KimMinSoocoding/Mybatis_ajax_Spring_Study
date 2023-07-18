<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>                                         
<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet'>       
<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js'></script>
<title>학생 리스트</title>
</head>

<body>
<div class="container mt-5">
	<!-- 검색 -->
	<div class="d-flex justify-content-center py-3 mb-4" >
		<h3>[학생 목록]</h3>
		<form action="search.do" class="ms-auto d-flex">
				<input type="text" class="form-control" name="sName">
				<input type = "submit" value="검색" class="btn btn-primary" >
		</form>
	</div>
	<!-- 학생 리스트 -->
	<table class="table table-border text-center">
		<thead>
			<th>학번</th>
			<th>이름</th>
			<th>나이</th>
			<th>성별</th>
			<th>이메일</th>
			<th>전공</th>
			<th>삭제</th>
		</thead>
		
		<tbody>
		<c:forEach var="dto" items="${list}">			
			<tr>
				<td>${dto.sId}</td>
				<td><a href="info.do?sId=${dto.sId}">${dto.sName}</a></td>
				<td>${dto.sAge}</td>
				<td>${dto.sGender}</td>
				<td>${dto.sEmail}</td>
				<td>${dto.sMajor}</td>
				<td>
					<a href="delete.do?sId=${dto.sId}" class="btn btn-outline-danger">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16">
						  <path d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8 2.146 2.854Z"/>
						</svg>
					</a>
				</td>
			</tr>
		</c:forEach>			
		</tbody>		
	</table>
		
	<div class="text-center">
		<a href="registerView.do" class="btn btn-primary">학생 등록하기</a>
		<a href="list.do" class="btn btn-info">리스트</a>
	</div>
	
	<!-- 페이징 처리 -->
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