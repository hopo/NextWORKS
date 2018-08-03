package kr.or.nextit.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.nextit.com.web.IController;
import kr.or.nextit.member.service.MemberService;
import kr.or.nextit.member.service.MemberVo;
import kr.or.nextit.member.service.impl.MemberServiceImpl;

public class MemberDeleteFormController implements IController {
	
	private MemberService memberService = MemberServiceImpl.getInstance();
	
	@Override
	public boolean isRedirect() {
		// TODO MemberDeleteFormController.isRedirect()
		return false;
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		MemberVo params = new MemberVo();
		
		params.setMemId(req.getParameter("memId"));
		
		MemberVo result = memberService.selectViewItem(params);
	
		req.setAttribute("result", result);
		
		return "member/memberDeleteForm";
	}

}
