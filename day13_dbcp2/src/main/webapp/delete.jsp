<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="dao" class="ez.web.model.StudentDAO"/>
   
<%
	String delNum = request.getParameter("delNum");

	//유효성 체크
	if(delNum == null || delNum.trim().equals("")){
		response.sendRedirect("student.jsp");
		return;
	}
	
	int n = dao.delStudent(delNum);
	
	String str = "삭제";
	String url = "student.jsp";
	
	if(n>0){
		str +=" 처리 되었습니다!";
		url = "list.jsp";
	}else{
		str += " 하고자 하는 학생이 존재하지 않습니다!!!";
	}
%>    
<script>
	alert("<%=str%>");
	location.href="<%=url%>";
</script>