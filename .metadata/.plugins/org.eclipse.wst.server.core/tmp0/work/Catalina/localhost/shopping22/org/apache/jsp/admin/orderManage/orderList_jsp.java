/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.68
 * Generated at: 2023-01-03 07:38:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin.orderManage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import order.OrderBean;
import order.OrderDao;
import java.text.DecimalFormat;
import product.ProductBean;
import java.util.ArrayList;
import product.ProductDao;
import cart.CartDao;
import member.MemberDao;
import member.MemberBean;

public final class orderList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/admin/orderManage/../top_admin.jsp", Long.valueOf(1672659551000L));
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
    _jspx_imports_classes.add("product.ProductBean");
    _jspx_imports_classes.add("order.OrderBean");
    _jspx_imports_classes.add("java.text.DecimalFormat");
    _jspx_imports_classes.add("product.ProductDao");
    _jspx_imports_classes.add("order.OrderDao");
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
      out.write("<style type=\"text/css\">\r\n");
      out.write("	body, header {\r\n");
      out.write("	    font-size: 17px;\r\n");
      out.write("	    line-height: 1.25;\r\n");
      out.write("	    font-family: 'Noto Sans KR', AppleGothic, Helvetica, sans-serif;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	body{\r\n");
      out.write("	    background-color: #FFF;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	/* a태그 밑줄 없애기 */\r\n");
      out.write("	a{\r\n");
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
      out.write("		color : #C2674B;\r\n");
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
      out.write("	.depth2 li{\r\n");
      out.write("		padding : 5px;\r\n");
      out.write("		font-size: 13px;\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
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
      out.write("					\r\n");
      out.write("					");

						MemberDao mdao = MemberDao.getInstance();
						
						String mid = (String)session.getAttribute("mid");
						
						if(mid == null){ // 로그인을 하지 않은 상태
						
      out.write("\r\n");
      out.write("							<li><a href=\"https://www.jogunshop.com/shop/idinfo.html?type=new&amp;mem_type=person&amp;first=\">JOIN</a></li>\r\n");
      out.write("							<li><a href=\"./loginView.jsp\">LOGIN</a></li>\r\n");
      out.write("						");
							
						}
						else{ // 로그인 상태
							MemberBean mbean = mdao.getMemberById(mid);
							
      out.write("\r\n");
      out.write("							<li><a href=\"/shop/member.html?type=mynewmain\">MYPAGE</a></li>\r\n");
      out.write("							<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/user/logoutProc.jsp\">LOGOUT</a></li>\r\n");
      out.write("							<li><a href=\"");
      out.print(request.getContextPath());
      out.write("/user/main.jsp\">HOME</a></li>\r\n");
      out.write("							<li><a>");
      out.print(mbean.getName());
      out.write("님</a></li>\r\n");
      out.write("							");

						}

					
      out.write("\r\n");
      out.write("					\r\n");
      out.write("					\r\n");
      out.write("					<!-- <li><a href=\"https://www.jogunshop.com/shop/idinfo.html?type=new&amp;mem_type=person&amp;first=\">JOIN</a></li>\r\n");
      out.write("					<li><a href=\"/shop/member.html?type=login\">LOGIN</a></li> -->\r\n");
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
      out.write("				<div class=\"cateWrap\">   <!-- 절대주소 사용해야함.  -->\r\n");
      out.write("					<span class=\"tmenu\"> <a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/categoryManage/categoryManage.jsp\">카테고리 관리</a>\r\n");
      out.write("					</span> \r\n");
      out.write("					\r\n");
      out.write("					<span class=\"tmenu\"> \r\n");
      out.write("						<a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/productManage/prodList.jsp\">상품관리</a>\r\n");
      out.write("					</span> \r\n");
      out.write("					\r\n");
      out.write("					<span class=\"tmenu\"> \r\n");
      out.write("						<a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/orderManage/orderList.jsp\">주문내역</a>\r\n");
      out.write("					</span> \r\n");
      out.write("					\r\n");
      out.write("					<span class=\"tmenu\"> \r\n");
      out.write("						<a href=\"");
      out.print(request.getContextPath());
      out.write("/admin/userManage/userList.jsp\">회원관리</a>\r\n");
      out.write("					</span> \r\n");
      out.write("				</div>\r\n");
      out.write("			</td> \r\n");
      out.write("			<td width=\"20%\">\r\n");
      out.write("			</td> \r\n");
      out.write("		</tr>\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td colspan=\"3\"></td>\r\n");
      out.write("		</tr>\r\n");
      out.write("	</table>\r\n");
      out.write("</header>");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("	#searchUser{\r\n");
      out.write("		margin : auto;\r\n");
      out.write("		text-align: right;\r\n");
      out.write("		width : 70%;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	#orderManage{\r\n");
      out.write("		margin : auto;\r\n");
      out.write("		text-align: center;\r\n");
      out.write("		width : 80%;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#orderManage a:hover{\r\n");
      out.write("		color : #C2674B;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	#orderManage > caption{\r\n");
      out.write("		font-size: 19px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	/* #productManage tr:hover {background-color: #C2674B;} */\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");

	request.setCharacterEncoding("UTF-8");
	String searchId = request.getParameter("searchId");
	
	OrderDao odao = OrderDao.getInstance();
	ArrayList<OrderBean> list = null;
	
	if(searchId == null){
		list = odao.getAllOrder(); 
		System.out.println(list.size() + "개1");
	}else{
		list = odao.getAllOrderById(searchId);
		System.out.println(list.size() + "개2");
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<form name=\"f\" action=\"orderList.jsp\">\r\n");
      out.write("	<table id=\"searchUser\">\r\n");
      out.write("		<tr>\r\n");
      out.write("			<td></td>\r\n");
      out.write("			<td></td>\r\n");
      out.write("			<td>\r\n");
      out.write("				<input type=\"text\" name=\"searchId\" placeholder=\"아이디 입력\">\r\n");
      out.write("				<input type=\"submit\" value=\"검색\">\r\n");
      out.write("			</td>\r\n");
      out.write("		</tr>\r\n");
      out.write("	</table>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<table id=\"orderManage\">\r\n");
      out.write("	<caption>\r\n");
      out.write("		<b>주문접수내역</b>\r\n");
      out.write("		<hr>\r\n");
      out.write("	</caption>\r\n");
      out.write("	<tr>\r\n");
      out.write("		<th>번호</th>\r\n");
      out.write("		<th>주문자ID</th>\r\n");
      out.write("		<th>상품명</th>\r\n");
      out.write("		<th>옵션명</th>\r\n");
      out.write("		<th>단가</th>\r\n");
      out.write("		<th>수량</th>\r\n");
      out.write("		<th>총계</th>\r\n");
      out.write("		<th>배송지</th>\r\n");
      out.write("		<th>수령자명</th>\r\n");
      out.write("		<th>주문시간</th>\r\n");
      out.write("		<th>상품이미지</th>\r\n");
      out.write("	</tr>\r\n");
      out.write("	");

	DecimalFormat decFormat = new DecimalFormat("###,###");
	
	for(OrderBean obean : list){
      out.write("\r\n");
      out.write("	<tr>\r\n");
      out.write("		<td>");
      out.print(obean.getNo());
      out.write("</td>\r\n");
      out.write("		<td>");
      out.print(obean.getId() );
      out.write("</td>\r\n");
      out.write("		<td>");
      out.print(obean.getName() );
      out.write("</td>\r\n");
      out.write("		<td>");
      out.print(obean.getOpname() );
      out.write("</td>\r\n");
      out.write("		<td>");
      out.print(decFormat.format(obean.getPrice()));
      out.write("원</td>\r\n");
      out.write("		<td>");
      out.print(obean.getQty() );
      out.write("</td>\r\n");
      out.write("		<td>");
      out.print(decFormat.format(obean.getQty() * obean.getPrice()));
      out.write("원</td>\r\n");
      out.write("		<td>(");
      out.print(obean.getRv_zip());
      out.write(')');
      out.write(' ');
      out.print(obean.getRv_addr1());
      out.write(' ');
      out.print(obean.getRv_addr2());
      out.write("</td>\r\n");
      out.write("		<td>");
      out.print(obean.getReceiver());
      out.write("</td>\r\n");
      out.write("		<td>");
      out.print(obean.getTime());
      out.write("</td>\r\n");
      out.write("		<td>\r\n");
      out.write("			");

			String fullPath = request.getContextPath() + "/admin/product_images/" + obean.getMainimgn();
			//System.out.println(fullPath);
			
      out.write("\r\n");
      out.write("			<img src=\"");
      out.print(fullPath);
      out.write("\" width=\"50px\" height=\"60px\">\r\n");
      out.write("		</td>\r\n");
      out.write("	</tr>\r\n");
      out.write("	");

	}
      out.write("\r\n");
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
