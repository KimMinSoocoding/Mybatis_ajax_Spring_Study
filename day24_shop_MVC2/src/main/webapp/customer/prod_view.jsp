<%@page import="java.text.DecimalFormat"%>
<%@page import="ez.web.model.ProductDTO"%>
<%@page import="ez.web.model.ProductDAO"%>
<%@page import="ez.web.model.CategoryDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ez.web.model.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<%@ include file="user_top.jsp" %>
<%
	String pNum = request.getParameter("pNum");
	String pSpec = request.getParameter("pSpec");
	
	if(pNum == null || pNum.trim().equals("")){
		response.sendRedirect("user_main.jsp");
		return;
	}
	
	ProductDAO pDao = ProductDAO.getInstance();
	ProductDTO pDto = pDao.getProduct(pNum);
	
	String specName = null;
	
	if(pSpec.equals("hit")){
		specName = "인기";
	}
	if(pSpec.equals("new")){
		specName = "최신";
	}
	if(pSpec.equals("recommend")){
		specName = "추천";
	}
	if(pSpec.equals("none")){
		specName = "일반";
	}
	
	
	//String specName = pSpec.equals("hit") ? "인기": pSpec.equals("new") ? "최신":"추천";
	
	if(pDto == null){
		out.println(pNum + "에 해당하는 상품이 없습니다!!");
	}
	
	DecimalFormat df = new DecimalFormat("###,###,###");
%>

<main>
	<div class="container mt-5 d-flex">
		<!-- 서브 메뉴  -->
		<%@ include file="user_left.jsp" %>
		
		<section class="w-75 ps-5">
			<h3>상품 정보[<%=specName%>]</h3>
			<ul class="d-flex p-0" style="list-style:none;">
				<!-- 상품 이미지 -->
				<li class="me-5">
					<img src="../uploadedFile/<%=pDto.getpImage()%>" width="220px"/>
				</li>
				<!-- 상품 상세내용 -->
				<li>
					<form name="prodForm" method="post">
						<input type="hidden" name="pSpec" value="<%=pSpec%>"/>
						상품번호 : <%=pNum%><br/>
						상품이름 : <%=pDto.getpName()%><br/>
						상품가격 : <%=df.format(pDto.getPrice())%><br/>
						상품포인트 : <%=df.format(pDto.getpPoint())%><br/>
						상품수량 : <input type="text" name="pQty" size="3" value="1"/>개<br/>
						<p class="mt-3"><b>[상품 소개]</b><br/>
							<%=pDto.getpContent() %>
						</p>
						
						<!-- 로그인 사용자만 장바구니 담기 허용 -->
						<c:if test="${sessionScope.isLogin !=null }">
							<a href="javascript:goCart(<%=pNum%>)" class="btn btn-sm btn-primary">장바구니 담기</a>
						</c:if>	
						<!-- 로그인을 안했을 경우 -->					
						<c:if test="${sessionScope.isLogin ==null }">
							<a href="javascript:showMsg()" class="btn btn-sm btn-primary">장바구니 담기</a>
						</c:if>
						
						
						<a href="javascript:history.back()" class="btn btn-sm btn-info">계속 쇼핑하기</a>
					</form>
				</li>
			</ul>
		</section>
	</div>
</main>
<script>
	function goCart(pNum){
		document.prodForm.action="cart_add.jsp?pNum="+pNum;
		document.prodForm.submit();
	}

	function showMsg(){
		alert("로그인이 필요합니다....")
	}
</script>

<%@ include file="user_bottom.jsp" %>
