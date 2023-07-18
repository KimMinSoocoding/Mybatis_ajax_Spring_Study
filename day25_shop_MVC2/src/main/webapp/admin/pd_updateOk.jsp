<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="javax.swing.plaf.multi.MultiMenuItemUI"%>
<%@page import="ez.web.model.ProductDAO"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	MultipartRequest mr = null;
	
	// uploadedFile의 물리적인 경로(서버상의 전체경로)를 얻어올 수 있다.
	// String realPath = request.getRealPath("uploadedFile");
	String realPath = application.getRealPath("uploadedFile");
	
	ProductDAO pDao = ProductDAO.getInstance();
	
	String msg = "", url="";
	
	try{
		mr = new MultipartRequest(request, realPath, 1024*1024*10, 
				"utf-8", new DefaultFileRenamePolicy());
		
		// 수정된 내용 DB에 반영
		int n = pDao.updateProduct(mr);
		
		if(n > 0){
			msg = "상품 정보가 수정되었습니다!!!";
			url = "pd_list.jsp";
		}else{
			msg = "상품 정보가 수정실패!!!";
			url = "pd_list.jsp";
		}
	}catch(Exception e){
		msg = "파일 업로드 실패!!";
		url = "pd_list.jsp";
	}
%>
<script>
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
