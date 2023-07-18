package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.MemberDAO;



public class MemberDeleteController implements Command{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 삭제할 회원 no 파라미터 수집
		int no = Integer.parseInt(request.getParameter("no"));
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.delMember(no);
	}
}
