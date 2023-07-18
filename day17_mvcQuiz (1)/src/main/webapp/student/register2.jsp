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
<title>학생 정보 등록하기</title>
<script type="text/javascript" src=""></script>
</head>
<body>
<div class="container mt-5 w-50 p-4">
	<form action="" method = "POST" name="">
	<h3>[학생등록]</h3>
	<table class="table table-border">
		<thead>
					
		</thead>
		<tbody>
			<tr>
				<td>이름</td>
				<td><input class="form-control" type = "text" name="sName"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input class="form-control" type = "text" name="sAge"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
				<input type="radio" id="m" value="남" name="sGender"><label for="m">남</label>
  				<input type="radio" id="f" value="여" name="sGender"><label for="f">여</label>

				</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input class="form-control" type = "text" name="sEmail"></td>
			</tr>
			<tr>
				<td>전공</td>
				<td><input class="form-control" type = "text" name="sMajor"></td>
			</tr>
		</tbody>
	</table>
	<div class="text-center">
		<input type = "button" value="등록하기" class="btn btn-primary"/>
		<a href="" class="btn btn-info">목록으로</a>
	</div>
	
	</form>
</div>
</body>
</html>