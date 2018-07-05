package kr.or.nextit.nextit.member.service;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MemberVo implements Serializable {

	private String memId;
	private String memPwd;
	private String memName;
	private String memPhone;
	private String memEmail;
	private String regDate;
	private String memIp;
	
	
	/* Constructor */
	public MemberVo(String memId) {
		this.memId = memId;
	}
	public MemberVo(String memId, String memName) {
		this.memId = memId;
		this.memName = memName;
	}
	public MemberVo(String memId, String memName, String memEmail) {
		this.memId = memId;
		this.memName = memName;
		this.memEmail = memEmail;
	}

	/* Getter and Setter */
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

}
