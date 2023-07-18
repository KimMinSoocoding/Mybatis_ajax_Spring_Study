package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import ez.web.model.ProductDAO;

public class ProdRegisterOkCommand implements ShopCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String realPath = request.getServletContext().getRealPath("/uploadedFile");
		
		int maxSize = 1024 * 1024 * 10;// 10MB
		
		String msg="", url="";
		
		String viewPage = null;
		
		try {
			MultipartRequest mr = new MultipartRequest(request, realPath, maxSize,
					"utf-8", new DefaultFileRenamePolicy());
			ProductDAO dao = ProductDAO.getInstance();
			int n = dao.registerProduct(mr);
			
			if(n>0){
				request.setAttribute("msg", "상품등록 완료!!");
//				msg = "상품등록 완료!!";
				viewPage ="prodList.do";
			}else{
				request.setAttribute("msg", "상품등록 실패!!");
//				msg = "상품등록 실패!!";
				viewPage ="/admin/pd_input.jsp";
			}
		}catch (Exception e){
			request.setAttribute("msg", "파일 업로드 실패");
//			msg = "파일 업로드 실패!!";
			viewPage = "/admin/pd_input.jsp";
			e.printStackTrace();
		}
		return viewPage;
	}
}
