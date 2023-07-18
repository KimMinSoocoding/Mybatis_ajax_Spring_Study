package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ez.web.model.CartDAO;

public class CartModifyCommand implements ShopCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		CartDAO shopCart = (CartDAO)session.getAttribute("shopCart");
		String pNum = request.getParameter("pNum");
		String pQty = request.getParameter("pQty");
		
		if(pNum == null || pNum.trim().equals("") || pQty == null || pQty.trim().equals("")){
			request.setAttribute("msg", "잘못된 경로입니다!!");
			return "/customer/user_main.jsp";
		}
		try{
			shopCart.modifyProduct(pNum, pQty);
		}catch(NumberFormatException e){
			request.setAttribute("msg", "수량을 잘못 입력하셨습니다!!!");
		}
		return "cartList.do";
	}
}
