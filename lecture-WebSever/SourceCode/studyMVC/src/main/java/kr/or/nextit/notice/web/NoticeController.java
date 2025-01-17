package kr.or.nextit.notice.web;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.ModelAndView;

import kr.or.nextit.member.service.MemberVo;
import kr.or.nextit.notice.service.NoticeSearchVo;
import kr.or.nextit.notice.service.NoticeService;
import kr.or.nextit.notice.service.NoticeVo;
import kr.or.nextit.session.web.LoginController;

@Controller
@RequestMapping(value = { "/notice" })
public class NoticeController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Resource(name = "NoticeService")
	private NoticeService noticeService;

	/**
	 * 노티스컨트롤러: 공지사항 리스트
	 * 
	 * @param model
	 * @param modelMap
	 * @param params
	 * @param noticeSearchVo
	 * @return
	 */
	@RequestMapping(value = { "/noticeList" })
	public String noticeList(Model model, ModelMap modelMap, @RequestParam HashMap<String, Object> params,
			@ModelAttribute(name = "noticeSearchVo") NoticeSearchVo noticeSearchVo) {

		// ;;;Model ModelMap은 같은 거라 하나만 사용해도 된다

		log.debug("params {}", params);
		log.debug("noticeSearchVo {}", noticeSearchVo);

		try {

			noticeSearchVo.setTotalCount(noticeService.selectTotalCount(noticeSearchVo));
			noticeSearchVo.setPageBlockSize(3);
			noticeSearchVo.setScreenSize(5);
			noticeSearchVo.pageSetting();

			List<NoticeVo> result = noticeService.selectNoticeList(noticeSearchVo);
			model.addAttribute("result", result);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return "notice/noticeList";
	}

	/**
	 * 노티스컨트롤러: 공지사항 작성
	 * 
	 * @param model
	 * @param modelMap
	 * @param params
	 * @param noticeSearchVo
	 * @return
	 */
	@RequestMapping(value = { "/noticeForm" })
	public String noticeForm(Model model, ModelMap modelMap, @RequestParam HashMap<String, Object> params,
			@ModelAttribute("noticeSearchVo") NoticeSearchVo noticeSearchVo,
			@ModelAttribute("noticeVo") NoticeVo noticeVo, HttpSession session) {

		MemberVo loginInfo = (MemberVo) session.getAttribute("loginInfo");

		noticeVo.setRegUser(loginInfo.getMemName());

		return "notice/noticeForm";
	}

	/**
	 * 노티스컨트롤러: 공지사항 작성 Proc
	 * 
	 * @param model
	 * @param modelMap
	 * @param params
	 * @param noticeSearchVo
	 * @param noticeVo
	 * @param session
	 * @return
	 */
	@RequestMapping(value = { "/noticeProc" })
	public String noticeProc(Model model, ModelMap modelMap, @RequestParam HashMap<String, Object> params,
			@RequestPart("attachFiles") List<Part> attachPart,
			@ModelAttribute("noticeSearchVo") NoticeSearchVo noticeSearchVo,
			@ModelAttribute("noticeVo") NoticeVo noticeVo, HttpSession session) {

		try {

			log.debug("attachPart.size() : {}\n", attachPart.size());
			for (Part part : attachPart) {
				log.debug("part.getName() : {}", part.getName());
				log.debug("part.getContentType() : {}", part.getContentType());
				log.debug("part.getSize() : {}", part.getSize());
				log.debug("part.getSubmittedFileName() : {}", part.getSubmittedFileName());
				log.debug("part.getInputStream() : {}", part.getInputStream());
				log.debug("part.getHeaderNames() : {}", part.getHeaderNames());
			}

			noticeService.insertItem(noticeVo, attachPart);

			// ;attach 합치기 전 코드. 아래 2line
			// noticeService.insertItem(noticeVo);

			//return "/notice/noticeForm";
			return "redirect:/notice/noticeList";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/notice/noticeForm";
	}

	/**
	 * 노티스컨트롤러: 노티스 뷰
	 * 
	 * @param model
	 * @param modelMap
	 * @param params
	 * @param noticeSearchVo
	 * @return
	 */
	@RequestMapping(value = { "/noticeView" })
	public ModelAndView noticeView(ModelAndView modelAndView, @ModelAttribute("noticeVo") NoticeVo noticeVo,
			@RequestParam HashMap<String, Object> hashMap) {

		log.debug("HashMap {}", hashMap);
		log.debug("NoticeVo {}", noticeVo);

		modelAndView.setViewName("notice/noticeView");

		try {

			noticeVo = noticeService.selectItemView(noticeVo);
			modelAndView.addObject(noticeVo);
			modelAndView.addObject("noticeVo", noticeVo);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;
	}

}
