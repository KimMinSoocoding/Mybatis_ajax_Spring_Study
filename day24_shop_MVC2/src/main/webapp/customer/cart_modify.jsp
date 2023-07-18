<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="shopCart" class="ez.web.model.CartDAO" scope="session"/>

<%
	// 수정할 상품번호와 수량을 가져오기
	String pNum = request.getParameter("pNum");
	String pQty = request.getParameter("pQty");
	
	if(pNum == null || pNum.trim().equals("") || pQty == null || pQty.trim().equals("")){
%>
	<script>
		alert("잘못된 경로입니다!!!");
		history.back();
	</script>
<% } // if문
	
	try{
		shopCart.modifyProduct(pNum, pQty);
		response.sendRedirect("cart_list.jsp");
	}catch(NumberFormatException e){
%>
	<script>
		alert("수량을 잘못 입력하셨습니다!!!");
		history.back();
	</script>
<%		
	}
%>