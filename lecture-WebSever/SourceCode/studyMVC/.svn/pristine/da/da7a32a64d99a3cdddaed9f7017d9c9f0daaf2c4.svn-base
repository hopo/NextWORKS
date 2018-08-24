package kr.or.nextit.json.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.nextit.member.service.MemberVo;

@Controller
public class JsonController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/json/jsonTest")
	public String jsonTest(@RequestParam HashMap<String, Object> params) throws Exception {

		return "json/jsonTest";
	}

	// ;solA) using HashMap (세번째로 많이 이용되는 방법1)
	@RequestMapping(value = "/json/hashMap")
	public @ResponseBody HashMap<String, Object> testHashMap() {

		HashMap<String, Object> item = new HashMap<>();
		item.put("memName", "JJAVA");

		return item;
	}

	// ;solB) using Vo
	@RequestMapping(value = "/json/objectVo")
	public @ResponseBody MemberVo objectVo() {

		MemberVo item = new MemberVo();
		item.setMemName("JJAVA");

		return item;
	}

	// ;solC) using List<> (두번째로 많이 이용된다)
	@RequestMapping(value = "/json/objectList")
	public @ResponseBody List<?> objectList() {

		List<MemberVo> result = new ArrayList<>();
		MemberVo item = new MemberVo();
		item.setMemName("JJAVA");

		result.add(item);

		return result;
	}

	// ;solD) using HashMap<String, Object> (가장 많이 이용되는 방법)
	@RequestMapping(value = "/json/selectList")
	@ResponseBody
	public HashMap<String, Object> selectList() {

		HashMap<String, Object> result = new HashMap<>();

		List<MemberVo> memVo = new ArrayList<>();

		MemberVo item = new MemberVo();

		item.setMemName("JJAVA");
		memVo.add(item);
		memVo.add(item);
		memVo.add(item);

		result.put("result", true);
		result.put("message", "정상처리");
		result.put("resultList", memVo);

		log.debug("result : {}", result);

		return result;
	}

	// ;solD) using ResponseEntity
	@RequestMapping(value = "/json/responseEntity")
	public @ResponseBody ResponseEntity<?> responseEntity() {

		MemberVo result = new MemberVo();
		result.setMemName("Get Out Java!");

		// ;object => string (marshaling)
		return new ResponseEntity<MemberVo>(result, HttpStatus.OK);
	}

	// ;solD-2) using ResponseEntity
	@RequestMapping(value = "/json/responseEntity2")
	public @ResponseBody ResponseEntity<?> responseEntity2() {

		HashMap<String, Object> result = new HashMap<>();
		result.put("memName", "Entity2");

		return new ResponseEntity<HashMap<String, Object>>(result, HttpStatus.OK);
	}

	// ;solD-3) using ResponseEntity (세번째로 많이 이용되는 방법2)
	@RequestMapping(value = "/json/responseEntity3")
	public @ResponseBody ResponseEntity<?> responseEntity3() {

		List<HashMap<String, Object>> result = new ArrayList<>();
		HashMap<String, Object> item = new HashMap<>();
		item.put("memName", "Entity3");

		result.add(item);
		result.add(item);
		result.add(item);

		return new ResponseEntity<List<HashMap<String, Object>>>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/json/attachProc")
	@ResponseBody 
	public HashMap<String, Object> attachProc(
			@RequestParam HashMap<String, Object> params,
			@RequestPart("attachFiles") List<Part> attachPart, HttpServletRequest req, HttpServletResponse resp,
			HttpSession session) throws Exception {

		log.debug("/json/attachProc params : {}", params);
		log.debug("@RequestPart(\"attachFiles\") List<Part> attachPart : {}", attachPart);

		System.out.printf("\n>>> ==================== attachPart ==============================\n");
		log.debug("attachPart.size() : {}\n", attachPart.size());

		for (Part part : attachPart) {
			log.debug("getName(): {}", part.getName());
			log.debug("getContentType(): {}", part.getContentType());
			log.debug("getSize(): {}", part.getSize());
			log.debug("getSubmittedFileName() : {}", part.getSubmittedFileName());
			log.debug("getInputStream(): {}", part.getInputStream());
			log.debug("getHeaderNames(): {}", part.getHeaderNames());
		}

		System.out.printf("\n>>> =============================================================\n");
		
		HashMap<String, Object> result =  new HashMap<>();
		result.put("result", true);
		result.put("messsage", "JeongSang Upload OK ~~~");

		return result;
	}

}
