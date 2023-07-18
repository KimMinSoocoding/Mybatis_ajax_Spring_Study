package web.frontController;

import java.util.HashMap;

import ez.web.controller.Controller;
import ez.web.controller.DelFileController;
import ez.web.controller.DownloadFileController;
import ez.web.controller.FileAttachController;
import ez.web.controller.FindIdPwController;
import ez.web.controller.IdPwController;
import ez.web.controller.MemberAjaxDeleteController;
import ez.web.controller.MemberAjaxListController;
import ez.web.controller.MemberDeleteController;
import ez.web.controller.MemberIdCheckController;
import ez.web.controller.MemberInfoController;
import ez.web.controller.MemberInsertController;
import ez.web.controller.MemberListController;
import ez.web.controller.MemberLoginController;
import ez.web.controller.MemberLogoutController;
import ez.web.controller.MemberRegisterController;
import ez.web.controller.MemberUpdateController;

public class HandlerMapping {
	private HashMap<String, Controller> handlerMaps;
	
	public HandlerMapping() {
								  // 키(key),  값(value)
		handlerMaps = new HashMap<String, Controller>();
		
		handlerMaps.put("/memberList.do", new MemberListController());
		handlerMaps.put("/memberInsert.do", new MemberInsertController());
		handlerMaps.put("/memberRegister.do", new MemberRegisterController());
		handlerMaps.put("/memberInfo.do", new MemberInfoController());
		handlerMaps.put("/memberUpdate.do", new MemberUpdateController());
		handlerMaps.put("/memberDel.do", new MemberDeleteController());
		handlerMaps.put("/memberLogin.do", new MemberLoginController());
		handlerMaps.put("/memberLogout.do", new MemberLogoutController());
		
		handlerMaps.put("/memberIdCheck.do", new MemberIdCheckController());
		handlerMaps.put("/memberAjaxList.do", new MemberAjaxListController());
		handlerMaps.put("/memberAjaxDelete.do", new MemberAjaxDeleteController());
		
		handlerMaps.put("/fileAttach.do", new FileAttachController());
		handlerMaps.put("/delFile.do", new DelFileController());
		handlerMaps.put("/downloadFile.do", new DownloadFileController());
		handlerMaps.put("/idpw.do", new IdPwController());
		handlerMaps.put("/findIdPw.do", new FindIdPwController());
	}
	
	public Controller getController(String key) {
		return handlerMaps.get(key);
	}
}







