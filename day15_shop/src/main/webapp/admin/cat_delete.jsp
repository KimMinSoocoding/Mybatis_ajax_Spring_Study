<%@page import="ez.web.model.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

String catNum = request.getParameter("catNum");

//유효성 검사 
if(catNum == null || catNum.trim().equals("")){
	response.sendRedirect("cat_list.jsp");
	return;
}

CategoryDAO dao = CategoryDAO.getInstance();
int n = dao.categoryDel(catNum);
String msg = "", url ="cat_list.jsp";
if(n>0){
	msg="카테고리 삭제";
}else{
	msg="카테고리 삭제실패";
}

%>
<script>
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>