package ez.web.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.CategoryDAO;
import ez.web.model.CategoryDTO;
import ez.web.util.ProdSpec;

public class ProdInputCommand implements ShopCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CategoryDAO dao = CategoryDAO.getInstance();
		ArrayList<CategoryDTO> dtos=dao.categoryList();
		request.setAttribute("list", dtos);
		
		// 열거형 상수를 배열로 리턴
		ProdSpec[] pdSpecs = ProdSpec.values();
		request.setAttribute("pdSpecs", pdSpecs);
		
		
		return "/admin/pd_input.jsp";
	}
}
