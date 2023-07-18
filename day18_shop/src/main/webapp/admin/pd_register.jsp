<%@page import="ez.web.model.ProductDAO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String realPath = request.getRealPath("/uploadedFile");
	
	int maxSize = 1024 * 1024 * 10;// 10MB
	
	String msg="", url="";
	
	try {
		MultipartRequest mr = new MultipartRequest(request, realPath, maxSize,
				"utf-8", new DefaultFileRenamePolicy());
		ProductDAO dao = ProductDAO.getInstance();
		int n = dao.registerProduct(mr);
		
		if(n>0){
			msg = "상품등록 완료!!";
			url ="";
		}else{
			msg = "상품등록 실패!!";
			url ="";
		}
	}catch (Exception e){
		msg = "파일 업로드 실패!!";
		url = "pd_input.jsp";
		e.printStackTrace();
	}
%>
<script>
	alert("<%=msg%>");
</script>

