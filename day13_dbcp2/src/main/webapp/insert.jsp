<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="dto" class="ez.web.model.StudentDTO"/>
<!-- StudentDAO 생성 -->
<jsp:useBean id="dao" class="ez.web.model.StudentDAO"/>

<jsp:setProperty property="*" name="dto"/>
    
<%
 	/* String stuNo = request.getParameter("stuNo");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	
	//backend에서 유효성 체크하기
	if(stuNo == null || pw == null || name == null || tel == null || stuNo.trim().equals("")||
		pw.trim().equals("")||name.trim().equals("") || tel.trim().equals("")){
		response.sendRedirect("student.jsp");
		
		// return이 없으면 아래의 코드가 모두 실행된다.
		// return이 있어야 아래의 코드를 실행하지 않고 안전하게 페이지 이동을 한다.
		return;
	}  */
	
	// System.out.println("테스트");

	//int n = dao.insertStudent(stuNo, pw, name, tel);
	int n = dao.insertStudent(dto);
	
	String msg ="", url="";
	
	if(n>0){
		msg = "학생 등록 완료!!";
		url = "list.jsp";
	}else{
		msg = "학생 등록 실패!!";
		url = "student.jsp";
	}
%>    
<script>
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>