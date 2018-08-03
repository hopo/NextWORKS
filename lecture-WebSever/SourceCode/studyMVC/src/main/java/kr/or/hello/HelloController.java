package kr.or.hello;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.nextit.member.service.MemberVo;

@Controller
@RequestMapping(value = { "/test", "/hello" })
public class HelloController {

	@RequestMapping(value = { "/hello" })
	public String hello() {

		return "hello";
	}

	@RequestMapping(value = { "hello2" })
	public ModelAndView hello2(@RequestParam Map<String, Object> params, HttpServletRequest req,
			HttpServletResponse resp, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();

		// String viewName = (String) params.get("viewName");

		modelAndView.setViewName("hello");
		modelAndView.addObject("key", "hello2를 호출 하였다");
		modelAndView.addObject("title", "공지사항");

		System.out.println(req.getSession().getId());
		System.out.println(session.getId());

		return modelAndView;
	}

	@RequestMapping(value = { "hello3" })
	public ModelAndView hello3(ModelMap modelMap, Model model, @RequestParam Map<String, Object> paramsMap,
			@RequestParam HashMap<String, Object> paramsHashMap, @ModelAttribute MemberVo memberVo,
			ModelAndView modelAndView) {

		modelAndView.setViewName("hello");
		modelAndView.addObject("title", "자료실");
		modelAndView.addObject("key", "hello3를 호출 하였다");

		Map<String, Object> models = modelAndView.getModel();
		ModelMap modelMaps = modelAndView.getModelMap();

		System.out.printf(">>> paramsMap : %s\n", paramsMap);
		System.out.printf(">>> paramsHashMap : %s\n", paramsHashMap);
		System.out.printf(">>> memberVo : %s\n", memberVo);

		return modelAndView;
	}

}
