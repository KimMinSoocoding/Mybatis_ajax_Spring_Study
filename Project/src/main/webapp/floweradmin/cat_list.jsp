<%@page import="flower.model.CategoryDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="flower.model.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="ad_top.jsp" %>

<c:if test="${requestScope.msg != null}">
<script>
	alert("${requestScope.msg}")
</script>
</c:if>
<main>
<div class="container w-50 border shadow-sm p-5 mt-5 mb-3">
	<h3>카테고리 목록</h3>
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
/* 			CategoryDAO dao = CategoryDAO.getInstance();
			ArrayList<CategoryDTO> dtos =dao.categoryList();
			
			for(int i=0; i<dtos.size(); i++){
				CategoryDTO dto =dtos.get(i);
 */			
		%>
		<c:forEach var="dto" items="${requestScope.dtos}">
			<tr>
				<td>${dto.catNum}</td>
				<td>${dto.code}</td>
				<td>${dto.catName}</td>
				<td><a href="catDelete.do?catNum=${dto.catNum}" 
					class = "btn btn-outline-danger btn-sam">삭제</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
</div>
</main>

<%@ include file="ad_bottom.jsp" %>