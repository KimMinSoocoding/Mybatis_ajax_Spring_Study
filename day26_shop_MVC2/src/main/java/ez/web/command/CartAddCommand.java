package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ez.web.model.CartDAO;
import ez.web.model.ProductDAO;

public class CartAddCommand implements ShopCommand{
   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      
      HttpSession session = request.getSession();
      CartDAO shopCart =(CartDAO)session.getAttribute("shopCart");
      
      // user_main.jsp 에서 전달되는 parameter는 
      // pNum, pSpec, pCategory_fk, pQty 인데, 이때 pCategory_fk의 값은 null이아니라
      // 빈 공백값이 전달된다.
      
      String pNum = request.getParameter("pNum");
      String pSpec = request.getParameter("pSpec");
      String pCategory_fk = request.getParameter("pCategory_fk");
      String pQty = request.getParameter("pQty");
      
      System.out.println("pSpec ~~~~~??? : "+pSpec);
      System.out.println("pCategory_fk ~~~~~??? : "+pCategory_fk);
      
      ProductDAO pDao = ProductDAO.getInstance();
      
      if(pCategory_fk == null || pCategory_fk.trim().length() == 0){ 
         shopCart.addProduct(pDao, pNum, pQty, pSpec);
      
      }else{   
         shopCart.addProduct(pDao, pNum, pQty, pCategory_fk);
      }
      
      System.out.println("장바구니 담기 성공!!");
      
      
      return "/cartList.do";
   }
}