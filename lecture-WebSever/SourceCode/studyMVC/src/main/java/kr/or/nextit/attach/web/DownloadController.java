package kr.or.nextit.attach.web;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.nextit.attach.service.AttachService;
import kr.or.nextit.attach.service.AttachVo;

@Controller
@RequestMapping(value = "/attach")
public class DownloadController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	// === messageSource 관련 ======
	// ;;참조 messageSource-context.xml
	@Resource(name = "messageSource")
	private MessageSource messageSource;

	@Resource(name = "propertyService")
	private Properties propertiesService;
	// =============================

	@Autowired
	private AttachService attachService;

	@RequestMapping(value = "/testAttach")
	public String testAttach(Model model) throws Exception {

		List<AttachVo> result = attachService.selectItems(new AttachVo());
		model.addAttribute("result", result);

		return "attach/testAttachForm";
	}

	@RequestMapping(value = "/download/{fileId}")
	public void downloadFile(ModelAndView modelAndView, @RequestParam HashMap<String, Object> params,
			@PathVariable("fileId") String fileId, HttpServletRequest req, HttpServletResponse resp) throws Exception {

		log.debug("fileId = {}", fileId);
		log.debug("params = {}", params);

		params.put("fileId", fileId);
		AttachVo item = attachService.selectDownloadItem(params);

		String fileUploadPath = propertiesService.getProperty("file.upload.path");

		StringBuilder path = new StringBuilder();
		path.append(fileUploadPath);
		path.append(File.separator);
		path.append(item.getFileSavePath());
		path.append(File.separator);
		path.append(item.getFileSaveFileName());

		log.debug("downloadFile path : {}", path.toString());

		byte[] fileByte = FileUtils.readFileToByteArray(new File(path.toString()));

		resp.setContentType("application/octet-stream");
		resp.setContentLength(fileByte.length);

		resp.setHeader("Content-Dispostion",
				"attachment; fileName=\"" + URLEncoder.encode(item.getFileOriginalFileName(), "UTF-8") + "\";");

		resp.setHeader("Content-Transfer-Encoding", "binary");
		resp.getOutputStream().write(fileByte);

		resp.getOutputStream().flush();
		resp.getOutputStream().close();

		item.getFileSavePath();

	}

}
