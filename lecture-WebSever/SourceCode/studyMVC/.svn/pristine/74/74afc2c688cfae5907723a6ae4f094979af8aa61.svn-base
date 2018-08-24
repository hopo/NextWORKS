package kr.or.nextit.notice.service;

import java.util.HashMap;
import java.util.List;

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
	 * 노티스 서비스: 글을 작성
	 * 
	 * @param noticeVo
	 * @throws Exception
	 */
	public void insertItem(NoticeVo noticeVo) throws Exception;

	/**
	 * @param noticeVo
	 * @return
	 * @throws Exception
	 */
	public NoticeVo selectItemView(NoticeVo noticeVo) throws Exception;


}
