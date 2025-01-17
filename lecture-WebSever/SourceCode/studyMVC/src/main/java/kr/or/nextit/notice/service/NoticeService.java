package kr.or.nextit.notice.service;

import java.util.List;

import javax.servlet.http.Part;

public interface NoticeService {

	/**
	 * 노티스 서비스: 노티스 리스트
	 * 
	 * @param noticeSearchVo
	 * @return
	 * @throws Exception
	 */
	public List<NoticeVo> selectNoticeList(NoticeSearchVo noticeSearchVo) throws Exception;

	/**
	 * 노티스 서비스: 토탈 갯수
	 * 
	 * @param noticeSearchVo
	 * @return
	 * @throws Exception
	 */
	public int selectTotalCount(NoticeSearchVo params) throws Exception;

	/**
	 * 노티스 서비스: 글을 작성(첨부파일 포함)
	 * 
	 * @param noticeVo
	 * @param attachPart
	 * @throws Exception
	 */
	public void insertItem(NoticeVo noticeVo, List<Part> attachPart) throws Exception;

	/**
	 * @param noticeVo
	 * @return
	 * @throws Exception
	 */
	public NoticeVo selectItemView(NoticeVo noticeVo) throws Exception;

	/**
	 * @throws Exception
	 */
	public void updateCountTotal() throws Exception;

}
