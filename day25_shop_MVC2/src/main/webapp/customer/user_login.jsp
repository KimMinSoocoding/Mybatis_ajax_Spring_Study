<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    
<%@ include file="user_top.jsp" %> 
<c:if test="${msg !=null}">
	<script>
		alert("${requestScope.msg}")
	</script>
</c:if>   
<div class="container mt-5 w-50 border shadow p-5">
	<h3 class="text-center">로그인</h3>
	<form action="${ctx}/userLoginOk.do" method="post">
		<div class="mt-3 mb-3">
			<lable for="id">아이디</lable>
			<input type="text" class="form-control" id="id" placeholder="아이디" name="id"/>
		</div>
		<div class="mb-3">
			<lable for="pw">비밀번호</lable>
			<input type="password" class="form-control" id="pw" placeholder="비밀번호" name="pw"/>
		</div>
		<div class="text-center">
			<input type="submit" class="btn btn-sm btn-primary" value="로그인"/>
			<input type="button" class="btn btn-sm btn-info" 
				value="회원가입" onclick="javascript:window.location='userJoin.do'"/>
		</div>
	</form>
</div>
<%@ include file="user_bottom.jsp" %>
