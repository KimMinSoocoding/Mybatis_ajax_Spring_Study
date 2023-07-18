<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id = "shopCart" class="ez.web.model.CartDAO" scope="session" />

<% 
	String pNums = request.getParameter("delProdNums");

	String[] pNumArr = pNums.split("/");
	
	if(pNumArr !=null && pNumArr.length > 0){
		for(int i=0; i<pNumArr.length; i++){
			shopCart.deleteProduct(pNumArr[i]);
		}
	}
	
	response.sendRedirect("check_out.jsp");
%>