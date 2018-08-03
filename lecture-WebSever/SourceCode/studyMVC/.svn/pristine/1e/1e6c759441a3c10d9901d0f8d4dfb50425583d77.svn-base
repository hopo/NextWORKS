package kr.or.nextit.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.nextit.com.web.IController;
import kr.or.nextit.member.service.MemberService;
import kr.or.nextit.member.service.MemberVo;
import kr.or.nextit.member.service.impl.MemberServiceImpl;

public class MemberProcController implements IController {

	private MemberService memberService = MemberServiceImpl.getInstance();

	@Override
	public boolean isRedirect() {
		// TODO memberProcController.isRedirect()
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO CRUD 미구현

		System.err.println(">>> MemberProcController.process() 콜");

		String flag = req.getParameter("flag");

		MemberVo params = new MemberVo();

		params.setMemId(req.getParameter("memId"));
		params.setMemPwd(req.getParameter("memPwd"));
		params.setMemName(req.getParameter("memName"));
		params.setMemPhone(req.getParameter("memPhone"));
		params.setMemEmail(req.getParameter("memEmail"));
		params.setDelAt(req.getParameter("delAt"));
		params.setMemIp(req.getRemoteAddr());

		// ; flag에 "insert" | "update" 여부
		if ("insert".equals(flag)) {

			System.out.println(">>> \"insert\"");

			MemberVo result = memberService.insertItem(params);
			req.setAttribute("result", result);

		} else if ("update".equals(flag)) {

			System.out.println(">>>  \"update\"");

			MemberVo result = memberService.updateItem(params);
			req.setAttribute("result", result);

		} else if ("delete".equals(flag)) {

			System.out.println(">>> \"delete\"");

			MemberVo result = memberService.deleteItem(params);
			req.setAttribute("result", result);

		}

		return "member/memberProc";
	}

}
