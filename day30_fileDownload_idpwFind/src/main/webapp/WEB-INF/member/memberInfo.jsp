<%@page import="web.model.MemberDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp" %>
 
<script>
	function update(){
		if($("#myFile").val() !=''){ // 사진이 첨부된 경우
			alert("!!!!");
				
				// 브라우저에서 지원하는 FormData클래스
				var formData = new FormData();
				// 첫번째 input타입 객체의 첫번째 파일
				formData.append("myFile", $("input[name=myFile]")[0].files[0]);
				
				$.ajax({
					url:"<c:url value='/fileAttach.do'/>",
					type:"post",
					data:formData,
					// true:queryString형식으로 변환, 
					// file은 queryString으로 변환해서 보낼 수 없음, true면 에러
					processData: false, 
					contentType: false, // multipart/form-data(file) 형식으로 보낼 때는 false
									
					success: function(data){
						// alert(data);
						// DB에 파일명을 저장하기 위한 코드
						// 서버에서 넘어온 data(실제 파일명)를 input의 value에 추가하여 넘겨줌
						$("#fileName").val(data);
						// 사진이 첨부되서 요청하는 경우
						document.infoForm.action = "<c:url value='/memberUpdate.do'/>?mode=fupdate";
						document.infoForm.submit();
						
					},
					error: function(){alert("error 발생!!")}
				});
			
			}else{ // 사진이 첨부되지 않았을 경우
				document.infoForm.action = "<c:url value='/memberUpdate.do'/>?mode=update";
				document.infoForm.submit();
			}
	}

	function downloadFile(fileName){
		location.href="<c:url value='/downloadFile.do'/>?fileName="+fileName;
	}

	function delFile(no, fileName){
		location.href="<c:url value='/delFile.do'/>?no="+no+"&fileName="+fileName;
	}

</script>
  
<div class='container mt-5'>
	<%-- <form action='${ctx}/memberUpdate.do' method='post'>         	 --%>
	<form method='post' name ="infoForm">         	
		<input type='hidden' name='filename' id="filename" value='${dto.no}'>
		
		
		<div class="w-50 border rounded p-5 shadow mx-auto">
		<h4 class = "text-center mb-4">회원 정보</h4>
			<c:choose>
				<c:when test="${dto.fileName == null || dto.fileName == ''}"> <!-- 사진첨부가 안된 경우 -->
					<div class="text-center mb-4">			
						<img class="rounded-circle mb-3" src="${ctx}/img/sample.png" width="100px" style="opacity:0.5"/>
						<br><span><small><i class="fa fa-info-circle"></i> 사진이 등록되지 않았습니다.</small></span>
					</div>
				</c:when>
				<c:otherwise> <!-- 사진이 첨부된 경우 -->
					<div class="text-center mb-4">			
						<img class="rounded-circle mb-3" src="${ctx}/uploaded_file/${dto.fileName}" width="100px"/>						
					</div>
					<div class="text-center mb-4"> <!-- 로그인한 회원은 누구나 사진을 다운로드 가능 -->
						<a class="btn btn-sm btn-outline-secondary" onclick="javascript:downloadFile('${dto.fileName}')">다운로드 <i class="fa fa-arrow-down"></i></a>
						<c:if test="${sessionScope.userId == dto.id}"><!-- 자신인 경우에만 삭제 가능하도록 -->
							<a class="btn btn-sm btn-outline-secondary" 
								onclick="javascript:delFile('${dto.no}','${dto.fileName}')">사진삭제 <i class="far fa-trash-alt"></i></a>
						</c:if>
					</div>
				</c:otherwise>
			</c:choose>
			
			
			<div class="d-flex">
				<div class="form-group col-md-3">
					<lable for="no">번호</lable>
					<input class="form-control" type="text" value="${dto.no}" id="no" disabled/>
				</div>
				<div class="form-group col-md-6 px-2">
					<lable for="name">이름</lable>
					<input class="form-control" type="text" value="${dto.name}" id="name" disabled/>
				</div>
				<div class="form-group col-md-3">
					<lable for="age">나이</lable>
					<input class="form-control" type="text" value="${dto.age}" id="age" name="age"/>
				</div>
			</div>
			<div class="d-flex mt-2">
				<div class="form-group col-md-6">
					<lable for="id">아이디</lable>
					<!-- 자신의 아이디만 출력 -->
					<c:if test="${sessionScope.userId == dto.id}">
						<input class="form-control" type="text" value="${dto.id}" id="id" disabled/>
					</c:if>
					<c:if test="${sessionScope.userId != dto.id}">
						<input class="form-control" type="text" value="*****" id="id" disabled/>
					</c:if>
				</div>
				<div class="form-group col-md-6 ps-2">
					<lable for="pw">비밀번호</lable>
					<c:if test="${sessionScope.userId == dto.id}">
						<input class="form-control" type="text" value="${dto.pw}" id="pw" disabled/>
					</c:if>
					<c:if test="${sessionScope.userId != dto.id}">
						<input class="form-control" type="text" value="*****" id="pw" disabled/>
					</c:if>
				</div>
			</div>
			
			<div class="d-flex mt-2">
				<div class="form-group col-md-6">
					<lable for="email">이메일</lable>
					<input class="form-control" type="text" value="${dto.email}" id="email" name="email"/>
				</div>
				<div class="form-group col-md-6 ps-2">
					<lable for="phone">전화번호</lable>
					<input class="form-control" type="text" value="${dto.phone}" id="phone" name="phone"/>
				</div>
			</div>
			
			<!-- 사진첨부 -->
			<div class="form-group mt-2">
					<lable for="myFile">사진첨부</lable>
					<input class="form-control" type="file" id="myFile" name="myFile"/>
			</div>
			<div class="text-center mt-3">
				<c:if test="${sessionScope.userId !=null}">
				    <c:if test="${sessionScope.userId == dto.id}">                  
						<input type='submit' value='수정하기' class='btn btn-primary' onclick="update()">
					</c:if>
				    <c:if test="${sessionScope.userId != dto.id}">                  
						<input type='submit' value='수정하기' 
						class='btn btn-primary' disabled>
					</c:if>
				</c:if>         
				<input type='reset' value='취소' class='btn btn-warning'>              
				<a href='memberList.do' class='btn btn-info'>리스트</a></td>
			</div>
		</div>
		
		
		 
		
					<!--
					    1) 로그인을 안하면 수정하기가 안보임
						2) 로그인을 하고 자신의 정보이면 수정하기 버튼이 활성화
						   그렇지 않으면 비활성화
					 -->
					
		</form>   
</div>
<%@ include file="../../inc/footer.jsp" %>   


