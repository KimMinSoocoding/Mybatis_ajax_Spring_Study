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
public class IdPwController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String find = request.getParameter("find");
		request.setAttribute("find", find);
	
		return "idpw";
	}
}
