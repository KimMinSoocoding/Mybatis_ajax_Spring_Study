package ez.web.frontController;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ez.web.command.ShopCommand;

//@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
private HashMap<String, ShopCommand> commandMap = new HashMap<String, ShopCommand>();
   
	// init()에 정의한 코드 역할 : 요청경로에 해당하는 보조컨트롤러 객체(인스턴스)를 만드는 역할 
	// FrontControlle 서블릿이 만들어지는 시점에 동시에 init()이 호출되면서 한번만 수행된다. 

   @Override
   public void init() throws ServletException {
      String configFile=getInitParameter("configFile");
      
      String configPath = getServletContext().getRealPath(configFile);
      // properties 파일의 내욕을 읽어 올때 Properties 컬렉션 클래스를 활용 
      // properties 조상은 Map(key, value)
      Properties prop = new Properties();
      
      try {
    	  // shop_properties 파일의 내용을 읽어들임
         FileReader fis = new FileReader(configPath);
         prop.load(fis);
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      // prod.keySet() 키값만 모은 Set 객체(/adminLogout.do, /prodRegisterOk.do ......)
      Iterator keyIter =prop.keySet().iterator(); // keyIter는 키값을 반복순회할 수 있는 반복자
      
      while(keyIter.hasNext()) {
         // 키값 읽어오기
         String command = (String)keyIter.next();
         System.out.println(command);
         // 키값을 이용해서 value값 가져오기 ( ez.web.command.AdminLogoutCommand, ....등)
         String cmdValue = prop.getProperty(command);
         System.out.println(cmdValue);
         
         
         try {
            // 1. new를 이용한 일반적 객체 생성
            //import ez.web.A;
            //A a = new A();
            
            
            // 2. 동적인 객체 생성, <?> 정해지지 않은 모든 종류의 타입
            //Class<?> clazz = Class.forName("ez.web.A");
            //A a =(A)clazz.newInstance();
        	 
        	 // Class 클래스를 사용하는 이유 : 필요에 따라 여러 객체를 사용해야 하는 경우 
        	 // 1번 처럼 new를 이용하여 객체를 생성하는 것은 컴파일 시점에 참조해야할 클래스가 A클래스로 정해진 경우 
        	 // 이경우에는 a인스턴스를 계속해서 정적으로 사용하는 것이므로 Class 클래스를 사용할 필요가 없다. 
        	 
        	 // 2번처럼 Class.forName("클래스 이름")을 이용해서 객체를 생성하는 것은 
        	 // A클래스외에 또 다른 B클래스를 참조해야 하는 경우 사용한다 즉 동적으로 필요에 따라
        	 // A객체를 사용하기도 하고, B객체, C객체를 사용해야 하는 경우를 의미한다. 
        	 
        	 // 또한, 많은 객체를 사용해야하는 경우 Class 클래스를 이용하면 new연산자를 이용한 객체 생성보다
        	 // 효율적으로 코드 작업을 할 수 있다 
            
            // 클래스 동적 생성 => 클래스를 동적으로 로딩해서 인스턴스를 생성한다는 의미
            Class<?> cmdClass = Class.forName(cmdValue);
            
            // 인스턴스를 생성
//            ShopCommand cmdInstance= (ShopCommand)cmdClass.newInstance();
            ShopCommand cmdInstance= (ShopCommand)cmdClass.getDeclaredConstructor().newInstance();
            
            // /list.do, /write.do,...에 해당하는 각 클래스의 인스턴스를 맵에 저장
            // /userLoginOk.do, ez.web.command.UserLoginOkCommand의 인스턴스(객체)
            commandMap.put(command, cmdInstance);
            
            ShopCommand cmdInstance2 = commandMap.get(command);
            // Heap에 만들어진 인스턴스 확인
            System.out.println("cmdInstance2 : " + cmdInstance2);
            
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }
   
   // FrontController 서블릿이 만들어진 이후부터는 service메소드만 호출됨
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      
      String uri = request.getRequestURI();      
      String ctx = request.getContextPath();
      String cmd = uri.substring(ctx.length());
      System.out.println("cmd : " + cmd);
      
      request.setAttribute("cmd", cmd);
      
      // init()에 의해 만들어진 해당 보조컨트롤러 인스턴스들을 가져오기
      ShopCommand cmdInstance = commandMap.get(cmd.trim());
      
      String viewPage = null;
      viewPage = cmdInstance.execute(request, response);
      
      if(viewPage != null) {
         RequestDispatcher rd = request.getRequestDispatcher(viewPage);
         rd.forward(request, response);
      }
   }

}