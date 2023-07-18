package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ez.web.model.MemberDAO;
import ez.web.model.MemberDTO;

public class UserJoinOkCommand implements ShopCommand{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		
		MemberDTO mDto = new MemberDTO(id, pw, name, tel, email, addr, null);
		
		HttpSession session = request.getSession();
		
		MemberDAO dao = MemberDAO.getInstance();
		int n = dao.memberInsert(mDto);
		
		String viewPage = null;
		if(n == MemberDAO.MEMBER_JOIN_SUCCESS){
			session.setAttribute("id", mDto.getId());
			request.setAttribute("msg", "회원 가입 처리 되었습니다!!");
			viewPage = "/customer/user_login.jsp";
		} else {
			request.setAttribute("msg", "회원 가입 처리 실패!!");
			viewPage = "/customer/user_join .jsp";
		}
			
		
		
		session.invalidate();
		return viewPage;
	}
}
