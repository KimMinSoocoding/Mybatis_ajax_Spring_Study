<%@page import="ez.web.model.ProductDTO"%>
<%@page import="ez.web.model.ProductDAO"%>
<%@page import="ez.web.model.CategoryDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ez.web.model.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ include file="ad_top.jsp" %>
<%
	String pNum = request.getParameter("pNum");

	if(pNum == null || pNum.trim().equals("")){
		response.sendRedirect("pd_list.jsp");
		return;
	}
	
	// 상품리스트에서 수정버튼을 클릭했을 때 
	// 해당 상품DTO를 DB에서 가져오기
	ProductDAO pDao = ProductDAO.getInstance();
	ProductDTO pDto = pDao.getProduct(pNum);
	
	System.out.println(pDto);

	CategoryDAO dao = CategoryDAO.getInstance();
	ArrayList<CategoryDTO> dtos=dao.categoryList();
	request.setAttribute("list", dtos);
	
	
%>
<main>
	<div class="container w-50 mt-5">
		<h3>상품 수정</h3>
		<table class="table table-borderless">
				<tbody>
					<tr>
						<td>카테고리</td>
						<td>
							<select class="form-select form-select-sm" name="pCategory_fk">
							<%-- 	<c:if test="${list == null || list.size() ==0}">
									<option value="">카테고리 없음</option>						
								</c:if>
								<!-- 해당 살품의 카테고리 코드가 보여지도록 -->
								<c:if test="${list != null || list.size() !=0}">
									<c:forEach var="cDto" items="${list}">
										<c:if test="${cDto.code == pDto.pCategory_fk }">
											<option value="${cDto.code}" selected>${cDto.catName}</option>
										</c:if>
										<c:if test="${dto.code == dto.pCategory_fk}">
											<option value="${cDto.code}">${cDto.catName}</option>
										</c:if>
									</c:forEach>
								</c:if>		 --%>
								
								<%
                           if(dtos == null || dtos.size() == 0){
                              out.println("<option value=0>");
                              out.println("카테고리 없음.");
                              out.println("</option>");
                           }else{
                              for(CategoryDTO cDto : dtos){
                                 String catName = cDto.getCatName();
                                 String catCode = cDto.getCode();
                                 
                                 if(cDto.getCode().equals(pDto.getpCategory_fk())){
                                 %>
                                    <option value="<%=catCode%>" selected>
                                       <%=catName%>
                                    </option>
                                 <%} else{ %>
                                    <option value="<%=catCode%>">
                                       <%=catName%>
                                    </option>
                                 <% } // if문
                                 } // for문
                           }// if문
                     %>
                              

							</select>
						</td>
					</tr>
					<tr>
						<td>상품명</td>
						<td><input type="text" class="form-control form-control-sm" name="pName"/></td>
					</tr>
					<tr>
						<td>제조회사</td>
						<td><input type="text" class="form-control form-control-sm" name="pCompany"/></td>
					</tr>
					<tr>
						<td>상품이미지</td>
						<td><input type="file" class="form-control form-control-sm" name="pImage"/></td>
					</tr>
					<tr>
						<td>상품수량</td>
						<td><input type="text" class="form-control form-control-sm" name="pQty"/></td>
					</tr>
					<tr>
						<td>상품가격</td>
						<td><input type="text" class="form-control form-control-sm" name="price"/></td>
					</tr>
					<tr>
						<td>상품사양</td>
						<td>
							<select class="form-select form-select-sm" name="pSpec">
								<option value="none" selected>일반</option>
								<option value="hit">인기</option>
								<option value="new">최신</option>
								<option value="recommend">추천</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>상품소개</td>
						<td>
							<textarea class="form-control" name="pContent" rows="3"></textarea>
						</td>
					</tr>
					<tr>
						<td>상품포인트</td>
						<td><input type="text" class="form-control form-control-sm" name="pPoint"/></td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<input type="submit" class="btn btn-sm btn-primary" value="상품등록"/>	
							<input type="reset" class="btn btn-sm btn-secondary" value="취소"/>	
						</td>
					</tr>
				</tbody>			
			</table>	
	</div>
</main>

<%@ include file="ad_bottom.jsp" %>