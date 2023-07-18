<%@page import="ez.web.model.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		
	request.setCharacterEncoding("utf-8");

 	//파라미터 수집
 	String code = request.getParameter("code");
 	String cname = request.getParameter("cname");
	
 	// 유효성 검색 
 	if(code == null || cname == null || code.trim().equals("") || cname.trim().equals("")){
 		response.sendRedirect("cat_input.jsp");
 		return;
 	}
 	
 	CategoryDAO dao =  CategoryDAO.getInstance();
 	int n = dao.insertCategory(code, cname);
 	
 	String msg="", url="";
 	
 	if(n>0){
 		msg= "카테고리 등록 완료!!";
 		url = "cat_list.jsp";
 	}else{
 		msg="카테고리 등록 실패!!";
 		url = "cat_input.jsp";
 	}
 		
 	
%>
<script>
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>