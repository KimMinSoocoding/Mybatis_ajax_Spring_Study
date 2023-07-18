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
		<%/* 
			ProductDAO pDao = ProductDAO.getInstance();
			String code = request.getParameter("code");
			String catName = request.getParameter("catName");
			
			ArrayList<ProductDTO> pDtos = pDao.getProductByCategory(code);
			
			DecimalFormat df = new DecimalFormat("###,###,###");
			
			if(pDtos == null || pDtos.size() == 0){
				out.println("상품이 존재하지 않습니다!!!");
			}else { */
		%>
		<c:if test="${pDtos == null || pDtos.size() == 0 }">
			<p>상품이 존재하지 않습니다!!</p>
		</c:if>
		<c:if test="${pDtos.size() != 0 }">
		<h3>[${requestScope.catName }]</h3>
		<div class="d-flex">
			<%-- <%
					for(ProductDTO pDto: pDtos){
						int pNum = pDto.getpNum();
						String pName = pDto.getpName();
						String pSpec = pDto.getpSpec();
						String pImage = pDto.getpImage();
						int price = pDto.getPrice();
						int pPoint = pDto.getpPoint();
			%> --%>
			<c:set var= "cnt" value="0"/>
			<c:forEach var="pDto" items="${requestScope.pDtos}">
			<%-- <c:set var= "cnt" value="${cnt+1}"/>
			<div class="card <c:if test="${cnt%4 !=0}">me-4</c:if>" style="width:200px">
				<a href="prod_view.jsp?pNum=${pDto.pNum}&pSpec=${pDto.pSpec}" style="overflow:hidden; height:120px;">
			    	<img class="card-img-top" src="${ctx}/uploadedFile/${pDto.pImage}" alt="Card image" 
			    	style="width:100%;">
			    </a>	
			    <div class="card-body">
			      <h4 class="card-title" style="font-size:15px; overflow:hidden; text-overflow:ellipsis; 
				      	white-space:nowrap;"><b>상품명 : ${pDto.pName}</b></h4>
			      <p class="card-text">가격 : <fmt:formatNumber type="Number" value="${pDto.price}"/></p>
			      <p class="card-text">포인트 : <fmt:formatNumber type="Number" value="${pDto.pPoint}"/></p>
			      <a href="cart_add.jsp?pNum=${pDto.pNum}&pQty=1&pSpec=${pDto.pSpec}&pCategory_fk=${requestScope.code}" 
			      class="btn btn-outline-info" style="width:100%">장바구니 담기</a>
			    </div>
			 </div> <!-- card div -->
			 <c:if test="${cnt%4 == 0}">
			 	</div><div class="d-flex mt-4">
			 </c:if> --%>
			 <%@ include file="prod_loop.jsp" %>
			</c:forEach>
			</div>	
		</c:if>
	</section>
	</div>
</main>

<%@ include file="user_bottom.jsp" %>