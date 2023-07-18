package flowerCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flower.model.CategoryDAO;

public class CatRegOkCommand implements FlowerCommand {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		// 파라미터 수집 ( 카테고리 코드, 카테고리 이름
		String code = request.getParameter("code");
		String cname = request.getParameter("cname");
		
		// 유효성 검사 
		if(code == null || cname == null || code.trim().equals("") ||
									cname.trim().equals("")) {
			return "/admin/cat_input.jsp";
		}
		
		CategoryDAO dao = CategoryDAO.getInstance();
		int n = dao.insertCategory(code, cname);
		String viewPage = null; 
		if(n>0) {
			request.setAttribute("msg", "카테고리 등록 완료");
			viewPage = "catAllList.do";
		}else {
			request.setAttribute("msg", "카테고리 등록 실패하였습니다");
			viewPage = "/floweradmin/cat_input.jsp";
		}
			
		
		return viewPage;
	}
}
