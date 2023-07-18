package ez.web.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.ProductDAO;
import ez.web.model.ProductDTO;

public class ProdListCommand implements ShopCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductDAO dao = ProductDAO.getInstance();
		ArrayList<ProductDTO> dtos =dao.productList();
		
		request.setAttribute("dtos", dtos);
		
		
		return "/admin/pd_list.jsp";
	}
}
