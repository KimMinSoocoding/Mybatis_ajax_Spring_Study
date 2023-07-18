<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<c:set var="ctx" value="${pageContext.request.contextPath}"/>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>                                         
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-light">
  <div class="container-fluid">
 <a class="navbar-brand m-3 text-success" href="#">FlowerShop</a>
    <ul class="navbar-nav">
    <c:if test="${sessionScope.isLogin != null}">
        <li class="nav-item" style="color:white; line-height:40px;">
          ${sessionScope.name} 님 안녕하세요!!
        </li>
      </c:if>  
      <c:if test="${sessionScope.isLogin == null}">
        <li class="nav-item">
          <a class="nav-link" href="userLogin.do">로그인</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="userJoin.do">회원가입</a>
        </li>
      </c:if>
      <c:if test="${sessionScope.isLogin != null && sessionScope.memberInfo == 'user'}">
        <li class="nav-item">
          <a class="nav-link" href="userLogout.do">로그아웃</a>
        </li>
      </c:if>
      <c:if test="${sessionScope.isLogin != null && sessionScope.memberInfo == 'admin'}">
        <li class="nav-item">
          <a class="nav-link" href="adminLogout.do">관리자 로그아웃</a>
        </li>
      </c:if>
      <c:if test="${sessionScope.isLogin != null }">
        <li class="nav-item">
          <a class="nav-link" href="cartList.do">장바구니</a>
        </li>
        </c:if>
      <c:if test="${sessionScope.isLogin == null }">
        <li class="nav-item">
          <a class="nav-link" href="javascript:alert('로그인이 필요합니다')">장바구니</a>
        </li>
        </c:if>
 
 
 
       <li class="nav-item dropdown ms-auto">
          <a class="nav-link dropdown-toggle" href="#" role="button" 
          	data-bs-toggle="dropdown">프로필</a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">마이페이지</a></li>
          </ul>
        </li>
    </ul>
  </div>
</nav>


</body>
</html>