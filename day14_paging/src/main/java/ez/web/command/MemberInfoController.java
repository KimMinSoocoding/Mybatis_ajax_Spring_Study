package ez.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.model.MemberDAO;
import ez.web.model.MemberDTO;

public class MemberInfoController implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println(no);
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.memberInfo(no);
		
		// Object Binding
		request.setAttribute("dto", dto);
	}
}
