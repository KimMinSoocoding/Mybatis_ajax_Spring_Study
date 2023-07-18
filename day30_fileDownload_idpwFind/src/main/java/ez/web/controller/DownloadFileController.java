package ez.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class DownloadFileController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
		
		// 다운로드할 File 객체 생성
		File downloadFile = new File(uploadPath +"\\"+fileName);
		
		// 파일 다운로드시 기본 셋팅
		response.setContentLength((int)downloadFile.length()); // 파일의 크기를 브라우저에 알려줌
		response.setContentType("application/x-msdownload;charset=utf-8"); 
		  					    //application/octet-stream
		// Content-Disposition : 컨텐츠의 성격, 기본적으로 inline인데 attachment;fileName은 다운로드 받으라는 의미
		response.setHeader("Content-Disposition", "attachment;fileName="+fileName+";");   
		response.setHeader("Content-Transfer-Encoding", "binary");  // 이미지
		response.setHeader("Pragma", "no-cache"); // 캐싱 처리되지 않도록 설정(pc방이나 공공장소의 PC에 정보가 남지 않도록 설정)
		response.setHeader("Expires", "0"); // HTTP 버전에 따라 설정할 수 도 안할수 도 있음.
		
		// 파일을 읽어온 후에 출력스트림을 이용해서 내보냄
		FileInputStream fis = new FileInputStream(downloadFile);
		OutputStream out = response.getOutputStream();
		
		byte[] buffer = new byte[1024];
		
		while(true) {
			int cnt = fis.read(buffer); // 읽어들인 바이트 수
			if(cnt == -1){ // 파일의 끝까지 읽어왔을 경우
				break;
			}
			
			// 읽어들인 바이트 수만큼 클라이언트에게 계속 출력(다운로드 진행 : 0%... 20%...)
			out.write(buffer, 0, cnt); 
		}
		
		fis.close();
		out.close();
		
		return null;
	}
}
