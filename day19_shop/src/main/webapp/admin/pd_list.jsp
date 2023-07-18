<%@page import="ez.web.model.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ez.web.model.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ad_top.jsp" %>
<main>
	<div class="container w-75 mt-5">
		<h3>상품 리스트</h3>
		<table class="table">
			<thead>
				<tr>
					<th>번호</th>					
					<th>카테고리 코드</th>
					<th>이미지</th>
					<th>상품명</th>
					<th>가격</th>
					<th>제조사</th>
					<th>수량</th>
					<th>수정/삭제</th>
				</tr>
			</thead>
			<tbody>
			<%
				ProductDAO dao = ProductDAO.getInstance();
				ArrayList<ProductDTO> dtos =dao.productList();
				if(dtos == null || dtos.size() ==0 ){
					out.println("<tr><td colspan='8'>상품이 존재하지 않습니다!!</td></tr></table>");
					return;
				}
				
				for(ProductDTO dto:dtos){
			%>
				<tr>
					<td><%=dto.getpNum()%></td>
					<td><%=dto.getpCategory_fk()%></td>
					<td>
						<% String imgPath = request.getContextPath()+"/uploadedFile/"+dto.getpImage();%>
						<img src="<%=imgPath%>" style="width:60px"/>
					</td>
					<td><%=dto.getpName()%></td>
					<td><%=dto.getPrice()%></td>
					<td><%=dto.getpCompany()%></td>
					<td><%=dto.getpQty()%></td>
					<td>
						<a href="pd_update.jsp?pNum=<%=dto.getpNum()%>" class="btn btn-sm btn-info">수정</a>
						<a href="javascript:pdDel('<%=dto.getpNum()%>', '<%=dto.getpImage()%>')" 
						   class="btn btn-sm btn-danger">삭제</a>
					</td>
				</tr>
			<% } %>
			</tbody>
		</table>
	</div>
</main>
<script>
	function pdDel(pNum, pImage){
		var isDel = window.confirm("삭제 하시겠습니까?");
		if(isDel) location.href="pd_del.jsp?pNum="+pNum+"&pImage="+pImage;
	}
</script>


<%@ include file="ad_bottom.jsp" %>