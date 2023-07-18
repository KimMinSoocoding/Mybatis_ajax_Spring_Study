<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css' rel='stylesheet'>
<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js'></script>

<!-- custom CSS -->
<link rel="stylesheet" href="${ctx}/css/main.css">
<script>
  	$(document).ready(function(){
		<c:if test="${sessionScope.msg != null}">
			alert("${sessionScope.msg}");
		</c:if>
		<c:remove var="msg" scope="session"/>
	});  

	function chkValidation(){
		if($("#user_id").val()==''){
			//alert("아이디를 입력하세요!!");
			$("#idMsg").css("display", "block");
			
			$("#user_id").focus();
			return false;
		}
		
		if($("#pw").val()==''){
			$("#pwMsg").css("display", "block");
			
			$("#pw").focus();
			return false;
		}
		return true;
	}
	
	function valueChk(obj){
		if(obj.id == "user_id"){
			$("#idMsg").css("display","none");
		}else{
			$("#pwMsg").css("display","none");
		}
	}
	
	function clearValue(){
		$("#user_id").val("");
		$("#pw").val("");
	}
	
	function logout(){
		// c:url를 이용하면 ${ctx}를 생략할 수 있다.
		location.href="<c:url value='/memberLogout.do'/>";
	}
	
</script>

</head>
<body>
<c:if test="${requestScope.msg !=null}">
<script>
	alert("${requestScope.msg}");
</script>                          
</c:if>

	<div class="container">
		<br/>
		<h3><a href="">Web Study</a></h3>
	</div>
	<nav class="navbar navbar-expand-sm sticky-top">
	<div class="container">
	  <div class="collapse navbar-collapse" id="mynavbar">
	      <ul class="navbar-nav w-100">
	        <li class="nav-item">
	          <a class="nav-link" href="${ctx}">HOME</a>
	        </li>
	        
	        <li class="nav-item">
	          <a class="nav-link" href="memberList.do">회원 리스트</a>
	        </li>
	        
	        <li class="nav-item ms-auto d-flex p-1">
	        <c:if test="${sessionScope.userId == null}">
	          <a class="btn btn-sm btn-outline-light" data-bs-toggle="modal" 
	          data-bs-target="#loginModal" type="button">로그인</a>
	         </c:if> 
	        <c:if test="${sessionScope.userId != null}">
	          <div class="me-3 welcomeMsg">${sessionScope.userName}님 환영합니다!!</div>
	          <a href="javascript:logout()" class="btn btn-sm btn-outline-light" 
	          	type="button">로그아웃</a>
	         </c:if> 
	        </li>
	        
	      </ul>
	  </div>
	</div>  
	</nav>



<!-- The Modal -->
<div class="modal fade" id="loginModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header border-0">
        <button type="button" class="btn-close" 
        	data-bs-dismiss="modal" onclick="clearValue()"></button>
      </div>

      <!-- Modal body -->
      <form action="memberLogin.do" method="post">
	      <div class="modal-body p-4">
	        <input class="form-control" type="text" placeholder="아이디" 
	        id="user_id" name="user_id" onkeyup="valueChk(this)"/>
	        <p id="idMsg">아이디를 입력하세요!!</p>
	        <input class="form-control mt-2" type="password" 
	        placeholder="비밀번호" id="pw" name="pw" onkeyup="valueChk(this)"/>
	        <p id="pwMsg">비밀번호를 입력하세요!!</p>
	        
	      </div>
	      <!-- Modal footer -->
	      <div class="modal-footer border-0 p-4">
	        <button type="submit" class="btn btn-primary w-100"	        
	        onclick="return chkValidation()">로그인</button>
	      </div>
	  </form> 	
	  
	  <div class="row mt-2 mb-4 px-5">
	  	 <div class="col-md-4 p-0 m-0 pe-1">
	  	 	<a href="idpw.do?find=id" class="btn btn-sm btn-light w-100">아이디 찾기</a>
	  	 </div>
	  	 <div class="col-md-4 p-0 m-0 ">
	  	 	<a href="idPw.do?find=pw" class="btn btn-sm btn-light w-100">비밀번호 찾기</a>
	  	 </div>
	  	 <div class="col-md-4 p-0 m-0 ps-1">
	  	 	<a href="memberRegister.do" class="btn btn-sm btn-light w-100">회원가입</a>
	  	 </div>
	  </div>

    </div>
  </div>
</div>

