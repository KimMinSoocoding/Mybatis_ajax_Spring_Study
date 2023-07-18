package flowerCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import flower.model.CategoryDAO;
import flower.model.CategoryDTO;
import flower.model.ProductDAO;
import flower.model.ProductDTO;


public class ProdUpdateCommand implements FlowerCommand{

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pNum = request.getParameter("pNum");
		
		// 유효성검사
		if(pNum == null || pNum.trim().equals("")) {
			return "/floweradmin/pd_list.jsp";
		}
		
		// DTO를 DB에서 가져오기 
		ProductDAO pDao = ProductDAO.getInstance();
		ProductDTO pDto = pDao.getProduct(pNum);
		request.setAttribute("pDto", pDto);
		
		CategoryDAO dao = CategoryDAO.getInstance();
		ArrayList<CategoryDTO> dtos = dao.categoryList();
		request.setAttribute("list", dtos);
		
		return "/floweradmin/pd_update.jsp";
	}

}
