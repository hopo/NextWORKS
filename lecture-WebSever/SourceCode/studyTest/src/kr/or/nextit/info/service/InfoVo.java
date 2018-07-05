package kr.or.nextit.info.service;

public class InfoVo {
	
	private String username;
	private String email;
	private String adult;
	private String gender;
	private String byear;
	private String bmonth;
	private String bday;
	private String[] hobs;

	private boolean result;
	private String message;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdult() {
		return adult;
	}
	public void setAdult(String adult) {
		this.adult = adult;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getByear() {
		return byear;
	}
	public void setByear(String byear) {
		this.byear = byear;
	}
	public String getBmonth() {
		return bmonth;
	}
	public void setBmonth(String bmonth) {
		this.bmonth = bmonth;
	}
	public String getBday() {
		return bday;
	}
	public void setBday(String bday) {
		this.bday = bday;
	}
	public String[] getHobs() {
		return hobs;
	}
	public void setHobs(String[] hobs) {
		this.hobs = hobs;
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

}
