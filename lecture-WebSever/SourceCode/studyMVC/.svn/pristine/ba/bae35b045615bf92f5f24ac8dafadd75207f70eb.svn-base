package kr.or.nextit.attach.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Part;

import org.springframework.web.multipart.MultipartFile;

public interface AttachService {

	/**
	 * 어태치 서비스 : 첨부파일 저장 using Part
	 * 
	 * @param params
	 * @param memId
	 * @return
	 * @throws Exception
	 */
	public List<AttachVo> insertItemsPart(List<Part> params, String memId) throws Exception;

	/**
	 * 어태치 서비스 : 첨부파일 저장 using MultipartFile
	 * 
	 * @param params
	 * @param memId
	 * @return
	 * @throws Exception
	 */
	public List<AttachVo> insertItemsMulitpart(List<MultipartFile> params, String memId) throws Exception;

	/**
	 * 어태치 서비스 : 아이템즈 조회
	 * 
	 * @param attachVo
	 * @return
	 * @throws Exception
	 */
	public List<AttachVo> selectItems(AttachVo attachVo) throws Exception;

	/**
	 * 어태치 서비스 : 다운로드 아이템 조회
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public AttachVo selectDownloadItem(HashMap<String, Object> params) throws Exception;

}
