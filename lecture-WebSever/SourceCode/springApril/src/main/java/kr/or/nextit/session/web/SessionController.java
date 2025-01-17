package kr.or.nextit.session.web;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.nextit.member.service.MemberVo;
import kr.or.nextit.session.serivce.SessionService;

@Controller
public class SessionController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "SessionService")
	private SessionService sessionService;

	@RequestMapping(value = "/session/login")
	public String login(
			HttpSession session
		) {
		log.debug(">>> '/session/login'");
		
		if(session.getAttribute("loginInfo") != null) {
			return "session/loginInfo";
		}
		
		return "session/login";
	}

	@RequestMapping(value = "/session/loginProc")
	public String loginProc(
			@ModelAttribute("memberVo") MemberVo param,
			HttpSession session
		) {

		log.debug(">>> '/session/loginProc'");
		log.debug(">>> param: {}", param);

		try {

			MemberVo loginInfo = sessionService.loginCheck(param);
			session.setAttribute("loginInfo", loginInfo);

			log.debug(">>> loginInfo: {}", loginInfo);
			log.debug(">>> loginInfo memName: {}", loginInfo.getMemName());
			
			return "redirect:/home";

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("loginInfo", null);

			return "member/memberCreate";
		}

	}

	@RequestMapping(value = "/session/logout")
	public String logout(HttpSession session) {
		log.debug(">>> '/session/logout'");
		session.invalidate();

		return "redirect:/home";
	}

	@RequestMapping(value = "/session/loginInfo")
	public String loginInfo() {
		log.debug(">>> '/session/loginInfo'");
		return "session/loginInfo";
	}

}