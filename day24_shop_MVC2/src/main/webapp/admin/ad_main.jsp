<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(session.getAttribute("isLogin") == null){
		response.sendRedirect("ad_login.jsp");
	}
%>


<%@ include file="ad_top.jsp" %>
<main>
	<div class="container">
		<h2>관리자 페이지</h2>
		<ul>
			<li><a href="">쇼핑몰 카테고리 등록</a></li>
			<li><a href="">쇼핑몰 카테고리 리스트</a></li>
			<li><a href="">쇼핑몰 상품 등록</a></li>
			<li><a href="">쇼핑몰 상품 리스트</a></li>
		</ul>
	</div>
</main>
<%@ include file="ad_bottom.jsp" %>