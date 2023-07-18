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
<title>학생 상세 정보</title>
</head>
<body>
<div class="container mt-5 w-50">
	<form action="" method = "">	 
		<h3>[학생 정보 및 수정]</h3>
		<table class="table table-border">
			<tr>
				<td>학번</td>
				<td></td>
			</tr>
			<tr>
				<td>이름</td>
				<td></td>
			</tr>
			<tr>
				<td>나이</td>
				<td></td>
			</tr>
			<tr>
				<td>성별</td>
				<td></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>
					<input class="form-control" type = "text" name="sEmail" value="">
				</td>
			</tr>
			<tr>
				<td>전공</td>
				<td>
					<input class="form-control" type = "text" name="sMajor" value="">
					
				</td>
			</tr>		
		</table>
		<div class="text-center">
			<input type ='submit' value='수정하기' class='btn btn-primary'/>   
			<input type ='reset' value='취소' class='btn btn-warning'/>  
			<a href='' class='btn btn-info'>돌아가기</a>
	</div>
	</form>
	
</div>

</body>
</html>