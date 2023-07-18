package ez.web.frontController;

import java.io.FileNotFoundException;
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

import ez.web.command.BaddReplyCommand;
import ez.web.command.Bcommand;
import ez.web.command.BdeleteCommand;
import ez.web.command.BlistCommand;
import ez.web.command.BreplyViewCommand;
import ez.web.command.BupdateCommand;
import ez.web.command.BviewCommand;
import ez.web.command.BwriteCommand;

//@WebServlet("*.do")
public class BoardFrontController extends HttpServlet {
	private HashMap<String, Bcommand> commandMap = new HashMap<String, Bcommand>();
	
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile");
			// configPath는 bbs.properties 파일의 실제 경로 
		String configPath = getServletContext().getRealPath(configFile);
		Properties prop = new Properties();
		
		try {
			FileReader fis = new FileReader(configPath);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Iterator keyIter = prop.keySet().iterator();
		
		while(keyIter.hasNext()) {
			// 키값 읽어오기 
			keyIter.next();
			String command = (String)keyIter.next();
//			System.out.println();
			String cmdValue= prop.getProperty(command);
			System.out.println(cmdValue);
			
			try {
				// 1. new를 이용한 일반적 객체생성 
				// import ez.web.A;
				// A a = new A();
				
				// 2. 동적인 객체 생성, <?> 정해지지 않은 모든 종류의 타입
				// Class<?> clazz = class.forName("ez.web.A");
				// A a = (A)clazz.newInstance();
				
				// 클래스 동적 생성
				Class<?> cmdClass = Class.forName(cmdValue);
				
				// 인스턴스를 생성 
//				Bcommand cmdInstance = (Bcommand)cmdClass.newInstance();
				Bcommand cmdInstance = (Bcommand)cmdClass.getDeclaredConstructor().newInstance();
				
				// list.do /write.do, .... 에 해당하는 각 클래스의 인스턴스를 맵에 저
				commandMap.put(cmdValue, cmdInstance);
				
				Bcommand cmdInstance2 = commandMap.get(command);
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
		System.out.println("cmd : " + cmd);
		
		Bcommand cmdInstance = commandMap.get(cmd.trim());
		
		String viewPage = null;
		viewPage = cmdInstance.execute(request, response);
		
		RequestDispatcher rd = null;
		if(viewPage.indexOf(".do") !=-1) {
			rd = request.getRequestDispatcher(viewPage);
		}else {
			rd = request.getRequestDispatcher("WEB-INF/board/"+viewPage+".jsp");
		}
		
		
		rd.forward(request, response);
	}
}
