<%@page import="web.model.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="web.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	ArrayList<MemberDTO> memberList = (ArrayList<MemberDTO>)request.getAttribute("list");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css' rel='stylesheet'>
<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js'></script>
</head>
<body>
<body>                           
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

<% for(MemberDTO dto : memberList) { %>
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
<% } %>

		<tr>                     
<!-- 			<td colspan='8' class='text-center'><a href='member/register.html' class='btn btn-primary'>회원가입</a></td> -->
			<td colspan='8' class='text-center'><a href='memberRegister.do' class='btn btn-primary'>회원가입</a></td>
		</tr>     
	</tbody>          
		                  
	</table>              
</div> 
<script type="text/javascript">
	function delMember(no){
		location.href="/day07/memberDel.do?no="+no;
	}
</script>
                   
</body>
</html>