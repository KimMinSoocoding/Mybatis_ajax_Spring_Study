package flowerCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flower.util.ProdSpec;
import flower.model.CategoryDAO;
import flower.model.CategoryDTO;

public class ProdInputCommand implements FlowerCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		CategoryDAO dao = CategoryDAO.getInstance();
		ArrayList<CategoryDTO> dtos=dao.categoryList();
		request.setAttribute("list", dtos);
		
		// 열거형 상수를 배열로 리턴
		ProdSpec[] pdSpecs = ProdSpec.values();
		request.setAttribute("pdSpecs", pdSpecs);
		
		
		return "/floweradmin/pd_input.jsp";
	}

}
