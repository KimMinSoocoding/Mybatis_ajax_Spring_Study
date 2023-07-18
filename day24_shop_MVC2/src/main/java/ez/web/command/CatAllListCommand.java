package ez.web.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.CategoryDAO;
import ez.web.model.CategoryDTO;

public class CatAllListCommand implements ShopCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryDAO dao = CategoryDAO.getInstance();
		ArrayList<CategoryDTO> dtos =dao.categoryList();
		
		request.setAttribute("dtos", dtos);
		
		
		return "/admin/cat_list.jsp";
	}
}
