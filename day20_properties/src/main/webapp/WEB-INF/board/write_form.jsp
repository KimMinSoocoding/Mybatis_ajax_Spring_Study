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
<body>  <!-- w-50 = width:50%(25%,75%) -->
<div class="container mt-5 border p-4 w-50 shadow rounded">
	<h3 class="text-center mt-3">글쓰기</h3>
	<table class="table table-borderless">
		<form action="write.do" method="post">
			<tr>
				<td>이름</td>
				<td>
					<input class="form-control" type="text" name="bname"/>
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input class="form-control" type="text" name="btitle"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea class="form-control" name="bcontent"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="등록" class="btn btn-primary">
					<a href="list.do" class="btn btn-info">리스트</a>
				</td>
			</tr>
		</form>
	</table>
	
</div>

</body>
</html>