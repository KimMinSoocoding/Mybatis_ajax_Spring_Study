<%@page import="ez.web.model.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ez.web.model.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ad_top.jsp" %>
<main> 
<c:if test="${requestScope.msg != null }">
	<script>
		alert("${msg}");
	</script>
</c:if>
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
				/* ProductDAO dao = ProductDAO.getInstance();
				ArrayList<ProductDTO> dtos =dao.productList(); 
				if(dtos == null || dtos.size() ==0 ){
					out.println("<tr><td colspan='8'>상품이 존재하지 않습니다!!</td></tr></table>");
					return;
				}
				
				for(ProductDTO dto:dtos){
					*/
			%>
			<c:if test="${dtos ==null || dtos.size() == 0 }">
				<tr>
					<td colspan='8'>상품이 존재하지 않습니다!!</td>
				</tr>
			</c:if>
			<c:if test="${dtos != null || dtos.size() != 0 }">
				<c:forEach var="dto" items="${requestScope.dtos }">
		
				<tr>
					<td>${dto.pNum}</td>
					<td>${dto.pCategory_fk}</td>
					<td>
					<%-- <c:set var="ctx" value="${pageContext.request.contextPath}"/> --%>
						<c:set var="imgPath" value = "${ctx }/uploadedFile/${dto.pImage}"/>
						<img src="${imgPath}" style="width:60px"/>
					</td>
					<td>${dto.pName}</td>
					<td>${dto.price}</td>
					<td>${dto.pCompany}</td>
					<td>${dto.pQty}</td>
					<td>
						<a href="prodUpdate.do?pNum=${dto.pNum}" class="btn btn-sm btn-info">수정</a>
						<a href="javascript:pdDel('${dto.pNum}', '${dto.pImage}')" 
						   class="btn btn-sm btn-danger">삭제</a>
					</td>
				</tr>
				</c:forEach>
			</c:if>
			</tbody>
		</table>
	</div>
</main>
<script>
	function pdDel(pNum, pImage){
		var isDel = window.confirm("삭제 하시겠습니까?");
		if(isDel) location.href="prodDelete.do?pNum="+pNum+"&pImage="+pImage;
	}
</script>


<%@ include file="ad_bottom.jsp" %>