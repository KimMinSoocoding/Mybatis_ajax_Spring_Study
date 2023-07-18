<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	if(session.getAttribute("isLogin") == null){
		response.sendRedirect("ad_login.jsp");
	}
%>

<%@ include file="ad_top.jsp" %>
<div id="demo" class="carousel slide" data-bs-ride="carousel">
 <div class="carousel-indicators">
    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="3"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="4"></button>
  </div>

  <!-- The slideshow/carousel -->
  <div class="carousel-inner">
    <div class="carousel-item active" data-bs-interval="2000">
      <img src="${ctx}/img/f1.jpg" alt="..." class="d-block w-100">
    </div>
    <div class="carousel-item">
      <img src="${ctx}/img/f2.jpg" alt="..." class="d-block w-100">
    </div>
    <div class="carousel-item">
      <img src="${ctx}/img/f3.jpg" alt="..." class="d-block w-100">
    </div>
    <div class="carousel-item">
      <img src="${ctx}/img/f4.jpg" alt="..." class="d-block w-100">
    </div>
 <%--    <div class="carousel-item">
      <img src="${ctx}/img/5.jpg" alt="..." class="d-block w-100">
    </div>
  </div> --%>

  <!-- Left and right controls/icons -->
  <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
    <span class="carousel-control-next-icon"></span>
  </button>
</div>	

<main>
	<div class="container-fluid mt-3 text-center">
  		<h3 class ="text-success">Flower_관리자 페이지</h3>
	</div>
</main>

<%@ include file="ad_bottom.jsp" %>