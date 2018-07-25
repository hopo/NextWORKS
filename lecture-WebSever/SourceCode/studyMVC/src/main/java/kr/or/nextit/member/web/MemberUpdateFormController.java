package kr.or.nextit.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.nextit.com.web.IController;
import kr.or.nextit.member.service.MemberService;
import kr.or.nextit.member.service.MemberVo;
import kr.or.nextit.member.service.impl.MemberServiceImpl;

public class MemberUpdateFormController implements IController {
	
	private MemberService memberService = MemberServiceImpl.getInstance();

	@Override
	public boolean isRedirect() {
		// TODO MemberUpdateFormController.isRedirect()
		return false;
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println(">>> MemberUpdateFormController.process() 콜");

		MemberVo memberVo = new MemberVo();

		String memId = req.getParameter("memId");
		memberVo.setMemId(memId);

		MemberVo result = memberService.selectViewItem(memberVo);

		req.setAttribute("result", result);
		
		return "member/memberUpdateForm";
	}

}
