package kr.or.nextit.mber.web;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.nextit.mber.service.MberService;
import kr.or.nextit.member.service.MemberSearchVo;
import kr.or.nextit.member.service.MemberVo;

@Controller
public class MberController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "MberService")
	private MberService mberService;

	@RequestMapping(value = "/mber/memberListForm")
	public String memberListForm(
			@RequestParam HashMap<String, Object> params,
			@ModelAttribute(name = "memberSearchVo") MemberSearchVo memberSearchVo
		) {

		return "mber/mberListForm";
	}

	@RequestMapping(value = "/mber/memberListProc")
	@ResponseBody 
	public HashMap<String, Object> memberList(
			@RequestParam HashMap<String, Object> params,
			@ModelAttribute(name = "memberSearchVo") MemberSearchVo memberSearchVo
		) throws Exception {

		HashMap<String, Object> result = new HashMap<>();

		memberSearchVo.setTotalCount(mberService.selectTotalCount(memberSearchVo));
		memberSearchVo.setPageBlockSize(10);
		memberSearchVo.setScreenSize(10);
		memberSearchVo.pageSetting();

		List<MemberVo> items = mberService.selectMemberList(memberSearchVo);		

		result.put("result", true);
		result.put("message", "개발중...");
		result.put("list", items);
		result.put("search", memberSearchVo);

		return result;
	}

	@RequestMapping(value = "/mber/joinMberForm")
	public String joinMberForm(@RequestParam HashMap<String, Object> params, Model model) throws Exception {

		log.debug(">>> 회원가입시작~");

		return "mber/joinMber";
	}

	@RequestMapping(value = "/mber/joinMberProc")
	@ResponseBody
	public MemberVo joinMberProc(
			@ModelAttribute MemberVo params,
			@RequestPart("attachFiles") List<Part> attachPart,
			Model model
		) throws Exception {

		MemberVo result = new MemberVo();
		result.setMessage("*** 개발중 입니다...");

		log.debug(">>> joinMberProc params: {}", params);

		for (Part part : attachPart) {
			log.debug("getName() : {}", part.getName());
			log.debug("getContentType() : {}", part.getContentType());
			log.debug("getSize() : {}", part.getSize());
			log.debug("getSubmittedFileName() : {}", part.getSubmittedFileName());
			log.debug("getInputStream() : {}", part.getInputStream());
			log.debug("getHeaderNames() : {}", part.getHeaderNames());
		}

		result = mberService.insertMemberItem(params, attachPart);

		return result;

	}

	@RequestMapping(value = "/mber/joinIdCheck")
	@ResponseBody 
	public HashMap<String, Object> joinIdCheck(@ModelAttribute MemberVo params, Model model)
			throws Exception {

		log.debug(">>> joinIdCheck params: {}", params);

		HashMap<String, Object> result = new HashMap<>();

		if ("".equals(params.getMemId())) {

			result.put("result", false);
			result.put("message", "아이디가 입력 되지 않았다");

		} else {

			MemberVo item = mberService.joinIdCheck(params);
			log.debug(">>> joinIdCheck.getMessage: {}", item.getMessage());
			result.put("result", item.isResult());
			result.put("message", item.getMessage());
		}

		return result;
	}

}
