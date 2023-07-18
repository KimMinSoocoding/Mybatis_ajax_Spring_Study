<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<div class="container mt-5 w-50 border shadow p-5">
	<h3>관리자 로그인</h3>
	<form action="loginOk.jsp">
		<div class="mt-3 mb-3">
			<lable for="id">아이디</lable>
			<input type="text" class="form-control" id="id" placeholder="아이디" name="id"/>
		</div>
		<div class="mb-3">
			<lable for="pw">비밀번호</lable>
			<input type="password" class="form-control" id="pw" placeholder="비밀번호" name="pw"/>
		</div>
		<div class="text-center">
			<input type="submit" class="btn btn-sm btn-primary" value="로그인"/>
		</div>
	</form>
</div>
</body>
</html>