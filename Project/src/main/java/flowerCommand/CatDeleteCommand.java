package flowerCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import flower.model.CategoryDAO;

public class CatDeleteCommand implements FlowerCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String catNum = request.getParameter("catNum");

		String viewPage = null;
		// 유효성 검사
		if(catNum == null || catNum.trim().equals("")){			
			return viewPage;
		}
		
		CategoryDAO dao = CategoryDAO.getInstance();
		int n = dao.categoryDel(catNum);
		
		if(n > 0){
			request.setAttribute("msg", "카테고리 삭제");
			viewPage = "catAllList.do";
		}else{
			request.setAttribute("msg", "카테고리 삭제 실패!!");
			viewPage = "/floweradmin/cat_list.jsp";
		}
		
		
		return viewPage;
	}
}
