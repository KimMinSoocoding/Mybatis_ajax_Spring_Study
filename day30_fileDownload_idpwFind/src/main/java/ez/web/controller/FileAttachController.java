package ez.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;

import web.model.MemberDAO;
import web.model.MemberDTO;

// FileAttachController는 첨부된 파일을 서버에 저장하고 DB에 저장할 파일명을 ajax 콜백함수에 리턴해 줌
public class FileAttachController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String UPLOAD_DIR = "uploaded_file";
		
		// 실제 물리적인 경로 얻어오기                                        경로구분자결정://\\, /(리눅스)
		String uploadPath = request.getServletContext().getRealPath("")+File.separator+UPLOAD_DIR;
		
		System.out.println("uploadPath : " + uploadPath);
		
		// 업로드할 경로의 File 객체 생성
		File currentDirPath = new File(uploadPath);
		
		if(!currentDirPath.exists()) { // 디렉토리가 없는 경우
			currentDirPath.mkdir(); // 디렉토리 생성
		}
		
		// maven repository 사이트에서 jar파일 다운로드
		// file Upload시 사용할 API : commons-fileupload, common-io (기존에 사용한 API : cos)
		
		// 업로드된 파일을 저장할 저장소를 다루는 클래스
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// 실제 파일이 저장될 경로 설정
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(5*1024*1024); // 업로드 파일의 최대 크기 5MB
		
		// 데이터베이스에서 사용할 파일이름
		String fileName = null;
		
		// request에서 데이터를 좀더 쉽게 찾아내기 위한 클래스
		// multi-part/form-data를 쉽게 다룰 수 있게 해주는 객체
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
		
		try {
			// FileItem : multi-part/form-data로 전송된 파라미터(텍스트) 또는 파일 정보를 저장하고 있는 클래스	
			// items안에 파일이 여러 개인 경우 : FileItem[], FilefItem[], FileItem[],.....
			List<FileItem> items = servletFileUpload.parseRequest(request);		
			// 파일이 여러 개인 경우에는 루프를 통해서 각각의 파일정보를 얻어올 수 있음
			for(int i=0; i <items.size(); i++) {
				FileItem fileItem = items.get(i);
				
				// isFormField() : 파라미터(텍스트)이면 true, 파일이면 false
				
				//if(fileItem.isFormField()) { // 텍스트인 경우
				//	System.out.println(fileItem.getFieldName()+"="+fileItem.getString("utf-8"));
				//}else { // 텍스트가 아닌 경우
				
				if(fileItem.getSize() > 0) { // 정상적으로 디렉토리에 파일이 업로드 된 경우
					// fileItem.getName() : c:\\A\\B\\test.png
					int idx = fileItem.getName().lastIndexOf("\\");
					
					if(idx == -1) { // 리눅스 일경우
						idx = fileItem.getName().lastIndexOf("/");
					}
					
					// 파일명만 가져오기
					fileName = fileItem.getName().substring(idx+1);
					System.out.println("fileName : " + fileName);
					
					File uploadFile = new File(currentDirPath+"\\"+fileName);
					
					// 파일 중복체크
					if(uploadFile.exists()) {
						fileName = System.currentTimeMillis()+"_"+fileName;
						uploadFile = new File(currentDirPath+"\\"+fileName);
					}
					
					// 해당 서버 실제 경로에 파일 쓰기(저장) 
					fileItem.write(uploadFile);
				}
			} // for문
			//}
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		// 한글 파일명이 깨지지 않도록
		response.setContentType("text/html;charset=utf-8");
		
		// 서버에 저장된 실제 파일명을 전송
		response.getWriter().print(fileName);
		
		
		
		// 비동기 처리를 위해서 페이지명이 없도록 null 처리
		return null;
	}
}
