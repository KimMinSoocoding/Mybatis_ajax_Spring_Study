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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-light">
 <a class="navbar-brand m-3 text-success" href="adminMain.do">FlowerShop</a>
  <div class="container-fluid">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="adminCatInput.do">Flower 상품코드 등록</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="catAllList.do">Flower Code List</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="prodInput.do">꽃/식물/화분 등록</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="prodList.do">상품 리스트</a>
      </li>
       <li class="nav-item dropdown ms-auto">
          <a class="nav-link dropdown-toggle" href="#" role="button" 
          	data-bs-toggle="dropdown">프로필</a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">마이페이지</a></li>
            <c:if test="${sessionScope.isLogin != null}">
            	<li><a class="dropdown-item" href="adminLogout.do">로그아웃</a></li>
            </c:if>
          </ul>
        </li>
    </ul>
  </div>
</nav>


</body>
</html>