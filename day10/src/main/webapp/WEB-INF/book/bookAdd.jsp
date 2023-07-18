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
	<div class="container w-50 p-4 mt-5 shadow rounded">
		<h3>도서 등록</h3>
		<form action="bookAdd.do" method = "post">
			<table class="table table-borderless">
				<tr>
					<td><input class="form-control" type="text" name="title" placeholder="도서명"/></td>
				</tr>
				<tr>
					<td><textarea class="form-control" name="bookInfo" placeholder="도서소개"></textarea></td>
				</tr>
				<tr>
					<td><input class="form-control" type="text" name="author" placeholder="저자"/></td>
				</tr>
				<tr>
					<td><input class="form-control" type="text" name="publisher" placeholder="출판사"/></td>
				</tr>
				<tr>
					<td><input class="form-control" type="text" name="price" placeholder="가격"/></td>
				</tr>
				<tr>
					<td><input class="form-control" type="text" name="qty" placeholder="수량"/></td>
				</tr>
				<tr>
					<td class="text-center">
						<input class="btn btn-primary" type="submit" value="등록하기"/>
						<a href="bookList.do" class="btn btn-outline-primary">도서목록</a>
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>