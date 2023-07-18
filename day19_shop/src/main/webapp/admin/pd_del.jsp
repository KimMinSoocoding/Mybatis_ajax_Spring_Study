<%@page import="ez.web.model.ProductDAO"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pNum = request.getParameter("pNum");

	if(pNum == null || pNum.trim().equals("")){
		response.sendRedirect("pd_list.jsp");
		return;
	}
	
	///////////// 서버에 있는 이미지 파일 삭제 /////////////////////
	String pImage =request.getParameter("pImage");
	String realPath = application.getRealPath("uploadedFile");
	
	File delFile = null;
	
	if(pImage != null){
		// 삭제할 파일 경로를 지정한 파일 객체 생성
		delFile = new File(realPath + "/"+pImage);
		System.out.println("삭제할 파일명 경로 : "+ delFile);
		if(delFile.exists()){
			// delFile.delete() 실행해서 삭제되면 true 반환, 아니면 false
			if(delFile.delete()) out.println("이미지 파일 삭제 완료!!");
		}
	}
	//////////////////////////////////////////////////////////
	
	// DataBase 상품 삭제
	ProductDAO dao = ProductDAO.getInstance();
	int n = dao.delProduct(pNum.trim());
	
	String msg = "", url="pd_list.jsp";
	
	if(n > 0){
		msg = "상품 삭제처리 완료!!";
	}else{
		msg = "상품 삭제 실패!!";
	}
%>
<script>
	alert("<%=msg%>");
	location.href ="<%=url%>";
</script>




