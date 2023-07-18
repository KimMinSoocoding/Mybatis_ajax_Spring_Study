package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ez.web.model.CartDAO;

public class CartDeleteCommand implements ShopCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		CartDAO shopCart = (CartDAO)session.getAttribute("shopCart");
		
		// 삭제할 상품번호 가져오기
		String pNum =request.getParameter("pNum");

		if(pNum == null || pNum.trim().equals("")){
			request.setAttribute("msg", "잘못된 경로입니다!!!");
			return "/customer/user_main.jsp";
		}else {
			shopCart.deleteProduct(pNum);
		}
		
		return "cartList.do";
	}
}
