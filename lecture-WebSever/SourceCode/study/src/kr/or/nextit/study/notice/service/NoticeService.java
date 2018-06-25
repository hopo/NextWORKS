package kr.or.nextit.study.notice.service;

public interface NoticeService {
	
	public NoticeVo setNoticeItem(String title, String isOpen, String[] serviceType, String regUser, String text);

}
