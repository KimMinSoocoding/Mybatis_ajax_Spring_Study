<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="shopCart" class="ez.web.model.CartDAO" scope="session"/>

<% 
	//삭제할 상품번호 가져오기 
	
	
	String pNum = request.getParameter("pNum");

	if(pNum == null || pNum.trim().equals("")){
%>
	<script>
		alert("잘못된 경로입니다!!");
		history.back();
	</script>
	<%} //if문 
		
		shopCart.deleteProduct(pNum);
		response.sendRedirect("cart_list.jsp");
	%> 
	