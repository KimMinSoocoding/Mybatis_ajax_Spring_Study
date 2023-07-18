<%@page import="flower.util.ProdSpec"%>
<%@page import="flower.model.CategoryDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="flower.model.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<aside class="border-end" style="width:200px">
	<h4>카테고리</h4>
	  <ul class="nav flex-column">
<%
	CategoryDAO cDao = CategoryDAO.getInstance();
	ArrayList<CategoryDTO> cDtos = cDao.categoryList();
	
	if(cDtos !=null || cDtos.size() !=0){
		for(CategoryDTO cDto : cDtos){
			String catName = cDto.getCatName();
			String code = cDto.getCode(); 
	%>					
	    <li class="nav-item">
	      <a href="categoryList.do?code=<%=code%>&catName=<%=catName%>"><%=catName%></a>
	    </li>
	<%	} // for문
	}else{ 
		out.println("<li class='nav-item'>카테고리가 없습니다!!!!</li></ul>");
	}// if문
	
	out.println("<ul class='nav flex-column mt-3'>");
	ProdSpec[] pdSpecs = ProdSpec.values();
	for(ProdSpec ps : pdSpecs){
		pageContext.setAttribute("ps", ps);
	
%>
		<li class="nav-item">
	      <a class="" href="speclist.do?pSpec=${ps.name()}">${ps.getValue()}상품</a>
	    </li>
<%} // for문 %>
	  </ul>
	
</aside>