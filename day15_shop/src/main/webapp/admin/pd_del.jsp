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
	
	String pImage = request.getParameter("pImage");
	String realPath = application.getRealPath("uploadedFile");
	
	File delFile = null; 
	
	// 서버에 있는 이미지 파일 삭제 // 
	if(pImage != null){
		// 삭제할 파일 경로 지정한 파일객체 생
		delFile = new File(realPath + "/" +pImage);
		System.out.println("삭제할 파일명 경로 : " + delFile);
		if(delFile.exists()){
			// delFile.delete() 실행해서 삭제되면 삭제되면 true 반환, 아니면 false
			if(delFile.delete()) out.println("이미지 파일 삭제 완료!!");
		}
	}
	
	
	// 데이터베이스 상품삭제
	ProductDAO dao = ProductDAO.getInstance();
	int n = dao.delProduct(pNum.trim());
	
	String msg = "", url = "pd_list.jsp";
	
	if(n > 0){
		msg = "상품 삭제 처리완료!!";
	}else {
		msg = "상품 삭제 실패!!";
	}
	
%>
<script>
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>

