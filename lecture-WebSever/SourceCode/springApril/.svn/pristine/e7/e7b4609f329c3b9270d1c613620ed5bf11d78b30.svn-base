package kr.or.nextit.member.web;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.nextit.member.service.MemberService;
import kr.or.nextit.member.service.MemberVo;

@Controller
public class MemberController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "MemberService")
	private MemberService memberService;

	@RequestMapping(value = "/member/memberList")
	public String memberList(HashMap<String, Object> hmap) {

		log.debug(">>> '/member/memebrList'");
		log.debug(">>> HashMap hmap : {}", hmap);

		try {

			List<MemberVo> items = memberService.selectMemberList();
			hmap.put("items", items);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "member/memberList";
	}

	@RequestMapping(value = "/member/memberView")
	public String memberView(@ModelAttribute("memberVo") MemberVo item, HashMap<String, Object> hmap) {
		log.debug(">>> '/member/memberView'");
		log.debug(">>> MemberVo item: {}", item);
		log.debug(">>> HashMap hmap : {}", hmap);

		try {

			item = memberService.selectMemberView(item);
			hmap.put("item", item);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "member/memberView";
	}

	@RequestMapping(value = "/member/memberCreate")
	public String memberCreate() {
		log.debug(">>> '/member/memberCreate'");
		return "member/memberCreate";
	}

	@RequestMapping(value = "/member/memberCreateProc")
	public String memberCreateProc(MemberVo param, HashMap<String, Object> hmap) {

		log.debug(">>> '/member/memberCreateProc'");
		log.debug(">>> memberCreateProc() param : {}", param);

		try {

			memberService.insertMember(param);
			hmap.put("item", param);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "member/memberCreateProc";
	}

	@RequestMapping(value = "/member/memberUpdateProc")
	public String memberUpdateProc(@ModelAttribute("memberVo") MemberVo param) {

		log.debug(">>> '/member/memberUpdateProc'");
		log.debug(">>> memberUpdateProc() param : {}", param);

		try {
			memberService.updateUpMember(param);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "member/memberUpdateProc";
	}

	@RequestMapping(value = "/member/memberDeleteProc")
	public String memberDeleteProc(@ModelAttribute("memberVo") MemberVo param) {

		log.debug(">>> '/member/memberDeleteProc'");
		log.debug(">>> memberDeleteProc() param : {}", param);

		try {
			memberService.updateDelMember(param);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "member/memberDeleteProc";
	}

}
