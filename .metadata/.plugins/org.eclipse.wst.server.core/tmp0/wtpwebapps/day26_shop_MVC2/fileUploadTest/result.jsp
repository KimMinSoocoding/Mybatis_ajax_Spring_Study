<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	제목 : ${title} <br/>
	
	<!-- <img src="c:\upload\d9cb8ecf2.jpg" style="width:200px"/> -->
	<img src="<%=request.getContextPath()%>/uploadedFile/${fileName}" style="width:200px"/>
</body>
</html>