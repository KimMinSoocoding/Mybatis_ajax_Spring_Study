<%@page import="web.model.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="web.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
    
<%-- <%
	ArrayList<MemberDTO> memberList = (ArrayList<MemberDTO>)request.getAttribute("list");
%>   --%>  
<%@ include file="../../inc/header.jsp" %> 
<%-- <c:if test="${sessionScope.msg !=null}">
<script>
	alert("${sessionScope.msg}");
	<c:remove var="msg" scope="session"/>
</script>                          
</c:if> --%>

<script>
	function showList(){
		$.ajax({
			url:"<c:url value='/memberAjaxList.do'/>",
			type: "get";
			dataType: "json", // 서버에서 받는 데이터 타입을 의미
			succes : listPrint, // 회원리스트를 받아서 처리하는 콜백함수 
			error: function(){alert("에러")}
		})
	}
	
	// 콜백함수 
	function listPrint(data){
	  	vat html = "<table class='table'>"		 
	html+= "<thead class='thead-light'>                  ";
	  	html+= "		<tr>          ";       
	  	html+= "		<th>번호</th>   "; 
	  	html+= "		<th>아이디</th>  ";
	  	html+= "		<th>비밀번호</th>";
	  	html+= "		<th>이름</th>    ";
	  	html+= "		<th>나이</th>    ";
	  	html+= "		<th>이메일</th>  ";
	  	html+= "		<th>전화번호</th>";
	  	html+= "		<th>삭제</th>    ";
	  	html+= "	</tr>                ";
	  	html+= " </thead>               ";  
	  	html+= "  <tbody>           	";
	  	
	  	// json 데이터 [{},{},{},......]
	  	// 반복문 처리 
	  	$.each(data, function(index,obj){
	  		
	  		html+="<tr>             ";
	  		html+="<td>"+obj.no+"</td>        ";
	  		html+="<td>"+obj.id+"</td>        ";
	  		html+="<td>"+obj.pw+"</td>        ";
	  		html+="<td>"+obj.name+"</td>        ";
	  		html+="<td>"+obj.age+"</td>        ";
	  		html+="<td>"+obj.email+"</td>        ";
	  		html+="<td>"+obj.phone+"</td>        ";
	  		html+="<td><input type'"button' value='삭제' class='btn btn-danger btn-sm'/> </td>    ";
	  		html+="</tr>            ";
	  		
	  	});
	  	html+="</tbody>";
	  	html+="</table>";
	  	$("memberList").html(html);
	}
</script>


<div class='container mt-5'>
	<h3>회원리스트</h3>          
	<table class='table'>		 
		<thead>                  
			<tr>                 
				<th>번호</th>    
				<th>아이디</th>  
				<th>비밀번호</th>
				<th>이름</th>    
				<th>나이</th>    
				<th>이메일</th>  
				<th>전화번호</th>
				<th>삭제</th>    
			</tr>                
		</thead>                 
		<tbody>                  

<%-- <% for(MemberDTO dto : memberList) { %>
	<tr>                     
		<td><%=dto.getNo()%></td>
		<td><a href='/day07/memberInfo.do?no=<%=dto.getNo()%>'><%=dto.getId()%></a></td>            
		<td><%=dto.getPw()%></td>            
		<td><%=dto.getName()%></td>          
		<td><%=dto.getAge()%></td>           
		<td><%=dto.getEmail()%></td>         
		<td><%=dto.getPhone()%></td>         
		<td><input type="button" value="삭제" class="btn btn-danger btn-sm" onclick="delMember(<%=dto.getNo()%>)"/></td>            
	</tr>                    
<% } %> --%>
<c:forEach var="dto" items="${list}">
	<tr>                     
		<td>${dto.no}</td>
		<td><a href='memberInfo.do?no=${dto.no}'>${dto.id}</a></td>            
		<td>${dto.pw}</td>            
		<td>${dto.name}</td>          
		<td>${dto.age}</td>           
		<td>${dto.email}</td>         
		<td>${dto.phone}</td>         
		<td><input type="button" value="삭제" class="btn btn-danger btn-sm" 
		onclick="delMember(${dto.no})"/></td>            
	</tr>                    
</c:forEach>


		<tr>                     
<!-- 			<td colspan='8' class='text-center'><a href='member/register.html' class='btn btn-primary'>회원가입</a></td> -->
			<td colspan='8' class='text-center'><a href='memberRegister.do' class='btn btn-primary'>회원가입</a></td>
		</tr>     
	</tbody>          
		                  
	</table>              
</div> 

	<div class="container mt-3">
	<button type="button" class="btn btn-primary" data-bs-toggle="collapse" 
	data-bs-target="memberList" onclick="showList()">AjAx 회원리스트</button>

  <div id="memberList" class="collapse">
    
  </div>
 </div>
  
<script type="text/javascript">
	function delMember(no){
		location.href="memberDel.do?no="+no;
	}
</script>
                   
<%@ include file="../../inc/footer.jsp" %>  