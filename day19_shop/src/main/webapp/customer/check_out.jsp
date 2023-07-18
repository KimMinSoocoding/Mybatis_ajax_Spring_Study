<%@page import="ez.web.model.MemberDTO"%>
<%@page import="ez.web.model.MemberDAO"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="ez.web.model.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<jsp:useBean id="shopCart" class="ez.web.model.CartDAO" scope="session"/>    

    
<%@ include file="user_top.jsp" %>
<main>
   <div class="container mt-5 d-flex">
      <!-- 서브 메뉴  -->
      <%@ include file="user_left.jsp" %>
      
      <section class="w-75 ps-5">
         <h2 class="mb-5">주문 / 결제</h2>
         <table class="table">
            <thead>
               <tr>
                  <th><input type="checkbox" id="checkAll" onclick="checkAll()"/>삭제</th>
                  <th>상품사진</th>
                  <th>상품명</th>
                  <th>수량</th>
                  <th>판매가</th>
                  <th>합계</th>
               </tr>
            </thead>
         
            <tbody>
            <%   
               // 장바구니 총액, 누적 포인트
               int cartTotPrice = 0, cartTotPoint = 0;
            
               DecimalFormat df = new DecimalFormat("###,###,###");
               // 장바구니 상품을 모두 가져오기
               ArrayList<ProductDTO> pDtos = shopCart.getCartList();
            
               // 장바구니 상품 출력하기
               for(ProductDTO pDto : pDtos){
            %>
               <tr>
                  <td><input type="checkbox" name="chk" value="<%=pDto.getpNum()%>"/></td>
                  <td>
                     <image src="../uploadedFile/<%=pDto.getpImage()%>" width="80px"/>
                  </td>
                  <td><%=pDto.getpName()%></td>
                  <td><%=pDto.getpQty()%> 개</td>
                  <td><%=pDto.getPrice()%> 원</td>
                  <td><%=df.format(pDto.getTotPrice())%> 원 <br/>
                      [<%=df.format(pDto.getTotPoint())%>] point
                  </td>
               </tr>
               <%
                  // 장바구니 총액 구하기
                  cartTotPrice +=pDto.getTotPrice();                  
                  // 장바구니 총 누적 포인트
                  cartTotPoint +=pDto.getTotPoint();
               %>
               
            <%} // for문%>
               <tr>
                  <form action = "cart_delete2.jsp" name="cartForm" method="post">
                     <input type="hidden" name="delProdNums" />
                     <td colspan="6">
                        <a href="javascript:prodDel()" class="btn btn-sm btn-outline-secondary">선택삭제</a>
                     </td>
                  </form>
               </tr>   
               
            </tbody>
         </table>
         <table class="table">
         <%
            // 구매할 사람(로그인한 유저)의 정보를 가져오기
            String id = (String)session.getAttribute("id");
            MemberDAO mDao = MemberDAO.getInstance();
            
            MemberDTO mDto = mDao.getMember(id);
         %>
            <thead>
               <tr>
                  <th>구매자 정보</th>
               </tr>
            </thead>
            <tbody>
               <tr>
                  <td>이름</td>
                  <td><%=mDto.getName()%></td>
               </tr>
               <tr>
                  <td>이메일</td>
                  <td><%=mDto.getEmail()%></td>
               </tr>
               <tr>
                  <td>전화번호</td>
                  <td><%=mDto.getTel()%></td>
               </tr>
               <tr>
                  <td><b>받는사람 정보</b></td>
               </tr>
               <tr>
                  <td>이름</td>
                  <td><%=mDto.getName()%></td>
               </tr>
               <tr>
                  <td>배송지 주소</td>
                  <td><%=mDto.getAddr()%></td>
               </tr>
               <tr>
                  <td>전화번호</td>
                  <td><%=mDto.getTel()%></td>
               </tr>
               <tr>
                  <td><b>결제정보</b></td>
               </tr>
               <tr>
                  <td>총 주문금액</td>
                  <td><fmt:formatNumber type="number" value="<%=cartTotPrice%>"/>원</td>
               </tr>
               <tr>
                  <td>포인트</td>
                  <td>
                  <!--
                     oninput : 값이 입력될때 주어졌을 발생하는 이벤트
                     onfocus : 포커스가 주어졌을 때 발생하는 이벤트
                     onkeyup : 키를 눌렀다가 떼었을 때
                     onchange : 요소의 변경이 발생했을 때
                     (텍스트를 입력하고 있는 중에는 이벤트 발생이 없고 변경이 모두 끝나면 발생)
                    -->
                     <input type="text" id="point" size="10"
                        oninput ="removeChar(event)"
                        onfocus ="clearVal(this)"
                        onkeyup = "enterKey(this,<%=cartTotPoint%>,<%=cartTotPrice%>)"
                        onchange = "inputPoint(this, <%=cartTotPoint%>)"
                     />
                     <input type="checkbox" id="use" onclick="usePoint(this,<%=cartTotPoint%>,<%=cartTotPrice%>)"/>
                     <label for="use">
                        전액사용 [<b><fmt:formatNumber type="number" value="<%=cartTotPoint%>"/></b>원]
                     </label>
                  </td>
               </tr>

               <tr>
                  <td>결제금액</td>
                  <td id="cartTotPrice">
                     <fmt:formatNumber type="number" value="<%=cartTotPrice%>"/> 원
                  </td>
               </tr>
               
               <tr>
                  <td>결제방법</td>
                  <td>
                     <label><input type="radio" name="payment" value="card" onclick="selPayment()" checked/>신용카드</label>
                     <label><input type="radio" name="payment" value="rTransfer" onclick="selPayment()"/>실시간 계좌이체</label>
                     <label><input type="radio" name="payment" value="deposit" onclick="selPayment()"/>무통장 입금</label>
                     <label><input type="radio" name="payment" value="hp" onclick="selPayment()"/>휴대폰</label>
                  </td>
               </tr>
            </tbody>
         </table>
         
         <div id="card">
            카드선택 : <select>
               <option value="" selected>카드사 선택</option>
               <option value="samsung">삼성카드</option>
               <option value="shinhancard">신한카드</option>
               <option value="lotte">롯데카드</option>
               <option value="bc">비씨카드</option>
               <option value="hyundai">현대카드</option>
            </select><br/><br/>
            할부기간 : <select <c:if test="<%= cartTotPrice < 50000 %>">disabled</c:if>> 
               <option value="1" selected>일시불</option>
               <option value="2">2개월 무이자할부</option>
               <option value="3">3개월 무이자할부</option>
               <option value="4">4개월 무이자할부</option>
               <option value="5">5개월 무이자할부</option>
               <option value="6">6개월 무이자할부</option>
            </select><br/><br/>
         </div>
         <div id="rTransfer" style="display:none">
            은행선택 : <select>
               <option value="" selected>은행선택</option>
               <option value="kakao">카카오뱅크</option>
               <option value="woori">우리은행</option>
               <option value="kookmin">국민은행</option>
               <option value="shinhan">신한은행</option>
            </select>
         </div>
         <div id="deposit" style="display:none">
            입금은행 : <select>
               <option value="" selected>은행선택</option>
               <option value="kakao">카카오뱅크</option>
               <option value="woori">우리은행</option>
               <option value="kookmin">국민은행</option>
               <option value="shinhan">신한은행</option>
            </select>
            <ul style="font-size:11px">
               무통장 입금시 유의사항
               <li>입금완료 후 상품품절로 인해 자동취소된 상품은 환불 처리해 드립니다.</li>
               <li>무통장입금 결제 시 부분취소가 불가하며 전체취소 후 다시 주문하시기 바랍니다.</li>
               <li>은행 이체 수수료가 발생될 수 있습니다. 입금시 수수료를 확인해주세요.</li>
            </ul>
         </div>
         <div id="hp" style="display:none">
            통신사 : <select>
                  <option value="" selected>선택</option>
                  <option value="skt">SK</option>
                  <option value="lg">LG U+</option>
                  <option value="kt">KT</option>
            </select>
         </div>
         <div class="text-center">
            <button class="btn btn-primary">결제하기</button>
            <a href="user_main.jsp" class="btn btn-outline-primary">계속 쇼핑하기</a>
         </div>
      </section>
   </div>
</main>

<script src="../js/chkout.js"></script>

<%@ include file="user_bottom.jsp" %>      