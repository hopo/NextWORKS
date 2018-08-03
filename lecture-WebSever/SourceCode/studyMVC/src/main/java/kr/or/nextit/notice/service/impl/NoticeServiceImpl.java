package kr.or.nextit.notice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.notice.service.NoticeSearchVo;
import kr.or.nextit.notice.service.NoticeService;
import kr.or.nextit.notice.service.NoticeVo;

@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;

	@Override
	public List<NoticeVo> selectNoticeList(NoticeSearchVo noticeSearchVo) throws Exception {
		return noticeMapper.selectNoticeList(noticeSearchVo);
	}

	@Override
	public int selectTotalCount(NoticeSearchVo params) throws Exception {
		return noticeMapper.selectTotalCount(params);
	}

	@Override
	public void insertItem(NoticeVo noticeVo) throws Exception {
		try {

			noticeMapper.insertItem(noticeVo);

		} catch (Exception e) {
			throw new Exception(String.format(">>> 데이터베이스 에러 : %s\n", e.getMessage()));
		}
	}

	@Override
	public NoticeVo selectItemView(NoticeVo noticeVo) throws Exception {
		
		noticeMapper.updateItemViewCount(noticeVo);

		return noticeMapper.selectItemView(noticeVo);
	}
}
