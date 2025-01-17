package kr.or.nextit.session.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value = { "/session" })
public class LogoutController {

	@RequestMapping(value = { "/logout" })
	public ModelAndView logoutProc(HttpSession session, HttpServletRequest req, HttpServletResponse resp) {

		// MemberVo loginInfo = (MemberVo) session.getAttribute("loginInfo");

		// if (loginInfo != null) {
		// if (loginInfo.isResult()) {
		// ;;세가지 중 하나로 login된 session를 삭제한다
		// session.setAttribute("loginInfo", null);
		// session.removeAttribute("loginInfo");
		// session.invalidate();
		// }
		// }

		session.invalidate();

		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/index");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(redirectView);

		System.err.printf(">>> %s 페이지에서 처리\n", req.getHeader("Referer"));

		return modelAndView;
	}

}
