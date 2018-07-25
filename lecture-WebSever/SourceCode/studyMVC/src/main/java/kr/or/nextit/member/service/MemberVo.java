package kr.or.nextit.member.service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

@SuppressWarnings("serial")
public class MemberVo implements Serializable {

	private String memId;
	private String memPwd;
	private String memName;
	private String memPhone;
	private String memEmail;
	private String regDate;
	private String memIp;
	private String delAt;

	private boolean result;
	private String message;

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPwd() {
		return memPwd;
	}

	public void setMemPwd(String memPwd) {
		this.memPwd = memPwd;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getMemIp() {
		return memIp;
	}

	public void setMemIp(String memIp) {
		this.memIp = memIp;
	}

	public String getDelAt() {
		return delAt;
	}

	public void setDelAt(String delAt) {
		this.delAt = delAt;
	}

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

	@Override
	public String toString() {
		// ; Object를 String 타입으로 변환하는 기능
		return ToStringBuilder.reflectionToString(this);
	}

}
