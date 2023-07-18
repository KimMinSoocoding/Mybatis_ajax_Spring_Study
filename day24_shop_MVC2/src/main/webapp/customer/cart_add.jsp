<%@page import="ez.web.model.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="shopCart" class="ez.web.model.CartDAO" scope="session"/>
<%
	String pNum = request.getParameter("pNum");
	String pSpec = request.getParameter("pSpec");
	String pCategory_fk = request.getParameter("pCategory_fk");
	String pQty = request.getParameter("pQty");
	
/* 	System.out.println("pNum : " + pNum);
	System.out.println("pSpec : " + pSpec);
	System.out.println("pQty : " + pQty); */
	
	ProductDAO pDao = ProductDAO.getInstance();
	
	if(pCategory_fk == null){ // user_main에서는 spec별 맵에서 검색
		// 사양별 해시맵에서 상품을 가져와 장바구니에 상품 추가
		// 사양별 해시맵은 일반상품을 제외한 인기, 최신, 추천 상품만 존재
		// 사양별 해시맵에서는 일반상품은 검색이 안됨
		shopCart.addProduct(pDao, pNum, pQty, pSpec);
	
	}else{	// category_list에서는 카테고리별 맵에서 검색 
		
		// 카테고리별 해시맵에서 상품을 가져와 장바구니에 추가
		// 카테고리별 해시맵에는 모든 상품이 존재한다.(일반, 추천, 인기, 최신 모두 존재)
		shopCart.addProduct(pDao, pNum, pQty, pCategory_fk);
	}
	
	System.out.println("장바구니 담기 성공!!");
	response.sendRedirect("cart_list.jsp");
%>    