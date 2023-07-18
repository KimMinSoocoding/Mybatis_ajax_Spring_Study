package ez.web.command;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ez.web.model.ProductDAO;
import ez.web.model.ProductDTO;

public class CategoryListCommand implements ShopCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductDAO pDao = ProductDAO.getInstance();
		String code = request.getParameter("code");
		String catName = request.getParameter("catName");
		
		ArrayList<ProductDTO> pDtos = pDao.getProductByCategory(code);
		// 바인딩
		request.setAttribute("pDtos", pDtos);
		request.setAttribute("catName", catName);
		
		
		
		return "/customer/category_list.jsp";
	}
}
