package kr.or.nextit.attach.web;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.nextit.attach.service.AttachService;
import kr.or.nextit.attach.service.AttachVo;
import kr.or.nextit.member.service.MemberVo;

@Controller
public class AttachController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "AttachService")
	private AttachService attachService;

	/**
	 * 어태치컨트롤러 : 어태치Form
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = { "/attach/attachForm" })
	public String attachForm(@RequestParam HashMap<String, Object> params) {

		log.debug("params {}", params);

		return "attach/attachForm";
	}

	/**
	 * 어태치컨트롤러 : 어태치Proc
	 * 
	 * @param params
	 * @param attachFiles
	 * @param attachPart
	 * @param req
	 * @param resp
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = { "/attach/attachProc" })
	public String attachProc(@RequestParam HashMap<String, Object> params,
			@RequestParam("attachFiles") List<MultipartFile> attachFiles,
			@RequestPart("attachFiles") List<Part> attachPart, HttpServletRequest req, HttpServletResponse resp,
			HttpSession session) throws Exception {

		String realPath = req.getServletContext().getRealPath("uploadTempDir");
		log.debug(">>> realPath : {}", realPath);
		log.debug(">>> 첨부 파일 처리 attachProc params : {}", params);

		// // ;solA) 파일 첨부시 받아오는 정보들 List<Part>
		// log.debug("@RequestPart(\"attachFiles\") List<Part> attachPart : {}",
		// attachPart);
		// System.out.println("\n>>> ======== List<Part> attachPart ==================");
		// log.debug("attachPart.size() : {}\n", attachPart.size());
		//
		// for (Part part : attachPart) {
		// System.out.println();
		//
		// log.debug("getName() : {}", part.getName());
		// log.debug("getContentType() : {}", part.getContentType());
		// log.debug("getSize() : {}", part.getSize());
		// log.debug("getSubmittedFileName() : {}", part.getSubmittedFileName());
		// log.debug("getInputStream() : {}", part.getInputStream());
		// log.debug("getHeaderNames() : {}", part.getHeaderNames());
		//
		// Collection<String> headers = part.getHeaderNames();
		//
		// for (String name : headers) {
		// log.debug(" | {} : {}", name, part.getHeader(name));
		// }
		//
		// // ;저장할 경로와 저장할 파일 명을 작성
		// // String saveFielName = part.getSubmittedFileName();
		//
		// // String saveFielPath = "/home/pc33/uploadTempDir";
		// // String saveFielPath =
		// // "/home/pc33/eclipse-workspace/studyMVC/src/main/webapp/uploadTempDir/";
		//
		// // ;os file separator
		// System.out.println(File.separator);
		// System.out.println(File.separatorChar);
		//
		// StringBuilder savePath = new StringBuilder();
		// savePath.append("/home/pc33/eclipse-workspace/studyMVC/src/main/webapp/uploadTempDir");
		// savePath.append(File.separator);
		// savePath.append(part.getSubmittedFileName());
		//
		// // File file = new File(String.format("%s%s", realPath, saveFielName));
		// File file = new File(savePath.toString());
		//
		// log.debug("file.getPath() : {}", file.getPath());
		//
		// FileUtils.copyToFile(part.getInputStream(), file);
		//
		// // file.delete();
		//
		// }
		// System.out.println("\n>>> ================================================\n");

		// ;solB) 파일 첨부시 받아오는 정보들02 List<MultipartFile>
		log.debug("@RequestParam(\"attachFiles\") List<MultipartFile> : {}", attachFiles);
		System.out.println("\n>>> ================ List<MultipartFile> attachFiles ==========================");
		log.debug("attachFiles.size() : {}\n", attachFiles.size());

		for (MultipartFile multipartFile : attachFiles) {
			System.out.println();

			log.debug("getName() : {}", multipartFile.getName());
			log.debug("getContentType() : {}", multipartFile.getContentType());
			log.debug("getSize() : {}", multipartFile.getSize());
			log.debug("getOriginalFilename() : {}", multipartFile.getOriginalFilename());
			log.debug("getInputStream() : {}", multipartFile.getInputStream());

		}
		System.out.println("\n>>> =================================================================\n");

		
		// ;===== 공통영역 =====
		MemberVo loginInfo = (MemberVo) session.getAttribute("loginInfo");

		String loginId = "";

		if (loginInfo == null) {
			loginId = "guest";
		} else {
			loginId = loginInfo.getMemId();
		}
		log.debug(">>> /attach/attachProc loginId: {}", loginId);

		List<AttachVo> attachItems = attachService.insertItemsMulitpart(attachFiles, loginId);
		for (AttachVo attachVo : attachItems) {
			log.debug("attachVo {}", attachVo);
		}
		// ;====================

		return "attach/attachForm";
	}

}
