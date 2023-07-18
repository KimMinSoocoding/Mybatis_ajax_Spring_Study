<%@page import="ez.web.model.CategoryDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ez.web.model.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ad_top.jsp" %>
<main>
<div class="container w-50 border shadow-sm p-5 mt-5 mb-3">
	<h3>카테고리 등록</h3>
	<table class="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>코드</th>
				<th>카테고리명</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
		<%
			CategoryDAO dao = CategoryDAO.getInstance();
			ArrayList<CategoryDTO> dtos =dao.categoryList();
			
			for(int i=0; i<dtos.size(); i++){
				CategoryDTO dto =dtos.get(i);
		%>
			<tr>
				<td><%=dto.getCatNum() %></td>
				<td><%=dto.getCode() %></td>
				<td><%=dto.getCatName() %></td>
				<td><a href="cat_delete.jsp?catNum=<%=dto.getCatNum()%>" 
					class = "btn btn-outline-danger btn-sam">삭제</a></td>
			</tr>
		<% } // for문 %>
		</tbody>
	</table>
	
</div>
</main>

<%@ include file="ad_bottom.jsp" %>