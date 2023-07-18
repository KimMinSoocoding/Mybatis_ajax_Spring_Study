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
public class FindIdPwController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		String find = request.getParameter("find");
		request.setAttribute("find", find);
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		
		dto.setName(id);
		dto.setName(name);
		dto.setEmail(email);
	
		
		if(find.equals("id")) { // 아이디 찾기인 경우
			String findId = dao.findId(dto);
			if(findId == null) {
				request.setAttribute("idMsg", "아이디를 찾을 수 없습니다");
			}else {
				request.setAttribute("findId", findId);
			}
		}else { // 비밀번호 찾기인 경우 
			String findPw = dao.findPw(dto);
			if(findPw == null) {
				request.setAttribute("pwMsg", "비밀번호를 찾을 수 없습니다");
			}else {
				request.setAttribute("findPw",findPw);
			}
		}
		return "idpw";
	}
}
