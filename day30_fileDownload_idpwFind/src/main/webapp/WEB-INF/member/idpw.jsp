<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>'
    
<%@ include file="../../inc/header.jsp" %>
<style>
   .nav-link.btn-tab {
      font-size:14px;
      color:#bbb;
      background-color:#efefef;
   }
</style>
<div class="container">
   <div class="mt-5 mx-auto p-5 rounded border shadow-sm" style="width:500px;">
      <!--############ tab ############-->
      <div class="nav nav-tabs" id="nav-tab" role="tablist">
          <button class="nav-link btn-tab <c:if test="${requestScope.find == 'id'}">active</c:if>" id="nav-home-tab" data-bs-toggle="tab" data-bs-target="#nav-id"
          type="button" role="tab" aria-controls="nav-home" aria-selected="true">아이디 찾기</button>
          
          <button class="nav-link btn-tab <c:if test="${requestScope.find == 'pw'}">active</c:if>" id="nav-profile-tab" data-bs-toggle="tab" data-bs-target="#nav-pw"
          type="button" role="tab" aria-controls="nav-profile" aria-selected="false">비밀번호 찾기</button>
      </div>
      
      <div class="tab-content" id="myTabContent">
      
      <!-- ############### 아이디 tab 컨텐츠 ############### -->
         <div class="tab-pane <c:if test="${requestScope.find == 'id'}">show active</c:if> mt-4 text-center" id="nav-id" role="tabpanel" aria-labelledby="home-tab" tabindex="0">
            <h5>아이디 찾기</h5>
            <c:if test = "${requestScope.findId !=null}">
               <p class="mb-4"><small>회원가입 아이디는 <b>${fn:substring(requestScope.findId,0,2)}<c:forEach begin="1" end="${fn:length(requestScope.findId)-2}">*</c:forEach></b> 입니다.</small></p>
               <a class="btn btn-primary w-50" data-bs-toggle="modal" 
             data-bs-target="#loginModal">로그인</a>
            </c:if>
            <c:if test = "${requestScope.findId ==null}">
               <!-- 이름과 이메일일 잘못입력된 경우 -->
               <c:if test="${requestScope.idMsg != null}">
                  <p class="mb-4"><small>${requestScope.idMsg}</small></p>
               </c:if>
               <!-- 최초에 접근시 -->
               <c:if test="${requestScope.idMsg == null}">
                  <p><small>회원 가입시 이름과 이메일을 입력하세요!</small></p>
               </c:if>
            <form action="${ctx}/findIdPw.do?find=id" method="post">
               <input class="form-control mb-3" type="text" name="name" placeholder="이름"/>
               <input class="form-control mb-3" type="text" name="email" placeholder="이메일"/>
               
               <input type="submit" value="찾기" class="btn btn-primary mt-2 w-100"/>
            </form>
            </c:if>
         </div>
         
         <!-- ############### 비밀번호 tab 컨텐츠 ############### -->
         <div class="tab-pane <c:if test="${requestScope.find == 'pw'}">show active</c:if> text-center mt-4" id="nav-pw" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
            <h5>비밀번호 찾기</h5>
            <c:if test = "${requestScope.findPw !=null}">
               <p class="mb-4"><small>회원가입 비밀번호는 <b>${fn:substring(requestScope.findPw,0,2)}<c:forEach begin="1" end="${fn:length(requestScope.findPw)-2}">*</c:forEach></b> 입니다.</small></p>
               <a class="btn btn-primary w-50" data-bs-toggle="modal" 
             data-bs-target="#loginModal">로그인</a>
            </c:if>
            <c:if test = "${requestScope.findPw ==null}">
               <!-- 아이디와 이름, 이메일이 잘못입력된 경우 -->
               <c:if test="${requestScope.pwMsg != null}">
                  <p class="mb-4"><small>${requestScope.pwMsg}</small></p>
               </c:if>
               <!-- 최초에 접근시 -->
               <c:if test="${requestScope.pwMsg == null}">
                  <p><small>회원 가입시 아이디와 이름, 이메일을 입력하세요!</small></p>
               </c:if>
            <form action="${ctx}/findIdPw.do?find=pw" method="post">
               <input class="form-control mb-3" type="text" name="id" placeholder="아이디"/>
               <input class="form-control mb-3" type="text" name="name" placeholder="이름"/>
               <input class="form-control mb-3" type="text" name="email" placeholder="이메일"/>
               
               <input type="submit" value="찾기" class="btn btn-primary mt-2 w-100"/>
            </form>
            </c:if>
         </div>
      </div>
   </div>
</div> <!-- container -->

<%@ include file="../../inc/footer.jsp" %>