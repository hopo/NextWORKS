package kr.or.nextit.main.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.nextit.main.service.HomeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private final Logger log = LoggerFactory.getLogger(HomeController.class);

	@Resource(name = "HomeService")
	private HomeService homeService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(
			Locale locale,
			Model model,
			@RequestParam HashMap<String, Object> params
		) throws Exception {
		log.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		
		/*
		for(HashMap<String, Object> hashMap : items) {
			log.debug("each item {}: ", hashMap);
		}
		*/

		return "home";
	}
	
	@RequestMapping(value="/viewItems")
	public String viewItems(
			@RequestParam HashMap<String, Object> params,
			Model model
		)  throws Exception {
		List<HashMap<String, Object>> items = homeService.selectItems(params);
		model.addAttribute("list", items);
		
		return "viewItems";
	}
	
	@RequestMapping(value="/jsonResult")
	@ResponseBody
	public HashMap<String, Object> jsonResult(
			@RequestParam HashMap<String, Object> params
		) throws Exception {
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		List<HashMap<String, Object>> items = homeService.selectItems(params);

		result.put("list", items);
		result.put("result", true);
		result.put("message", "정상 조회 OK~~~");

		
		return result;
	}
}