<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="shopCart" class="ez.web.model.CartDAO" scope="session"/>

<%
	// 7/9/10
	String pNums = request.getParameter("delProdNums");

	// 상품번호 배열
	String[] pNumArr = pNums.split("/");
	
	if(pNumArr !=null && pNumArr.length > 0){
		for(int i=0; i<pNumArr.length; i++){
			// 장바구니에 있는 상품을 삭제
			shopCart.deleteProduct(pNumArr[i]);
		}
	}
	
	response.sendRedirect("check_out.jsp");	
%>