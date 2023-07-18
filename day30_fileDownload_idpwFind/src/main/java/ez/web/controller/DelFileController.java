package ez.web.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
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
public class DelFileController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ctx = request.getContextPath();
		int no = Integer.parseInt(request.getParameter("no"));
		String fileName = request.getParameter("fileName");
		
		// URL에서 queryString에 한글이 들어간 경우는 인코딩을 해줘야 한글을 제대로 인식할 수 있다.
		// 인코딩을 할 때 사용하는 클래스가 URLEncoder이다.
		// URL queryString은 알파벳, 숫자인 경우 제대로 인식, 한글인 경우 특수문자로 변환되어 처리
		// 공백은 '+'로 변환되어 처리
		
		// 특수문자로 처리된 fileName을 한글로 인식되도록 인코딩을 해줌
		fileName = URLEncoder.encode(fileName, "utf-8");
		fileName = fileName.replace("+", " ");
		
		String UPLOAD_DIR = "uploaded_file";
		
		// 실제 물리적인 경로 얻어오기                                        경로구분자결정://\\, /(리눅스)
		String uploadPath = request.getServletContext().getRealPath("")+File.separator+UPLOAD_DIR;
		
		// 삭제할 File 객체 생성
		File delFile = new File(uploadPath +"\\"+fileName);
		
		// 서버에 있는 파일 삭제
		if(delFile.exists()) {
			delFile.delete();
			System.out.println("파일 삭제 성공!!");
		}
		
		// DB에서 파일명을 삭제
		MemberDAO dao = new MemberDAO();
		dao.memberDelFile(no);
		
		return "redirect:"+ctx+"/memberInfo.do?no="+no;
	}
}
