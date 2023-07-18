<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	제목 : ${title}
	
<!-- 	<img src="\Users\minsoo\Desktop\file\${fileName}" style="width:200px"/> -->
		<img src="<%=request.getContextPath() %>/file/${fileName }" style="width:200px"/>
</body>
</html>