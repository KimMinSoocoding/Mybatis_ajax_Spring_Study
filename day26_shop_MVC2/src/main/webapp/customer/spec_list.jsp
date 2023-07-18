<%@page import="java.text.DecimalFormat"%>
<%@page import="ez.web.model.ProductDTO"%>
<%@page import="ez.web.model.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="user_top.jsp" %>

<main>

	<div class="container mt-5 d-flex">
		<!-- 서브 메뉴  -->
		<%@ include file="user_left.jsp" %>
		
		<section class="w-75 ps-5">
		<c:if test ="${requestScope.msg !=null }">
			<p>${requestScope.mag}] </p>
		</c:if>
		<%
			/* ProductDAO pDao = ProductDAO.getInstance();
			String spec = request.getParameter("pSpec");
			
			DecimalFormat df = new DecimalFormat("###,###,###");
			
			ArrayList<ProductDTO> pDtos = null;
			// main에서 이미 맵에 사양별로 저장해두었기 때문에
			// 데이터베이스 테이블 사용하지 않고 맵에서 데이터를 가져옴
			// 사양별로 가져오기 때문에 전체 상품 중에서 검색하지 않고
			// 해당 사양에서만 상품을 검색할 수 있어 효율적이다.
			Boolean bool = pDao.map.containsKey(spec);
			System.out.println(bool);
			
			if(!bool){
				out.println("상품이 존재하지 않습니다!!!");
			}else{
				pDtos=pDao.map.get(spec);
				String specName = spec.equals("hit") ? "인기": spec.equals("new") ? "최신":"추천"; */
		%>
		<c:if test ="${requestScope.msg == null }">
		<h3>[${requestScope.specValue}] 상품</h3>
		<div class="d-flex">
			<%
			/* 	int cnt = 0;
				for(ProductDTO pDto: pDtos){
					cnt++;
					String pName = pDto.getpName();
					int pNum = pDto.getpNum();
					String pSpec = pDto.getpSpec();
					String pImage = pDto.getpImage();
					int price = pDto.getPrice();
					int pPoint = pDto.getpPoint(); */
			%>
			<c:set var= "cnt" value="0"/>
			<c:forEach var="pDto" items="${requestScope.pDtos}">
			<%@ include file="prod_loop.jsp" %>
			</c:forEach>
			</div>	
		</c:if>
		</section>
	</div>
	
</main>

<%@ include file="user_bottom.jsp" %>