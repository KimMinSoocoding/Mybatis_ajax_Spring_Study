<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/inc/header.jsp" %>
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

<div class="container">
	<h2>Welcome To page!!</h2>
</div>

<%@ include file="/inc/footer.jsp" %>



</body>
</html>