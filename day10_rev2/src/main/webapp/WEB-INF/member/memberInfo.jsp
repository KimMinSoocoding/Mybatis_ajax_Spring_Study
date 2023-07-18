<%@page import="ez.web.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	MemberDTO dto = (MemberDTO)request.getAttribute("dto");

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
<div class='container mt-5'>
	<form action='/day06_2/memberUpdate.do' method='post'>         	
		<input type='hidden' name='no' value='<%=dto.getNo()%>'> 
		<table>                                             
			<tbody>                                         
				<tr>                                        
					<td colspan='2'><b><%=dto.getName()%>님 회원 정보</b></td>
				</tr>                                     
				<tr>                                      
					<td>번호</td>                         
					<td><%=dto.getNo()%></td>                    
				</tr>                                     
				<tr>                                      
					<td>아이디</td>                       
					<td><%=dto.getId()%></td>                    
				</tr>                                     
				<tr>                                      
					<td>비밀번호</td>                     
					<td><%=dto.getPw()%></td>                    
				</tr>                                     
				<tr>                                      
					<td>이름</td>                         
					<td><%=dto.getName()%></td>                  
				</tr>                                     
				<tr>                                      
					<td>나이</td>                         
					<td><input type='text' name='age' value='<%=dto.getAge()%>'></td>       
				</tr>                                    
				<tr>                                     
					<td>이메일</td>                      
					<td><input type='text' name='email' value='<%=dto.getEmail()%>'></td>   
				</tr>                                   
				<tr>                                    
					<td>전화번호</td>                   
					<td><input type='text' name='phone' value='<%=dto.getPhone()%>'></td>   
				</tr>                                     
		
				<tr>                                      
					<td colspan='2'>                      
					<input type='submit' value='수정하기' class='btn btn-primary'>         
					<input type='reset' value='취소' class='btn btn-warning'>              
					<a href='/day06_2/memberList.do' class='btn btn-info'>리스트</a></td>    
				</tr>                                 
			</tbody>                                      
		</table>                                          
		</form>                                           


</div>
</body>
</html>