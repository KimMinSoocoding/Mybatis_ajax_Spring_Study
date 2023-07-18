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
	<div class="container w-50 p-4 mt-5 shadow rounded">
		<h3>도서 상세정보</h3>
		<form action="bookUpdate.do" method = "post">
			<table class="table table-borderless">
				<input type="hidden" name="bnum" value="${dto.bnum}" />
				<tr>
					<td>도서번호</td>
					<td><input class="form-control" type="text" name="bnum" value="${dto.bnum}" disabled/></td>
				</tr>
				<tr>
					<td>도서명</td>
					<td><input class="form-control" type="text" name="title" value="${dto.title}"/></td>
				</tr>
				<tr>
					<td>도서정보</td>
					<td><textarea class="form-control" name="bookInfo">${dto.bookInfo}</textarea></td>
				</tr>
				<tr>
					<td>저자</td>
					<td><input class="form-control" type="text" name="author" value="${dto.author}" /></td>
				</tr>
				<tr>
					<td>출판사</td>
					<td><input class="form-control" type="text" name="publisher" value="${dto.publisher}"/></td>
				</tr>
				<tr>
					<td>입고일자</td>
					<td><input class="form-control" type="text" name="regDate" value="${dto.regDate}" disabled/></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input class="form-control" type="text" name="price" value="${dto.price}"/></td>
				</tr>
				<tr>
					<td>수량</td>
					<td><input class="form-control" type="text" name="qty" value="${dto.qty}"/></td>
				</tr>
			</table>
			<div class="text-center">
				<input class="btn btn-primary" type="submit" value="수정"/>
				<a href="bookDel.do?bnum=${dto.bnum}" class="btn btn-danger">삭제</a>			
				<a href="bookList.do" class="btn btn-outline-primary">도서목록</a>			
			</div>
		</form>
	</div>

</body>
</html>