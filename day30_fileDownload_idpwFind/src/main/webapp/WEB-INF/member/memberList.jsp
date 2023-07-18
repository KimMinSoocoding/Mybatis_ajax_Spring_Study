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
<script>
	function showList(){
		$.ajax({
			url:"<c:url value='/memberAjaxList.do'/>",
			type: "get",
			dataType:"json", // 서버에서 받는 데이터 타입을 의미
			success: listPrint, // 회원리스트를 받아서 처리하는 콜백함수
			error: function(){alert("에러")}
		});
	}
	
	// 콜백함수
	function listPrint(data){
		var html ="<table class='table'>"		 
		html+="<thead class='thead-light'>                  ";                  
		html+="	<tr>                    ";
		html+="		<th>번호</th>       ";
		html+="		<th>아이디</th>     ";
		html+="		<th>비밀번호</th>   ";
		html+="		<th>이름</th>       ";
		html+="		<th>나이</th>       ";
		html+="		<th>이메일</th>     ";
		html+="		<th>전화번호</th>   ";
		html+="		<th>삭제</th>       ";
		html+="	</tr>                   ";
		html+="</thead>                 ";
		html+="<tbody>                  ";
		
		// json 데이터 [{ },{ },{ },....]
		// 반복문 처리
		$.each(data, function(index, obj){
			html+="<tr>         ";
			html+="<td>"+obj.no+"</td>    ";
			html+="<td>"+obj.id+"</td>    ";
			html+="<td>"+obj.pw+"</td>    ";
			html+="<td>"+obj.name+"</td>    ";
			html+="<td>"+obj.age+"</td>    ";
			html+="<td>"+obj.email+"</td>    ";
			html+="<td>"+obj.phone+"</td>    ";
			html+="<td><input type='button' value='삭제' class='btn btn-danger btn-sm' onclick='ajaxDelete("+obj.no+")'/></td>    ";
			html+="</tr>        ";
		});
		html+="</tbody>";
		html+="</table>";
		
		$("#memberList").html(html);
		
	}
	
	function ajaxDelete(no){
		$.ajax({
			url:"<c:url value='/memberAjaxDelete.do'/>",
			type:"get",
			data:{"no":no},
			success:showList,
			error:function(){alert("error!!")}
		});
	}
</script>


<div class='container mt-5'>
	<h3>회원리스트</h3>          
	<table class='table'>		 
		<thead>                  
			<tr>                 
				<th>번호</th>
				<th>사진</th>
				<!-- 로그인이 안된 경우 아이디와 비밀번호를 보이지 않게 -->
				<c:if test="${sessionScope.userId != null}">       
				<th>아이디</th>  
				<th>비밀번호</th>
				</c:if>
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
		
		<td>
			<!-- 로그인이 된 경우 -->
			<c:if test="${sessionScope.userId != null}">
				<!-- 사진 첨부가 된 경우 -->
				<c:if test="${dto.fileName !=null && dto.fileName !=''}">
					<img class="rounded-circle" src="<c:out value='uploaded_file/${dto.fileName}'/>" width="48px" height="48px"/>
				</c:if>
				<!-- 사진 첨부가 안된 경우 -->
				<c:if test="${dto.fileName ==null || dto.fileName ==''}">
					<img class="rounded-circle" src="<c:out value='img/sample.png'/>" width="48px" height="48px"/>
				</c:if>
			</c:if>
			
			<!-- 로그인을 안한 경우 -->
			<c:if test="${sessionScope.userId == null}">
				<img class="rounded-circle" src="<c:out value='img/sample.png'/>" width="48px" height="48px"/>
			</c:if>
		</td>
		
		<!-- 로그인이 안된 경우 아이디와 비밀번호를 보이지 않게 -->
		<c:if test="${sessionScope.userId != null}">
		 	<c:if test="${sessionScope.userId==dto.id}">
				<td><a href='memberInfo.do?no=${dto.no}'>${dto.id}</a></td>            
				<td>${dto.pw}</td> 
			</c:if>           
		 	<c:if test="${sessionScope.userId != dto.id}">
				<td><a href='memberInfo.do?no=${dto.no}'>
					<c:forEach begin="1" end="${fn:length(dto.id)}">**</c:forEach>
				</a></td>            
				<td>
					<c:forEach begin="1" end="${fn:length(dto.pw)}">**</c:forEach>
				</td> 
			</c:if>           
		</c:if>
		
		
		<td>${dto.name}</td>          
		<td>${dto.age}</td>           
		<td>${dto.email}</td>         
		<td>${dto.phone}</td> 
		<c:if test="${sessionScope.userId==dto.id}">        
			<td><input type="button" value="삭제" class="btn btn-danger btn-sm" 
		onclick="delMember(${dto.no})"/></td>       
		</c:if>     
		<c:if test="${sessionScope.userId != dto.id}">        
			<td><input type="button" value="삭제" class="btn btn-danger btn-sm" 
		onclick="delMember(${dto.no})" disabled/></td>       
		</c:if>     
	</tr>                    
</c:forEach>


		<tr>                     
		<!-- 로그인을 안한 경우만 회원가입버튼을 보여줌 -->	
		<c:if test="${sessionScope.userId == null}">
			<td colspan='9' class='text-center'><a href='memberRegister.do' class='btn btn-primary'>회원가입</a></td>
		</c:if>
		</tr>     
	</tbody>          
		                  
	</table>              
</div> 

<div class="container mt-3">
 <button type="button" class="btn btn-primary" 
 	data-bs-toggle="collapse" data-bs-target="#memberList" 
 	onclick="showList()">AJAX 회원리스트</button>
  
  <div id="memberList" class="collapse">
    
  </div>
</div>
  
<script type="text/javascript">
	function delMember(no){
		location.href="memberDel.do?no="+no;
	}
</script>
                   
<%@ include file="../../inc/footer.jsp" %>  