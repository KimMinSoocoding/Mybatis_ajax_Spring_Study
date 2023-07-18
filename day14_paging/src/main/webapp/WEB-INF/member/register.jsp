<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
<div class="container mt-5 p-4 w-50 shadow">
<form action="memberInsert.do" method="post">
	<table>
		<thead>
			<tr>
				<th colspan = "2">회원가입</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>회원번호</td>
				<td><input type="text" name="no"></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pw"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td colspan = "2">
					<input type="submit" value="가입">
					<input type="reset" value="취소">					
				</td>
			</tr>
		</tbody>
	</table>

</form>
</div>
</body>
</html>