package kr.or.nextit.notice.service.impl;

import java.util.List;

import kr.or.nextit.notice.service.NoticeSearchVo;
import kr.or.nextit.notice.service.NoticeVo;

public interface NoticeMapper {

	/**
	 * 노티스 매퍼: 목록
	 * 
	 * @param noticeSearchVo
	 * @return
	 * @throws Exception
	 */
	public List<NoticeVo> selectNoticeList(NoticeSearchVo noticeSearchVo) throws Exception;

	/**
	 * 노티스 매퍼: 토탈 카운트
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public int selectTotalCount(NoticeSearchVo params) throws Exception;

	/**
	 * 노티스 매퍼: 글 등록
	 * 
	 * @param noticeVo
	 * @throws Exception
	 */
	public void insertItem(NoticeVo noticeVo) throws Exception;

	/**
	 * 노티스 매퍼: 글 하나 보기
	 * 
	 * @param noticeVo
	 * @return
	 * @throws Exception
	 */
	public NoticeVo selectItemView(NoticeVo noticeVo) throws Exception;

	/**
	 * 노티스 매퍼: 조회 수
	 * 
	 * @param noticeVo
	 * @throws Exception
	 */
	public void updateItemViewCount(NoticeVo noticeVo) throws Exception;

}
