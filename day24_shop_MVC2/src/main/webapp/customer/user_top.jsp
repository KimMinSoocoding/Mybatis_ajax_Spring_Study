<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>                                         
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
<script src="../js/validChk.js"></script>
</head>
<body>
<header>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container">
    <a class="navbar-brand" href="${ctx}">SHOP</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>	
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav w-100">
      	<li class="nav-item me-auto">
          <a class="nav-link" href="${ctx}">쇼핑홈</a>
        </li>      
      <c:if test="${sessionScope.isLogin != null}">
        <li class="nav-item" style="color:white; line-height:40px;">
          ${sessionScope.name} 님 안녕하세요!!
        </li>
      </c:if>  
      <c:if test="${sessionScope.isLogin == null}">
        <li class="nav-item">
          <a class="nav-link" href="user_login.jsp">로그인</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="user_join.jsp">회원가입</a>
        </li>
      </c:if>
      <c:if test="${sessionScope.isLogin != null && sessionScope.memberInfo == 'user'}">
        <li class="nav-item">
          <a class="nav-link" href="user_logout.jsp">로그아웃</a>
        </li>
      </c:if>
      <c:if test="${sessionScope.isLogin != null && sessionScope.memberInfo == 'admin'}">
        <li class="nav-item">
          <a class="nav-link" href="../admin/logout.jsp">관리자 로그아웃</a>
        </li>
      </c:if>
        <li class="nav-item">
          <a class="nav-link" href="cart_list.jsp">장바구니</a>
        </li>
      
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" 
          	data-bs-toggle="dropdown">프로필</a>
          	
          <c:if test="${sessionScope.isLogin !=null && sessionScope.memberInfo == 'admin'}">	
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="adminMain.do">관리자 페이지</a></li>
          </ul>
          </c:if>
        </li>
      </ul>
    </div>
  </div>
</nav>
</header>