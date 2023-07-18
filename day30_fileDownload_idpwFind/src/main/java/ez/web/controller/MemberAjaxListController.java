package ez.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import web.model.MemberDAO;
import web.model.MemberDTO;

public class MemberAjaxListController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> memberList=dao.memberList();
		
		// Gson API : ArrayList를 JSON으로 변환할 수 있는 API
		// maven repository 에서 받으면 됨 
		Gson gson = new Gson();
		
		// List를 json형식의 문자열로 변환
		String json =  gson.toJson(memberList);
		System.out.println(json);
		
		// 응답형식 지정
		response.setContentType("text/json; charset=utf-8");		
		// ajax함수에서 만든 콜백함수 listPrint()인자로 전송
		response.getWriter().print(json);
		
		// 비동기 처리를 위해서 페이지명이 없도록 null 처리
		return null;
	}
}
