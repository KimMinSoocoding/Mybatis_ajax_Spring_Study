<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="test.do" method="get">
		이름 : <input type="text" name="name"/><br/>
		취미 : <input type="checkbox" name="hobby" value="영화"/>영화
		<input type="checkbox" name="hobby" value="운동"/>운동
		<input type="checkbox" name="hobby" value="음악"/>음악
		<input type="checkbox" name="hobby" value="독서"/>독서
		<input type="submit" value="get방식"/>
	</form>
	<form action="test.do" method="post">
		이름 : <input type="text" name="name"/><br/>
		취미 : <input type="checkbox" name="hobby" value="영화"/>영화
		<input type="checkbox" name="hobby" value="운동"/>운동
		<input type="checkbox" name="hobby" value="음악"/>음악
		<input type="checkbox" name="hobby" value="독서"/>독서 
		<input type="submit" value="post방식"/>
	</form>
</body>
</html>