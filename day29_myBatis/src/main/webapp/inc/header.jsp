<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css' rel='stylesheet'>
<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js'></script>

<link rel="stylesheet" href="${ctx}/css/main.css">
</head>
<body>
	<div class="container">
		<br/>
		<h3><a href="">Web Study</a></h3>
	</div>
	<nav class="navbar navbar-expand-sm sticky-top">
	<div class="container">
	  <div class="collapse navbar-collapse" id="mynavbar">
	      <ul class="navbar-nav w-100">
	        <li class="nav-item">
	          <a class="nav-link" href="">HOME</a>
	        </li>
	        
	        <li class="nav-item">
	          <a class="nav-link" href="javascript:void(0)">회원 리스트</a>
	        </li>
	        
	        <li class="nav-item ms-auto">
	          <a class="btn btn-sm btn-outline-light" data-bs-toggle="modal" data-bs-target="#loginModal" href="">로그인</a>
	        </li>
	      </ul>
	  </div>
	</div>  
	</nav>

<div id="demo" class="carousel slide" data-bs-ride="carousel">

  <!-- Indicators/dots -->
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="3"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="4"></button>
  </div>

  <!-- The slideshow/carousel -->
  <div class="carousel-inner">
    <div class="carousel-item active" data-bs-interval="3000">
      <img src="${ctx}/img/1.jpg" alt="..." class="d-block w-100">
    </div>
    <div class="carousel-item">
      <img src="${ctx}/img/2.jpg" alt="..." class="d-block w-100">
    </div>
    <div class="carousel-item">
      <img src="${ctx}/img/3.jpg" alt="..." class="d-block w-100">
    </div>
    <div class="carousel-item">
      <img src="${ctx}/img/4.jpg" alt="..." class="d-block w-100">
    </div>
    <div class="carousel-item">
      <img src="${ctx}/img/5.jpg" alt="..." class="d-block w-100">
    </div>
  </div>

  <!-- Left and right controls/icons -->
  <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
    <span class="carousel-control-next-icon"></span>
  </button>
</div>	

<!-- The Modal -->
<div class="modal fade" id="loginModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header border-0">
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <form action="" method="post">
	      <div class="modal-body p-4">
	        <input class="form-control" type="text" placeholder="아이디" id="user_id" name="user_id"/>
	        <input class="form-control mt-4" type="password" placeholder="비밀번호" id="pw" name="pw"/>
	        
	      </div>
	      <!-- Modal footer -->
	      <div class="modal-footer border-0">
	        <button type="submit" class="btn btn-primary">로그인</button>
	      </div>
	  </form> 	

    </div>
  </div>
</div>

