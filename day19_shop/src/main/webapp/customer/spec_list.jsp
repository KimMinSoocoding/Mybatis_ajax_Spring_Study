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
         String spec = request.getParameter("pSpec");
         
         /*  String code = request.getParameter("code");  */
         
         
         DecimalFormat df = new DecimalFormat("###,###,###");
         
         ArrayList<ProductDTO> pDtos = null; 
         // main에서 이미 맵에 사양별로 저장해두었기 때문에
         // 데이터베이스 테이블 사용하지 않고 맵에서 데이터를 가져옴
         // 사양별로 가져오기 때문에 전체 상품 중에서 검색하지 않고
         // 해당 사양에서만 상품을 검색할 수 있어 효율적이다.
         Boolean bool = pDao.map.containsKey(spec);
         System.out.println(bool);
         
         if(!bool){
            out.println("상품이 존재하지 않습니다!!!");
         }else{
            pDtos=pDao.map.get(spec);
            String specName = spec.equals("hit") ? "인기": spec.equals("new") ? "최신":"추천";
      %>
      <h3>[<%=specName%>]</h3>
      <div class="d-flex">
         <%
            int cnt = 0;
            for(ProductDTO pDto: pDtos){
               cnt++;
               int pNum = pDto.getpNum();
               String pName = pDto.getpName();
               String pSpec = pDto.getpSpec();
               String pImage = pDto.getpImage();
               int price = pDto.getPrice();
               int pPoint = pDto.getpPoint();
         %>
         <div class="card <% if(cnt%4 !=0) out.println("me-4");%>" style="width:200px">
            <!-- <a href="" style="overflow:hidden; height:120px;"> -->
            <a href="prod_view.jsp?pNum=<%=pNum%>&pSpec=<%=pSpec%>" style="overflow:hidden; height:120px;">
                <img class="card-img-top" src="../uploadedFile/<%=pImage%>" alt="Card image" 
                style="width:100%;">
             </a>   
             <div class="card-body">
               <h4 class="card-title" style="font-size:15px; overflow:hidden; text-overflow:ellipsis; 
                     white-space:nowrap;"><b>상품명 : <%=pName%></b></h4>
               <p class="card-text">가격 : <%=df.format(price) %></p>
               <p class="card-text">포인트 : <%=df.format(pPoint) %></p>
               <a href="cart_add.jsp?pNum=<%=pNum%>&pQty=1&pSpec=<%=pSpec%>" class="btn btn-outline-info" style="width:100%">장바구니 담기</a>
             </div>
          </div> <!-- card div -->
             <%
                if(cnt%4==0){
                   out.println("</div><div class='d-flex mt-4'>");
                }
             %>
         <%} // for문 %>
         </div>   
         <%
         } //if문
         %>
      
      </section>
   </div>
</main>

<%@ include file="user_bottom.jsp" %>