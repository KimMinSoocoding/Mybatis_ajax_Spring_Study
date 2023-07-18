<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set var= "cnt" value="${cnt+1}"/>
				<div class="card <c:if test="${cnt%4 !=0}">me-4</c:if>" style="width:200px">
					<a href="prodView.do?pNum=${pDto.pNum}&pSpec=${pDto.pSpec}" style="overflow:hidden; height:120px;">
				    	<img class="card-img-top" src="${ctx}/uploadedFile/${pDto.pImage}" alt="Card image" 
				    	style="width:100%;">
				    </a>	
				    <div class="card-body">
				      <h4 class="card-title" style="font-size:15px; overflow:hidden; text-overflow:ellipsis; 
					      	white-space:nowrap;"><b>상품명 : ${pDto.pName}</b></h4>
				      <p class="card-text">가격 : <fmt:formatNumber type="Number" value="${pDto.price}"/></p>
				      <p class="card-text">포인트 : <fmt:formatNumber type="Number" value="${pDto.pPoint}"/></p>
				      <c:if test="${sessionScope.isLogin !=null}">
				      <a href="cartAdd.do?pNum=${pDto.pNum}&pQty=1&pSpec=${pDto.pSpec}&pCategory_fk=${requestScope.code}" 
				      class="btn btn-outline-info" style="width:100%">장바구니 담기</a>
				      </c:if>
				      <c:if test="${sessionScope.isLogin == null}">
				      <a href="javascript:alert('로그인이 필요합니다')"
				      class="btn btn-outline-info" style="width:100%">장바구니 담기</a>
				      </c:if>
				    </div>
				 </div> <!-- card div -->
				 <c:if test="${cnt%4 == 0}">
				 	</div><div class="d-flex mt-4">
				 </c:if>