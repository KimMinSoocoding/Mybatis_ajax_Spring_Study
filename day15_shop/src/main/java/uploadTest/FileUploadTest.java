package uploadTest;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/upload.do")
public class FileUploadTest extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		System.out.println("업로드 테스트");
		
		String savePath = "/Users/minsoo/Desktop/file";
		
		ServletContext application = request.getServletContext();
		String realPath =application.getRealPath(savePath);
		
		System.out.println(realPath);
		
		int maxSize = 1024*1024*10; //1K*1K = 1MB *10 = 10MB
		
		// 업로드 파일을 관리해주는 객체
		// 										클라이언트정보객체, 저장위치, 파일최대크기, 인코딩,      파일중복처리 객체
		MultipartRequest mr = new MultipartRequest(request, savePath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		// request.getParmeter 대신 mr을 이용한다
		String title = mr.getParameter("title");
		File file = mr.getFile("image");
		String fileName = "";
		
		if(file != null) {
			//첨부된 파일명 얻어오기 
			fileName = file.getName();
		}
		
		request.setAttribute("title", title);
		request.setAttribute("fileName", fileName);
		
		RequestDispatcher rd = request.getRequestDispatcher("fileUploadTest/result.jsp");
		rd.forward(request, response);
	}

}
