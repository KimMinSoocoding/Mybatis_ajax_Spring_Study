package ez.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	String memberDelete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	String memberList(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	String memberInsert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	String memberInfo(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	String memberUpdate(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	String memberRegister(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;

}
