package flowerCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flower.model.CategoryDAO;
import flower.model.CategoryDTO;

public class CatAllListCommand implements FlowerCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CategoryDAO dao = CategoryDAO.getInstance();
		ArrayList<CategoryDTO> dtos = dao.categoryList();
		
		request.setAttribute("dtos", dtos);
		
		return "/floweradmin/cat_list.jsp";
	}

}
