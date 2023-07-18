package ez.web.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ez.web.model.ProductDAO;
import ez.web.model.ProductDTO;
import ez.web.util.ProdSpec;

public class SpecListCommand implements ShopCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProductDAO pDao = ProductDAO.getInstance();
		String pSpec = request.getParameter("pSpec");
		
		ArrayList<ProductDTO> pDtos = null;
		// main에서 이미 맵에 사양별로 저장해두었기 때문에
		// 데이터베이스 테이블 사용하지 않고 맵에서 데이터를 가져옴
		// 사양별로 가져오기 때문에 전체 상품 중에서 검색하지 않고
		// 해당 사양에서만 상품을 검색할 수 있어 효율적이다.
//		Boolean bool = pDao.map.containsKey(pSpec);
//		System.out.println(bool);
		
//		// HashMap 키값만 가져오기
//		Iterator keyIter = pDao.map.keySet().iterator();
//		
//		while(keyIter.hasNext()) {
//			String spec = (String)keyIter.next();
//			System.out.println("맵에 저장된 키값 : " + spec);
//			pDtos = pDao.map.get(spec);
//			System.out.println("상품갯수 : " + pDtos.size());
//		}
		
			pDtos = pDao.map.get(pSpec);
			String specValue = ProdSpec.valueOf(pSpec).getValue();
			request.setAttribute("specValue", specValue);
			
//		if(!bool){
			if(pDtos.size() == 0) {
			request.setAttribute("msg", "상품이 존재하지 않습니다!!");
		}else{
			// pSpec이 New이면 ProdSpec.valueOf(pSpec)의 값은 NEW
			// pSpec이 HIT이면 ProdSpec.valueOf(pSpec)의 값은 HIT
			// pSpec이 RECOMMEND이면 ProdSpec.valueOf(pSpec)의 값은 RECOMMEND
			// specValue는 인기, 최신, 추천 문자열값을 의미한다.
			//바인딩 
			request.setAttribute("pDtos", pDtos);
		}
		
		return "/customer/spec_list.jsp";
	}
}
