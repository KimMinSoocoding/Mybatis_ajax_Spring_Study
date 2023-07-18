<%@page import="ez.web.model.ProductDTO"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="user_top.jsp" %>

<jsp:useBean id="shopCart" class="ez.web.model.CartDAO" scope="session"/>
<main>
   <div class="container mt-5 d-flex">
      <!-- 서브 메뉴  -->
      <%@ include file="user_left.jsp" %>
      
      <section class="w-75 ps-5">
         <h3>장바구니 보기</h3>
         <table class="table">
            <thead>
               <tr>
                  <th>상품사진</th>
                  <th>상품명</th>
                  <th>수량</th>
                  <th>판매가</th>
                  <th>합계</th>
                  <th>삭제</th>
               </tr>
            </thead>
            <tbody>
            <%
               DecimalFormat df = new DecimalFormat("###,###,###");
            
               // 장바구니 총액, 누적 포인트
               int cartTotPrice = 0, cartTotPoint = 0;
               ArrayList<ProductDTO> pDtos =shopCart.getCartList();
               
               System.out.println("pDtos size : " +pDtos.size());
               
               if(pDtos == null || pDtos.size() ==0){
                  out.println("<tr><td colspan='6'>");
                  out.println("장바구니가 비었습니다!!");
                  out.println("</tr>");
                  return;
               }
               
               // 장바구니 상품 출력하기
               for(ProductDTO pDto : pDtos){
            %>
               <tr>
                  <td>
                     <a href="prod_view.jsp?pNum=<%=pDto.getpNum()%>&pSpec=<%=pDto.getpSpec()%>">
                     <img src="../uploadedFile/<%=pDto.getpImage()%>" width="80px"/>
                     </a>
                  </td>
                  <td><%=pDto.getpName()%></td>
                  <td>
                     <form action="cart_modify.jsp" method="post">
                        <input type="text" size="3" name="pQty" value="<%=pDto.getpQty()%>"/>개<br/>
                        <input type="hidden" name="pNum" value="<%=pDto.getpNum()%>"/>
                        <input type="submit" class="btn btn-sm btn-secondary mt-3" value="수정"/>
                     </form>
                  </td>
                  <td>
                     <%=df.format(pDto.getPrice())%>원 <br/>
                     [<%=df.format(pDto.getpPoint())%>] point 
                  </td>
                  <td>
                     <%=df.format(pDto.getTotPrice())%>원 <br/>
                     [<%=df.format(pDto.getTotPoint())%>] point
                  </td>
                  <td>
                     <a href="cart_delete.jsp?pNum=<%=pDto.getpNum()%>" class="btn btn-sm btn-danger">삭제</a>
                  </td>
               </tr>
               <%
                  // 장바구니 총액 구하기
                  cartTotPrice +=pDto.getTotPrice();                  
                  // 장바구니 총 누적 포인트
                  cartTotPoint +=pDto.getTotPoint();
               %>
            <%} // for문 %>   
            </tbody>
         </table>
         <!-- 장바구니 총액 표시 -->
         <div class="text-end">
            장바구니 총액 : <%=df.format(cartTotPrice) %>원<br/>
            총 포인트 : <%=df.format(cartTotPoint) %> 포인트
         </div>
         <div class="text-center mt-5">
            <a href="check_out.jsp?cartTotPrice=<%=cartTotPrice%>&cartTotPoint=<%=cartTotPoint%>" class="btn btn-primary me-2">구매하기</a>
            <a href="user_main.jsp" class="btn btn-outline-primary">계속 쇼핑하기</a>
         </div>
         
      </section>
   </div>
</main>

<%@ include file="user_bottom.jsp" %>