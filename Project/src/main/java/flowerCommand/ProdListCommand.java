package flowerCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import flower.model.AdminDAO;
import flower.model.AdminDTO;
import flower.model.ProductDAO;
import flower.model.ProductDTO;


public class ProdListCommand implements FlowerCommand{

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductDAO dao = ProductDAO.getInstance();
		ArrayList<ProductDTO> dtos = dao.productList();
		
		request.setAttribute("dtos", dtos);

		return "/floweradmin/pd_list.jsp";
	}

}
