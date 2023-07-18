<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<c:set var="ctx" value="${pageContext.request.contextPath}"/>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<link href="${ctx}/css/ad_Login.css" rel="stylesheet" type="text/css">
</head>
<body>

<section class="vh-100">
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-6 text-black">

        <div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">

			<form action="${ctx}/adminLoginOk.do">
          	
          	<div style="width: 23rem;">

            <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Shop Admin Login</h3>

            <div class="form-outline mb-4">
              <lable for="id">ID</lable>	
              <input type="text" id="id" class="form-control form-control-lg" placeholder="ID address" 
              name="id" value="<c:if test="${sessionScope.id !=null and loginErr !='idErr'}">${sessionScope.id}</c:if>"/>
              <c:if test="${loginErr == 'idErr'}">
				<p class="text-danger">아이디를 확인하세요</p>
             <!--  <label class="form-label" for="id">ID address</label> -->
			</c:if>
            </div>

            <div class="form-outline mb-4">
              <lable for="pw">PW</lable>		
              <input type="password" id="pw" name="pw"  class="form-control form-control-lg" placeholder="Password" />
              <c:if test="${loginErr == 'pwErr'}">
				<p class="text-danger">비밀번호를 확인하세요!!</p>
			  </c:if>
             <!--  <label class="form-label" for="form2Example28">Password</label> -->
            </div>

            <div class="pt-1 mb-4">
              <button class="btn btn-info btn-lg btn-block" type="submit">Login</button>
            </div>

			</div> <!-- loginOk 의 form -->
         
			
          </form>

        </div>

      </div>
      <div class="col-sm-6 px-0 d-none d-sm-block">
        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img3.webp"
          alt="Login image" class="w-100 vh-100" style="object-fit: cover; object-position: left;">
      </div>
    </div>
  </div>
</section>

</body>
</html>