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
	<div class="d-flex flex-wrap justify-content-center py-3 mb-4" >
		<h3>[학생 목록]</h3>
		<form action="" class="">
			<input type="text" class="form-control" name="sName">
			<input type = "submit" value="검색" class="btn btn-primary" >
		</form>
	</div>
	
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
			<tr>
				<td>1</td>
				<td>김말똥</td>
				<td>23</td>
				<td>남</td>
				<td>test</td>
				<td>컴퓨터공학과</td>
				<td>
					<a href="" class="">삭제</a>
				</td>
			</tr>			
		</tbody>		
	</table>
		
	<div class="text-center">
		<a href="" class="btn btn-primary">학생 등록하기</a>
		<a href="" class="btn btn-info">전체보기</a>
	</div>
	
	<!-- 페이징 처리 -->
	
	
	
</div>
</body>
</html>