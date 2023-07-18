<%@page import="flower.model.ProductDTO"%>
<%@page import="flower.model.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	if(session.getAttribute("isLogin") == null){
		response.sendRedirect("ad_login.jsp");
	}
%>

<%@ include file="user_top.jsp" %>
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
	<div class="container mt-5 d-flex">
		<!-- 서브 메뉴  -->
	<%@ include file="user_left.jsp" %>
		
		<section class="w-75 ps-5">
	<%
	
	ProductDAO pDao = ProductDAO.getInstance();
	ArrayList<ProductDTO> pDtos = null;
	
	for(ProdSpec ps : pdSpecs){
		// HIT, NEW, RECOMMEND
		String key = ps.name();
	/* 	pDtos = pDao.getProductBySpec(key); */
		
		pageContext.setAttribute("ps", ps);
		pageContext.setAttribute("pDtos", pDtos);
	%>
	<c:if test="${pDtos == null || pDtos.size() ==0 }">
					${ps.getValue()} 상품이 없습니다!!
				</c:if>
				
				<c:if test="${pDtos != null || pDtos.size() !=0 }">
				<h4 class="mt-3">${ps.getValue()} 상품</h4>
				<div class="d-flex">
				  <c:set var="cnt" value="0"/>	
				  <c:forEach var="pDto" items="${pDtos}">

<%@ include file="prod_loop.jsp" %>
				  </c:forEach>
				  
				</div> <!-- 카드를 감싸는 부모태그 종료 -->	
				</c:if>
		<%} %>
		</section>
	</div>
	<h2 class="mb-5 text-center">풀집</h2>
	
</main>

<%@ include file="user_bottom.jsp" %>