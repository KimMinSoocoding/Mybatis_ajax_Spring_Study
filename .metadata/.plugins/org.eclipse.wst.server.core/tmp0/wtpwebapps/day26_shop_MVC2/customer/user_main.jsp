<%@page import="ez.web.util.ProdSpec"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="ez.web.model.ProductDTO"%>
<%@page import="ez.web.model.ProductDAO"%>
<%@page import="ez.web.model.CategoryDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ez.web.model.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ include file="user_top.jsp" %>
<main>
	<div class="container mt-5 d-flex">
		<!-- 서브 메뉴  -->
		<%@ include file="user_left.jsp" %>
		
		<section class="w-75 ps-5">
		
		<h2 class="mb-5">쇼핑몰에 오신 것을 환영합니다!!</h2>
			<%
				/* HashMap<String, String> specMap = new HashMap<String, String>(){
					{
						put("hit", "인기");
						put("new", "최신");
						put("recommend", "추천");
					}
				};
			
				ProductDAO pDao = ProductDAO.getInstance();
				// map의 키값만 가져와서 iterator로 만들기
				Iterator<String> iter= specMap.keySet().iterator();
				
				while(iter.hasNext()){
					String key = iter.next(); // 키값 가져오기
					String specValue = specMap.get(key); // 키에 해당하는 값을 가져오기
					System.out.println("specValue : " + specValue); 
					
//					ArrayList<ProductDTO> pDtos = pDao.getProductBySpec("hit");
					ArrayList<ProductDTO> pDtos = pDao.getProductBySpec(key);
					pageContext.setAttribute("pDtos", pDtos);
				
				
/* 				if(pDtos == null || pDtos.size() == 0){
					out.println("인기 상품이 없습니다!!!");
				}else{ */
			
			// user_left에서 이미 선언되었기 때문에 여기서는 필요가		
			// ProdSpec[] pdSpecs = ProdSpec.values();
				
			ProductDAO pDao = ProductDAO.getInstance();
			ArrayList<ProductDTO> pDtos = null;
			
			for(ProdSpec ps : pdSpecs){
				// HIT, NEW, RECOMMEND
				String key = ps.name();
				pDtos = pDao.getProductBySpec(key);
				
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
				  	<%-- <c:set var="cnt" value="${cnt + 1}"/>
					<div class="card <c:if test="${cnt%4 != 0}">me-4</c:if>" style="width:200px">
						<a href="prod_view.jsp?pNum=${pDto.pNum}&pSpec=${pDto.pSpec}" style="overflow:hidden; height:120px;">
					    	<img class="card-img-top" src="${ctx}/uploadedFile/${pDto.pImage}" alt="Card image" 
					    	style="width:100%;">
					    </a>	
					    <div class="card-body">
					      <h4 class="card-title" style="font-size:15px; overflow:hidden; text-overflow:ellipsis; 
					      	white-space:nowrap; "><b>상품명 : ${pDto.pName}</b></h4>
					      <p class="card-text">가격 : <fmt:formatNumber value="${pDto.price}"/></p>
					      <p class="card-text">포인트 : <fmt:formatNumber value="${pDto.pPoint}"/></p>
					      <a href="cartAdd.do?pNum=${pDto.pNum}&pQty=1&pSpec=${pDto.pSpec}" 
					      	class="btn btn-outline-info" style="width:100%">장바구니 담기</a>
					    </div>
					 </div> <!-- card div -->
					 <c:if test="${cnt%4 == 0}">
					 	<!-- 카드를 감싸는 부모태그 닫고 열기 -->
					 	</div><div class='d-flex mt-4'>
					 </c:if> 	 --%>
					<%@ include file="prod_loop.jsp" %>
				  </c:forEach>
				  
				</div> <!-- 카드를 감싸는 부모태그 종료 -->	
				</c:if>
			<% } // for문 %>
			
			
		</section>
	</div>
</main>

<%@ include file="user_bottom.jsp" %>
