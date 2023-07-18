package web.frontController;

public class ViewResolver {
	// 실제 물리적인 경로 얻어오기
	public static String getPath(String viewPage) {
		// welcome to page인 경우
		if(viewPage.equals("index")) {
			return viewPage + ".jsp";
		}
		return "WEB-INF/member/"+viewPage+".jsp";
	}
}
