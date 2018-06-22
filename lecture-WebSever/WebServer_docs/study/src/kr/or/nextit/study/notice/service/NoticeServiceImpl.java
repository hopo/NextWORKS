package kr.or.nextit.study.notice.service;

public class NoticeServiceImpl implements NoticeService {

	@Override
	public NoticeVo setNoticeItem(String title, String isOpen, String[] serviceType, String regUser, String text) {
		// TODO NoticeVo Result Return
		
		NoticeVo result = new NoticeVo();

		NoticeUtils util = new NoticeUtils();
		
		try {
			// ;;display를 위한 필드 구현하지 않은 것: regUser
			result.setTitle(title);

			result.setIsOpen(isOpen);
			String ioDisplay = util.isOpenDisplay(isOpen);
			result.setIsOpenDisplay(ioDisplay);
			
			result.setServiceType(serviceType);
			String stDisplay = util.serviceTypeDisplay(serviceType);
			result.setServiceTypeDisplay(stDisplay);

			result.setRegUser(regUser);
			result.setText(text);
			
			result.setResult(true);
			result.setMessage("정상 처리 되었다.");
			
		} catch (Exception e) {
			result.setResult(false);
			result.setMessage(e.getMessage());

			e.printStackTrace();
		}

		return result;
	}
	
	/*
	private String getServiceDisplay(String[] serviceType) {
		StringBuilder result = new StringBuilder();
		
		for (String type : serviceType) {
			result.append(String.format("%s, ", type));
		}

		return result.toString();
	}
	*/

}
