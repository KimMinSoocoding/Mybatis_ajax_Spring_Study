/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.68
 * Generated at: 2023-01-02 12:16:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DecimalFormat;
import product.ProductBean;
import java.util.ArrayList;
import product.ProductDao;
import cart.CartDao;
import member.MemberBean;
import member.MemberDao;
import category.CategoryBean;
import java.util.ArrayList;
import category.CategoryDao;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/user/./top_user.jsp", Long.valueOf(1672659551000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("member.MemberDao");
    _jspx_imports_classes.add("category.CategoryDao");
    _jspx_imports_classes.add("product.ProductBean");
    _jspx_imports_classes.add("java.text.DecimalFormat");
    _jspx_imports_classes.add("product.ProductDao");
    _jspx_imports_classes.add("category.CategoryBean");
    _jspx_imports_classes.add("java.util.ArrayList");
    _jspx_imports_classes.add("cart.CartDao");
    _jspx_imports_classes.add("member.MemberBean");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("	body, header {\r\n");
      out.write("	    font-size: 17px;\r\n");
      out.write("	    line-height: 1.25;\r\n");
      out.write("	    font-family: 'Noto Sans KR', AppleGothic, Helvetica, sans-serif;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	body {\r\n");
      out.write("	    background-color: #FFF;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	/* a태그 밑줄 없애기 */\r\n");
      out.write("	a {\r\n");
      out.write("  		text-decoration: none;\r\n");
      out.write("  		color: #1c1c1c;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	/* 리스트의 왼쪽 점 없애기 */\r\n");
      out.write("	li{\r\n");
      out.write("		list-style : none;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	/* 마우스 올리면 색깔 변하게 하기 */\r\n");
      out.write("	.tmenu > a:hover{\r\n");
      out.write("		color : gray;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	/* 최상단 헤더--------------*/\r\n");
      out.write("	.hd{\r\n");
      out.write("		width : 100%;\r\n");
      out.write("		background-color: #FFF;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.hd img{\r\n");
      out.write("		width : 247px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.hdRight li{\r\n");
      out.write("		float : right;\r\n");
      out.write("		margin : 10px;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	.hdRight a{\r\n");
      out.write("		font-size: 12px;\r\n");
      out.write("	}\r\n");
      out.write("	/* ----------------------*/\r\n");
      out.write("	\r\n");
      out.write("	/* 카테고리가 위치한 헤더-------------- */\r\n");
      out.write("	.hd2{\r\n");
      out.write("		width: 100%;\r\n");
      out.write("		border-top: 1px solid black;\r\n");
      out.write("	}\r\n");
      out.write("	.hd2 td{\r\n");
      out.write("		height : 50px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.cateWrap, .searchWrap{\r\n");
      out.write("		text-align: center;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.tmenu{\r\n");
      out.write("		position: relative; /* class = 'depth2'가 absolute 일 때 이것을 부모로 인식하도록 position을 지정해줌*/\r\n");
      out.write("		margin: 0px 10px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	/* 카테고리에 마우스 올렸을 때 화면에 뜨는 부분 */\r\n");
      out.write("	.depth2{\r\n");
      out.write("		position: absolute; /* 다른 요소에 영향을 주지않고 배치시키기 위함  */\r\n");
      out.write("		transform: translate(-50%,0%);\r\n");
      out.write("		right : 50%; \r\n");
      out.write("		left : 50%;\r\n");
      out.write("		top: 100%;\r\n");
      out.write("		width: 100px; \r\n");
      out.write("		padding-left: 0px;\r\n");
      out.write("		text-align: center;\r\n");
      out.write("		padding-top: 10px;\r\n");
      out.write("		/* background-color: #FFF; */\r\n");
      out.write("		margin-top: 0;\r\n");
      out.write("		background-color: #FFF;\r\n");
      out.write("		\r\n");
      out.write("		/* border : 1px red solid; */\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.searchWrap{\r\n");
      out.write("		height : auto;\r\n");
      out.write("		display: flex;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.depth2 li{\r\n");
      out.write("		padding : 5px;\r\n");
      out.write("		font-size: 13px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.searchArea li{\r\n");
      out.write("		float : left;\r\n");
      out.write("		margin : 5px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.searchspan{\r\n");
      out.write("		position: relative; /* class = 'depth2'가 absolute 일 때 이것을 부모로 인식하도록 position을 지정해줌*/\r\n");
      out.write("		margin: 0px 0px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.searchspan input{\r\n");
      out.write("		width : 150px;\r\n");
      out.write("		border-radius: 8px;\r\n");
      out.write("		/* outline: red; */\r\n");
      out.write("		border: 1px #979797 solid; \r\n");
      out.write("		background: transparent;\r\n");
      out.write("		margin-top: 15px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.searchspan img{\r\n");
      out.write("		position : absolute;\r\n");
      out.write("		top: 0px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	.searchArea{\r\n");
      out.write("		height : auto;\r\n");
      out.write("		display: flex; /* 높이가 자동으로 0으로 설정된다면 사용해볼만한 설정 */\r\n");
      out.write("	}\r\n");
      out.write("	/* ----------------------*/\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<!-- <script type=\"text/javascript\" src=\"../js/jquery.js\"></script> -->\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	\r\n");
      out.write("	$(document).ready(function(){\r\n");
      out.write(" 		//카테고리 펼쳐지고 접히기\r\n");
      out.write("		jQuery(\".tmenu\").live(\"mouseenter\", function() {\r\n");
      out.write("		   jQuery(this).find(\".depth2\").slideDown(\"fast\");\r\n");
      out.write("		});\r\n");
      out.write("		jQuery(\".tmenu\").live(\"mouseleave\", function() {\r\n");
      out.write("		   jQuery(this).find(\".depth2\").slideUp(\"fast\");\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	function gotoCart(){\r\n");
      out.write("		");

		if(session.getAttribute("mno") == null){
      out.write("\r\n");
      out.write("			location.href = \"./loginView.jsp\";\r\n");
      out.write("		");
			
		}
		else{
		
      out.write("\r\n");
      out.write("			location.href = \"");
      out.print(request.getContextPath());
      out.write("/user/cart/showCart.jsp\";	\r\n");
      out.write("		");
	
		}
		
      out.write("\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<header>\r\n");
      out.write("	<table class=\"hd\">\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td width=33%></td>\r\n");
      out.write("			<td width=33% align=\"center\"><a href=\"");
      out.print(request.getContextPath());
      out.write("/user/main.jsp\" class=\"hd_logo\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/images/title.png\" style=\"height:40px; width:230px\"></a></td>\r\n");
      out.write("			\r\n");
      out.write("			<td width=33% align=\"right\">\r\n");
      out.write("				<ul class=\"hdRight\">\r\n");
      out.write("					<li>\r\n");
      out.write("						<a href=\"javascript:gotoCart()\">\r\n");
      out.write("						CART<span class=\"bsCount\">(<span id=\"user_basket_quantity\" class=\"user_basket_quantity\">\r\n");
      out.write("						");

						int result = 0;
						if(session.getAttribute("mno") != null){
							int mno = (int)session.getAttribute("mno");
							CartDao ctdao = CartDao.getInstance();
							result = ctdao.countItemInCart(mno);	
						}
						
      out.write("\r\n");
      out.write("						\r\n");
      out.write("						");
      out.print(result);
      out.write("\r\n");
      out.write("						\r\n");
      out.write("						</span>)</span>\r\n");
      out.write("						</a>\r\n");
      out.write("					</li>\r\n");
      out.write("					\r\n");
      out.write("					");

						MemberDao mdao = MemberDao.getInstance();
						
						String mid = (String)session.getAttribute("mid");
						
						if(mid == null){ // 로그인을 하지 않은 상태
						
      out.write("\r\n");
      out.write("							\r\n");
      out.write("							<li><a href=\"./userJoinView.jsp\">JOIN</a></li>\r\n");
      out.write("							<li><a href=\"./loginView.jsp\">LOGIN</a></li>\r\n");
      out.write("						");
							
						}
						else{ // 로그인 상태
							
							MemberBean mbean = mdao.getMemberById(mid);
							
							
      out.write("\r\n");
      out.write("								\r\n");
      out.write("								<li><a href=\"/shop/member.html?type=mynewmain\">MYPAGE</a></li>\r\n");
      out.write("								<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/user/logoutProc.jsp\">LOGOUT</a></li>\r\n");
      out.write("							");

						
							if(mid.equals("admin")){
      out.write("\r\n");
      out.write("								<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/categoryManage/categoryManage.jsp\">MANAGE</a></li>\r\n");
      out.write("							");
	
							}
							
							
      out.write("\r\n");
      out.write("							\r\n");
      out.write("							<li><a>");
      out.print(mbean.getName());
      out.write("님</a></li>\r\n");
      out.write("							\r\n");
      out.write("							");

						}
						
						
						
					
      out.write("\r\n");
      out.write("					<!-- <li><a href=\"https://www.jogunshop.com/shop/idinfo.html?type=new&amp;mem_type=person&amp;first=\">JOIN</a></li>\r\n");
      out.write("					<li><a href=\"./login/loginView.jsp\">LOGIN</a></li> -->\r\n");
      out.write("				</ul>\r\n");
      out.write("			</td>\r\n");
      out.write("		<tr>\r\n");
      out.write("	</table>\r\n");
      out.write("	\r\n");
      out.write("	<!-- <hr> -->\r\n");
      out.write("	<table class=\"hd2\">\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td width=\"20%\"></td>\r\n");
      out.write("			<td width=\"60%\">\r\n");
      out.write("				<!-- 카테고리 -->\r\n");
      out.write("				<div class=\"cateWrap\">\r\n");
      out.write("					\r\n");
      out.write("					");

						CategoryDao cdao = CategoryDao.getInstance();	
						ArrayList<CategoryBean> clist = cdao.getAllCategory();
							
						String beforeLname = "";
						
						for(int i = 0; i<clist.size() ;i++){
							CategoryBean cbean = clist.get(i);
							
							if(cbean.getSstep() == 1 || cbean.getSname() == null){
      out.write("\r\n");
      out.write("									</ul>\r\n");
      out.write("								</span>\r\n");
      out.write("							");
 
							}
							
							if(beforeLname.equals(cbean.getLname()) == false && (cbean.getSstep() == 1 || cbean.getSname() == null) && cbean.getLstep() != 0){// 대분류 명일때
							
      out.write("\r\n");
      out.write("								<span class=\"tmenu\"> <a href=\"");
      out.print(request.getContextPath());
      out.write("/user/showLargeCategory.jsp?lcno=");
      out.print(cbean.getLno());
      out.write('"');
      out.write('>');
      out.print(cbean.getLname() );
      out.write("</a>\r\n");
      out.write("									<ul class=\"depth2\" style=\"display: none;\">\r\n");
      out.write("							");
	
							}
							
							if(cbean.getSname() != null){
      out.write("\r\n");
      out.write("								<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/user/showSmallCategory.jsp?scno=");
      out.print(cbean.getSno());
      out.write('"');
      out.write('>');
      out.print(cbean.getSname() );
      out.write("</a></li>\r\n");
      out.write("							");
	
							}

							beforeLname = cbean.getLname();
						}
					
					
      out.write("\r\n");
      out.write("					\r\n");
      out.write("			\r\n");
      out.write("					<!-- <span class=\"tmenu\"> \r\n");
      out.write("					<a href=\"/shop/shopbrand.html?xcode=071&amp;type=P\"><font color=#C2674B>BEST</font></a>\r\n");
      out.write("					</span> \r\n");
      out.write("					\r\n");
      out.write("					<span class=\"tmenu\"> <a href=\"/shop/shopbrand.html?xcode=078&amp;type=Y\">TOP</a>\r\n");
      out.write("						<ul class=\"depth2\" style=\"display: none;\">\r\n");
      out.write("							<li><a href=\"/shop/shopbrand.html?xcode=078&amp;type=N&amp;mcode=010\">반팔티</a></li>\r\n");
      out.write("							<li><a href=\"/shop/shopbrand.html?xcode=078&amp;type=N&amp;mcode=003\">나시</a></li>\r\n");
      out.write("							<li><a href=\"/shop/shopbrand.html?xcode=078&amp;type=N&amp;mcode=002\">프린팅티</a></li>\r\n");
      out.write("							<li><a href=\"/shop/shopbrand.html?xcode=078&amp;type=N&amp;mcode=011\">니트</a></li>\r\n");
      out.write("							<li><a href=\"/shop/shopbrand.html?xcode=078&amp;type=N&amp;mcode=009\">맨투맨&amp;후드티</a></li>\r\n");
      out.write("							<li><a href=\"/shop/shopbrand.html?xcode=078&amp;type=N&amp;mcode=004\">긴팔티</a></li>\r\n");
      out.write("						</ul>\r\n");
      out.write("					</span> \r\n");
      out.write("					\r\n");
      out.write("					<span class=\"tmenu\"> \r\n");
      out.write("						<a href=\"/shop/shopbrand.html?xcode=055&amp;type=Y\">SHIRTS</a>\r\n");
      out.write("						<ul class=\"depth2\" style=\"display: none;\">\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=055&amp;type=N&amp;mcode=004\">베이직</a></li>\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=055&amp;type=N&amp;mcode=006\">청남방</a></li>\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=055&amp;type=N&amp;mcode=005\">체크&amp;패턴</a></li>\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=055&amp;type=N&amp;mcode=003\">스트라이프</a></li>\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=055&amp;type=N&amp;mcode=008\">헨리넥&amp;차이나</a></li>\r\n");
      out.write("						</ul>\r\n");
      out.write("					</span> \r\n");
      out.write("					\r\n");
      out.write("					<span class=\"tmenu\"> \r\n");
      out.write("						<a href=\"/shop/shopbrand.html?xcode=081&amp;type=Y\">PANTS</a>\r\n");
      out.write("						<ul class=\"depth2\" style=\"display: none;\">\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=081&amp;type=N&amp;mcode=006\">슬랙스</a></li>\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=081&amp;type=N&amp;mcode=003\">면바지</a></li>\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=081&amp;type=N&amp;mcode=002\">청바지</a></li>\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=081&amp;type=N&amp;mcode=007\">밴딩팬츠</a></li>\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=081&amp;type=N&amp;mcode=004\">반바지</a></li>\r\n");
      out.write("						</ul>\r\n");
      out.write("					</span> \r\n");
      out.write("					\r\n");
      out.write("					<span class=\"tmenu\"> \r\n");
      out.write("						<a href=\"/shop/shopbrand.html?xcode=079&amp;type=Y\">OUTER</a>\r\n");
      out.write("						<ul class=\"depth2\" style=\"display: none;\">\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=079&amp;type=N&amp;mcode=004\">패딩</a></li>\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=079&amp;type=N&amp;mcode=002\">코트</a></li>\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=079&amp;type=N&amp;mcode=006\">수트&amp;블레이져</a></li>\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=079&amp;type=N&amp;mcode=010\">자켓</a></li>\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=079&amp;type=N&amp;mcode=007\">블루종/MA-1</a></li>\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=079&amp;type=N&amp;mcode=005\">가디건&amp;조끼</a></li>\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=079&amp;type=N&amp;mcode=008\">후드&amp;집업</a></li>\r\n");
      out.write("						</ul>\r\n");
      out.write("					</span> \r\n");
      out.write("					\r\n");
      out.write("					<span class=\"tmenu\"> \r\n");
      out.write("						<a href=\"/shop/shopbrand.html?xcode=083\">SHOES&amp;BAG</a>\r\n");
      out.write("						<ul class=\"depth2\" style=\"display: none;\">\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=083&amp;type=N&amp;mcode=001\">신발</a></li>\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=083&amp;type=N&amp;mcode=002\">가방</a></li>\r\n");
      out.write("						</ul>\r\n");
      out.write("					</span> \r\n");
      out.write("					\r\n");
      out.write("					<span class=\"tmenu\"> \r\n");
      out.write("						<a href=\"/shop/shopbrand.html?xcode=080\">ACC</a>\r\n");
      out.write("						<ul class=\"depth2\" style=\"display: none;\">\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=080&amp;type=N&amp;mcode=005\">양말&amp;타이</a></li>\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=080&amp;type=N&amp;mcode=003\">모자</a></li>\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=080&amp;type=N&amp;mcode=008\">벨트&amp;시계</a></li>\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=080&amp;type=N&amp;mcode=006\">머플러&amp;장갑</a></li>\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=080&amp;type=N&amp;mcode=002\">안경</a></li>\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=080&amp;type=N&amp;mcode=004\">쥬얼리</a></li>\r\n");
      out.write("							<li><a\r\n");
      out.write("								href=\"/shop/shopbrand.html?xcode=080&amp;type=N&amp;mcode=007\">etc</a></li>\r\n");
      out.write("						</ul>\r\n");
      out.write("			\r\n");
      out.write("					</span> \r\n");
      out.write("					\r\n");
      out.write("					<span class=\"tmenu\"> \r\n");
      out.write("						<a href=\"/shop/shopbrand.html?xcode=076\">SALE</a>\r\n");
      out.write("					</span> -->\r\n");
      out.write("				</div>\r\n");
      out.write("			</td> \r\n");
      out.write("			<td width=\"20%\">\r\n");
      out.write("				<div class=searchWrap>\r\n");
      out.write("					<form action=\"showSearchResult.jsp\" method=\"post\" name=\"search\">\r\n");
      out.write("						<span class=\"searchspan\"> \r\n");
      out.write("								<input name=\"search\" onkeydown=\"CheckKey_search();\" value=\"\" class=\"MS_search_word\"> \r\n");
      out.write("								<a href=\"javascript:search_submit();\" class=\"searhBtn\">\r\n");
      out.write("								<i class=\"xi-search\"></i>\r\n");
      out.write("								</a>\r\n");
      out.write("						</span> \r\n");
      out.write("							\r\n");
      out.write("						<span class=\"searchspan\"> 				\r\n");
      out.write("							<a href=\"/shop/shopbrand.html\"><img src=\"");
      out.print(request.getContextPath());
      out.write("/images/btn_search.gif\"></a>\r\n");
      out.write("						</span>\r\n");
      out.write("					</form>\r\n");
      out.write("				</div>\r\n");
      out.write("			</td> \r\n");
      out.write("		</tr>\r\n");
      out.write("	</table>\r\n");
      out.write("</header>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("	body {\r\n");
      out.write("		font-family: Noto Sans Kr;\r\n");
      out.write("		font-size: 13px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#mainList {\r\n");
      out.write("		margin: auto;\r\n");
      out.write("		margin-top : 50px;\r\n");
      out.write("		text-align: center;\r\n");
      out.write("		width: 750px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#mainListInside td {\r\n");
      out.write("		padding-left: 10px;\r\n");
      out.write("		padding-right: 10px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#mainListInside h3 {\r\n");
      out.write("		padding-top: 10px;\r\n");
      out.write("		padding-bottom: 10px; font-size : 13px;\r\n");
      out.write("		word-spacing: -1px;\r\n");
      out.write("		color: #000;\r\n");
      out.write("		border-bottom: 1px solid #D5D5D5;\r\n");
      out.write("		font-size: 13px\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#mainListInside td>span {\r\n");
      out.write("		color: #555555;\r\n");
      out.write("		font-size: 12px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#banner_imageTable {\r\n");
      out.write("		width :1550;\r\n");
      out.write("		height : 700;\r\n");
      out.write("		margin: auto;\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"../../js/jquery.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("	$(document).ready(function(){\r\n");
      out.write("		$('#banner_image').show();\r\n");
      out.write("		/* $('#banner_image').hide();\r\n");
      out.write("		$('#banner_image').fadeIn(3000);\r\n");
      out.write("		setInterval(function(){\r\n");
      out.write("			$('#banner_image').hide();\r\n");
      out.write("			$('#banner_image').fadeIn(3000);\r\n");
      out.write("		}, 5000); */\r\n");
      out.write("	});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");

ProductDao pdao = ProductDao.getInstance();
ArrayList<ProductBean> list = pdao.getAllProduct();
DecimalFormat decFormat = new DecimalFormat("###,###");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<table id=\"banner_imageTable\">\r\n");
      out.write("	<tr>\r\n");
      out.write("		<td>\r\n");
      out.write("			<img id=\"banner_image\" width=\"1550\" height=\"700\" title=\"\" alt=\"썸머뉴\" rel=\"79-10\" src=\"../images/mainImage.jpg\" style=\"display: none\">\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<td><br><br></td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<td align=\"center\">\r\n");
      out.write("			<img width=\"570\" height=\"160\" src=\"../images/secondImage.PNG\">\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<table id=\"mainList\">\r\n");
      out.write("	<tr>\r\n");
      out.write("	");

		for(int i = 0; i < list.size(); i++){
			ProductBean pbean = list.get(i);
			
			String fullPath = request.getContextPath() + "/admin/product_images/" + pbean.getMainImgN();
			//System.out.println(fullPath);
			
      out.write("\r\n");
      out.write("				<td>\r\n");
      out.write("					<table id=\"mainListInside\">\r\n");
      out.write("						<tr>\r\n");
      out.write("							<td><a href=\"productDetail.jsp?no=");
      out.print(pbean.getNo());
      out.write("\"><img src=");
      out.print(fullPath);
      out.write(" width=\"300px\" height=\"380px\"></a></td>\r\n");
      out.write("						</tr>\r\n");
      out.write("						<tr> \r\n");
      out.write("							<td><h3>");
      out.print(pbean.getName());
      out.write("</h3></td>\r\n");
      out.write("						</tr>\r\n");
      out.write("						<tr>\r\n");
      out.write("							<td width=\"300px\"><span>");
      out.print(pbean.getInfo());
      out.write("</span></td>\r\n");
      out.write("						</tr>\r\n");
      out.write("						<tr>\r\n");
      out.write("							<td>\r\n");
      out.write("								<span style=\"text-decoration:line-through;\">");
      out.print(decFormat.format(pbean.getOriprice()));
      out.write("원</span>\r\n");
      out.write("								<span>");
      out.print(decFormat.format(pbean.getDiscprice()));
      out.write("원</span>\r\n");
      out.write("							</td>\r\n");
      out.write("						</tr>\r\n");
      out.write("					</table>\r\n");
      out.write("				</td>\r\n");
      out.write("			");

			if(i%4 == 3){
      out.write("\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr>\r\n");
      out.write("			");
	
			}
		}
	
      out.write("\r\n");
      out.write("	</tr>\r\n");
      out.write("</table>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
