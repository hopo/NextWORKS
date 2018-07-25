package kr.or.nextit.member.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.nextit.com.web.IController;
import kr.or.nextit.member.service.MemberService;
import kr.or.nextit.member.service.MemberVo;
import kr.or.nextit.member.service.impl.MemberServiceImpl;

public class MemberListController implements IController {

	private MemberService memberService = MemberServiceImpl.getInstance();

	@Override
	public boolean isRedirect() {
		// TODO MemberListController.isRedirect()
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		System.out.println(">>> MemberListController.process() 콜");

		MemberVo params = new MemberVo();
		List<MemberVo> result = memberService.selectItems(params);

		req.setAttribute("result", result);

		return "member/memberList";
	}

}
