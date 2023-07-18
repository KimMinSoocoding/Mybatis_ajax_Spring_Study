<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="a" value= "11"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- if문 -->
<c:if test="${a%2 ==0}"> <!-- else블럭을 지원하지 않는다. -->
짝수
</c:if>
<c:if test="${a%2 !=0}">
홀수
</c:if> <br/>
<!-- switch문 -->
<c:choose>
	<c:when test="${a%2==0}">짝수 입니다.</c:when>
	<c:when test="${a%2!=0}">홀수 입니다.</c:when>
	<c:otherwise>일치하는 when절이 없습니다....</c:otherwise>
</c:choose>
<br/>
<!-- 반복문 
 var="i"	== request.setAttribute("i", i) 바인딩 처리한것과 같다.
 ${i} 		== request.getAttribute("i") 바인딩된 i값을 가져옴
-->
<c:forEach var="i" begin="1" end="10" step="1">
	<font size="${i}">jstl study</font><br/>
</c:forEach>


</body>
</html>