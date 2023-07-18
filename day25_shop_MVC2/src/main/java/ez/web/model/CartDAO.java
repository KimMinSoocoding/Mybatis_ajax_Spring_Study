package ez.web.model;

import java.util.ArrayList;

public class CartDAO {
	// 장바구니
	private ArrayList<ProductDTO> cartList;
	
	public CartDAO() {
		cartList = new ArrayList<ProductDTO>();
	}
	
	// 장바구니에 상품을 추가하는 메소드
	public void addProduct(ProductDAO pDao, String pNum, String pQty, String pSpec) {
		/////// 장바구니에 추가하고자 하는 상품이 있는 경우
		// 수량만 추가
		
		// 상품 수량
		int addQty = Integer.parseInt(pQty.trim());
		
		for(ProductDTO pDto : cartList) {
			//매개변수 pNum(String)과 pDto의 pNum타입(int)을 일치시켜 비교하기 위함.
			// String.valueOf()를 사용함. 
			if(pNum.equals(String.valueOf(pDto.getpNum()))){
				pDto.setpQty(pDto.getpQty()+addQty);
				return; // 함수종료(아래코드는 수행하지 않도록)
			}
		}
		
		
		/////// 장바구니에 추가하고자 하는 상품이 없는 경우
		ProductDTO pDto = pDao.getProduct(pNum, pSpec);
//		System.out.println("## 상품번호 : "+pDto.getpNum());
		System.out.println("상품 가져오기 완료!!");
		
		if(pDto !=null) {
			System.out.println("##############");
			// 장바구니에 담을 상품에 구매수량 설정
			pDto.setpQty(addQty);
			// 장바구니에 상품을 담기
			cartList.add(pDto);
		}
	}
	
	// 장바구니안에 모든 상품을 가져오기
	public ArrayList<ProductDTO> getCartList(){
		return cartList;
	}
	
	// 장바구니 안에 상품 삭제하기
	public void deleteProduct(String pNum) {
		for(ProductDTO pDto : cartList) {
			if(pNum.equals(String.valueOf(pDto.getpNum()))) {
				cartList.remove(pDto);
				break; // 해당상품을 찾아서 삭제했으면 더이상 루프를 돌필요없이 빠져나오기
			}
		}
	}
	
	
	// 장바구니 상품 수량 수정
	public void modifyProduct(String pNum, String pQty) {
		int qty = Integer.parseInt(pQty.trim());
		
		for(ProductDTO pDto : cartList) {
			if(pNum.equals(String.valueOf(pDto.getpNum()))) {
				if(qty<=0) {
					// 0이하의 수량이 입력되었을 때는 삭제 처리
					cartList.remove(pDto);
					break;
				}else {
					pDto.setpQty(qty);
					break;
				}// if문
			}// if문
		}// for문
	}
	
	
	
}
