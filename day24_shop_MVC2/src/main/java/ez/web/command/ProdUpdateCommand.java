package ez.web.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.CategoryDAO;
import ez.web.model.CategoryDTO;
import ez.web.model.ProductDAO;
import ez.web.model.ProductDTO;

public class ProdUpdateCommand implements ShopCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pNum = request.getParameter("pNum");
		
		if(pNum == null || pNum.trim().equals("")){
			response.sendRedirect("pd_list.jsp");
			return "/admin/pd_list.jsp";
		}
		// 상품리스트에서 수정버튼을 클릭했을 때
		// 해당 상품DTO를 DB에서 가져오기
		ProductDAO pDao = ProductDAO.getInstance();
		ProductDTO pDto =pDao.getProduct(pNum);
		request.setAttribute("pDto", pDto);
		System.out.println(pDto);
		
		CategoryDAO dao = CategoryDAO.getInstance();
		ArrayList<CategoryDTO> dtos=dao.categoryList();
		request.setAttribute("list", dtos);
		
		return "/admin/pd_update.jsp";
	}
}
