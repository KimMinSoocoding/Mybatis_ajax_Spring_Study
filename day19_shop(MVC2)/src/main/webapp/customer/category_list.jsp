<%@page import="java.text.DecimalFormat"%>
<%@page import="ez.web.model.ProductDTO"%>
<%@page import="ez.web.model.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="user_top.jsp" %>
<main>
   <div class="container mt-5 d-flex">
      <!-- 서브 메뉴  -->
      <%@ include file="user_left.jsp" %>
      
      <section class="w-75 ps-5">
      <%
         ProductDAO pDao = ProductDAO.getInstance();
         String code = request.getParameter("code");
         String catName = request.getParameter("catName");
         
         ArrayList<ProductDTO> pDtos = pDao.getProductByCategory(code);
         
         DecimalFormat df = new DecimalFormat("###,###,###");
         
         if(pDtos == null || pDtos.size() == 0){
            out.println("상품이 존재하지 않습니다!!!");
         }else {
      %>
      <h3>[<%=catName%>]</h3>
      <div class="d-flex">
         <%
               for(ProductDTO pDto: pDtos){
                  int pNum = pDto.getpNum();
                  String pName = pDto.getpName();
                  String pSpec = pDto.getpSpec();
                  String pImage = pDto.getpImage();
                  int price = pDto.getPrice();
                  int pPoint = pDto.getpPoint();
         %>
         <div class="card me-4" style="width:200px">
            <a href="prod_view.jsp?pNum=<%=pNum%>&pSpec=<%=pSpec%>" style="overflow:hidden; height:120px;">
                <img class="card-img-top" src="../uploadedFile/<%=pImage%>" alt="Card image" 
                style="width:100%;">
             </a>   
             <div class="card-body">
               <h4 class="card-title" style="font-size:15px; overflow:hidden; text-overflow:ellipsis; 
                     white-space:nowrap;"><b>상품명 : <%=pName%></b></h4>
               <p class="card-text">가격 : <%=df.format(price)%></p>
               <p class="card-text">포인트 : <%=df.format(pPoint)%></p>
               <a href="cart_add.jsp?pNum=<%=pNum%>&pQty=1&pCategory_fk=<%=code%>" class="btn btn-outline-info" style="width:100%">장바구니 담기</a>
             </div>
          </div> <!-- card div -->
         <%} // for문 %>
         </div>   
         <%
         } //if문
         %>
      
      </section>
   </div>
</main>

<%@ include file="user_bottom.jsp" %>