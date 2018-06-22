package kr.or.nextit.study.notice.service;

public class NoticeVo {

	// =============================================
	// private fields
	// =============================================
	private String title;
	
	private String isOpen;
	private String isOpenDisplay;

	private String[] serviceType;
	private String serviceTypeDisplay;

	private String regUser;
	private String text;

	private boolean result;
	private String message;


	// =============================================
	// title / isOpen / isOpenDisplay / serviceType / serviceTypeDisplay / regUser / text
	// getter setter methods
	// =============================================
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}
	
	
	// ! IsOpenDisplay
	public String getIsOpenDisplay() {
		return isOpenDisplay;
	}
	public void setIsOpenDisplay(String isOpenDisplay) {
		this.isOpenDisplay = isOpenDisplay;
	}

	public String[] getServiceType() {
		return serviceType;
	}
	public void setServiceType(String[] serviceType) {
		this.serviceType = serviceType;
	}

	// ! ServiceTypeDisplay
	public String getServiceTypeDisplay() {
		return serviceTypeDisplay;
	}
	public void setServiceTypeDisplay(String serviceTypeDisplay) {
		this.serviceTypeDisplay = serviceTypeDisplay;
	}

	public String getRegUser() {
		return regUser;
	}
	public void setRegUser(String regUser) {
		this.regUser = regUser;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	// ========================================
	// result / message
	// getter setter methods
	// ========================================
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
