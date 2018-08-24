package kr.or.nextit.scheduler.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.nextit.notice.service.NoticeService;

@Service("SchedulerNoticeService")
public class SchedulerNoticeServiceImpl implements SchedulerNoticeService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "NoticeService")
	private NoticeService noticeService;

	@Override
	public void getTitle() {
		log.debug(">>> 스프링 스케줄러가 작동 {}", this.getClass().getCanonicalName());
		log.debug(">>> 스프링 스케줄러가 작동 {}.getTitle()", this.getClass().getCanonicalName());
		log.debug(">>> 잘되나요???");
	}

	@Override
	public void setCount() {
		log.info(">>> 공지사항 조회수 증가 ++");

		try {
			noticeService.updateCountTotal();

		} catch (Exception e) {
			e.printStackTrace();
			log.error(">>> 불법: 조회수 올리기 에러... {}", e.getMessage());
		}
	}
}
