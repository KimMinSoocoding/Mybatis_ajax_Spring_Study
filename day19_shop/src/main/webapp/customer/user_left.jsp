<%@page import="ez.web.model.CategoryDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ez.web.model.CategoryDAO"%>
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
	      <a href="category_list.jsp?code=<%=code%>&catName=<%=catName %>"><%=catName%></a>
	    </li>
	<%	} // for문
	}else{ 
		out.println("<li class='nav-item'>카테고리가 없습니다!!!!</li>");
	}// if문
%>
		<li class="nav-item mt-3">
	      <a class="" href="spec_list.jsp?pSpec=hit">인기상품</a>
	    </li>
		<li class="nav-item">
	      <a class="" href="spec_list.jsp?pSpec=new">최신상품</a>
	    </li>
		<li class="nav-item">
	      <a class="" href="spec_list.jsp?pSpec=recommend">추천상품</a>
	    </li>

	  </ul>
	
</aside>