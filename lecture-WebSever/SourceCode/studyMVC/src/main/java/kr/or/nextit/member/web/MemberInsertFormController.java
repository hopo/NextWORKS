package kr.or.nextit.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.nextit.com.web.IController;

public class MemberInsertFormController implements IController {
	@Override
	public boolean isRedirect() {
		// TODO MemberInsertFormController.isRedirect()
		return false;
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println(">>> MemberInsertFormController.process() 콜");

		return "member/memberInsertForm";
	}

}
