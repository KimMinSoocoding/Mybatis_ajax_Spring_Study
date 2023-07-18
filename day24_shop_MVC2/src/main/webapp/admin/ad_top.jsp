<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>                                         
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
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
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="adminCatInput.do">카테고리등록</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="catAllList.do">카테고리리스트</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="prodInput.do">상품등록</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="prodList.do">상품리스트</a>
        </li>  
        <li class="nav-item dropdown ms-auto">
          <a class="nav-link dropdown-toggle" href="#" role="button" 
          	data-bs-toggle="dropdown">프로필</a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">마이페이지</a></li>
            
            <c:if test="${sessionScope.isLogin == null}">
            	<li><a class="dropdown-item" href="ad_login.jsp">로그인</a></li>
            </c:if>
            <c:if test="${sessionScope.isLogin != null}">
            	<li><a class="dropdown-item" href="adminMain.do">로그아웃</a></li>
            </c:if>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
</header>