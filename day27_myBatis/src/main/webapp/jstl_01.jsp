<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!-- JSTL을 사용하기 위해서는 jstl 라이브러리가 있어야 함.  
C:\apache-tomcat-9.0.67\webapps\examples\WEB-INF\lib 에 있는 
두개 jar파일을 WEB-INF/lib안에 복사붙여넣기
taglibs-standard-impl-1.2.5.jar, taglibs-standard-spec-1.2.5.jar 파일

jstl에서 가장 많이 사용하는 태그라이브러리 Core tag: if, for, switch.. 명령태그

EL : Expression Language

-->   
 

<%-- <%
${식}, ${변수}
%> --%>

<% int aa = 100; %>

<!-- 변수 선언 -->
<c:set var="aa" value="100" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%= aa %> --%><br/>
el : ${aa} <br/><!-- 스크립트릿에 선언된 변수는 출력할 수 없다. -->

${aa > 500 }<br/>
${aa+100}


</body>
</html>