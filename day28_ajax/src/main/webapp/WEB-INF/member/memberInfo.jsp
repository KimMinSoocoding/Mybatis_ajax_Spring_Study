<%@page import="web.model.MemberDTO"%>
<%@page import="web.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp" %>   
<div class='container mt-5'>
	<form action='${ctx}/memberUpdate.do' method='post'>         	
		<input type='hidden' name='no' value='${dto.no}'> 
		<table>                                             
			<tbody>                                         
				<tr>                                        
					<td colspan='2'><b>${dto.name}님 회원 정보</b></td>
				</tr>                                     
				<tr>                                      
					<td>번호</td>                         
					<td>${dto.no}</td>                    
				</tr>                                     
				<tr>                                      
					<td>아이디</td>                       
					<td>${dto.id}</td>                    
				</tr>                                     
				<tr>                                      
					<td>비밀번호</td>                     
					<td>${dto.pw}</td>                    
				</tr>                                     
				<tr>                                      
					<td>이름</td>                         
					<td>${dto.name}</td>                  
				</tr>                                     
				<tr>                                      
					<td>나이</td>                         
					<td><input type='text' name='age' value='${dto.age}'></td>       
				</tr>                                    
				<tr>                                     
					<td>이메일</td>                      
					<td><input type='text' name='email' value='${dto.email}'></td>   
				</tr>                                   
				<tr>                                    
					<td>전화번호</td>                   
					<td><input type='text' name='phone' value='${dto.phone}'></td>   
				</tr>                                     
		
				<tr>                                      
					<td colspan='2'>                      
					<input type='submit' value='수정하기' class='btn btn-primary'>         
					<input type='reset' value='취소' class='btn btn-warning'>              
					<a href='memberList.do' class='btn btn-info'>리스트</a></td>    
				</tr>                                 
			</tbody>                                      
		</table>                                          
		</form>   
</div>
<%@ include file="../../inc/footer.jsp" %>   


