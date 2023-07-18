package flowerFrontcontroller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flowerCommand.FlowerCommand;

//@WebServlet("/FlowerController")
public class FlowerController extends HttpServlet {
	private HashMap<String, FlowerCommand> commandMap = new HashMap<String, FlowerCommand>();
	
	@Override
	public void init() throws ServletException {
			String configFile=getInitParameter("configFile");
			
			String configPath = getServletContext().getRealPath(configFile);
			Properties prop = new Properties();
			
			try {
				FileReader fis = new FileReader(configPath);
				prop.load(fis);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// Iterator : 컬렉션에서 객체얻어오기
			Iterator keyIter = prop.keySet().iterator();
			
			// while 문으로 하나씩 객체 얻기 
			while(keyIter.hasNext()) {
				// 키값 읽어오기 
				String command = (String)keyIter.next();
				// getProperty 값을 읽어오기
				String cmdValue = prop.getProperty(command);
			
			
			try {
				// 동적인 객체를 생성 <?> 은 아직 정해지지 않은 모든 종류의 타입
				
				// 동적 클래스 생성 
				Class<?> cmdClass = Class.forName(cmdValue);
				
				// 인스턴스를 생성 
				FlowerCommand cmdInstance = (FlowerCommand)cmdClass.getDeclaredConstructor().newInstance();
				
				
				// /ad_login.do /ad_logout.do ... 등에 해당하는 각 클래스의 인스턴스를 맵에 저장 
				commandMap.put(command, cmdInstance);
				
				FlowerCommand cmdInstance2 = commandMap.get(command);
				System.out.println("cmdInstance2 : " + cmdInstance2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String cmd = uri.substring(ctx.length());
		// 바인딩하기 
		request.setAttribute("cmd", cmd);
		
		FlowerCommand cmdInstance = commandMap.get(cmd.trim());
		
		String viewPage = null;
		viewPage = cmdInstance.execute(request, response);
		
		// 포워딩하기 getRequestDispatcher: 요청받은것을 위임하는 곳에 동일하게 전달
		if(viewPage != null) {
			RequestDispatcher rd = request.getRequestDispatcher(viewPage);
			rd.forward(request, response);
		}
	}

}
