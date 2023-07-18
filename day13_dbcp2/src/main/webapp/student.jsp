<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>                                         
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
   <div class="container mt-5 w-50 border shadow-sm p-4">
      <h4>학생 등록</h4>
      <form action="insert.jsp" class="mt-3">
         <input type="text" class="form-control" placeholder="학번을 입력하세요" name="stuNo"/>
         <input type="text" class="form-control mt-3" placeholder="비밀번호를 입력하세요" name="pw"/>
         <input type="text" class="form-control mt-3" placeholder="이름을 입력하세요" name="name"/>
         <input type="text" class="form-control mt-3" placeholder="전화번호를 입력하세요" name="tel"/>
         
         <div class="text-center">
            <input type="submit" value="등록" class="btn btn-sm btn-primary mt-3"/>
            <input type="reset" value="취소" class="btn btn-sm btn-secondary mt-3"/>
            <a href="list.jsp" class="btn btn-sm btn-info mt-3">리스트</a>
         </div>
      </form>
   </div>
   <div class="container mt-5 w-50 border shadow-sm p-4">
      <h4>학생 검색</h4>
      <form action="find.jsp" class="mt-3">
         <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="이름 검색" name="sName"/>
            <button class="btn btn-sm btn-primary" type="submit">검색</button>
         </div>
      </form>
   </div>
   
   <div class="container mt-5 w-50 border shadow-sm p-4 mb-5">
      <h4>학생 삭제</h4>
      <form action="delete.jsp" class="mt-3">
         <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="학번을 입력하세요" name="delNum"/>
            <button class="btn btn-sm btn-primary" type="submit">삭제</button>
         </div>
      </form>
   </div>
</body>
</html>