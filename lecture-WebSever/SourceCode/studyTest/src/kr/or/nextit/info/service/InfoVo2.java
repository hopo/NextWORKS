package kr.or.nextit.info.service;

import java.util.HashMap;
import java.util.List;

public class InfoVo2 {

	private String userName;
	private String userEmail;

	private String isAdult;
	private String isAdultDisplay;

	private String userSex;
	private String userSexDisplay;

	private String userDate;

	private String[] userHobby;
	private List<HashMap<String, Object>> userHobbyDisplay;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getIsAdult() {
		return isAdult;
	}

	public void setIsAdult(String isAdult) {
		this.isAdult = isAdult;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserDate() {
		return userDate;
	}

	public void setUserDate(String userDate) {
		this.userDate = userDate;
	}

	public String[] getUserHobby() {
		return userHobby;
	}

	public void setUserHobby(String[] userHobby) {
		this.userHobby = userHobby;
	}

	public String getIsAdultDisplay() {
		return isAdultDisplay;
	}

	public void setIsAdultDisplay(String isAdultDisplay) {
		this.isAdultDisplay = isAdultDisplay;
	}

	public String getUserSexDisplay() {
		return userSexDisplay;
	}

	public void setUserSexDisplay(String userSexDisplay) {
		this.userSexDisplay = userSexDisplay;
	}

	public List<HashMap<String, Object>> getUserHobbyDisplay() {
		return userHobbyDisplay;
	}

	public void setUserHobbyDisplay(List<HashMap<String, Object>> userHobbyDisplay) {
		this.userHobbyDisplay = userHobbyDisplay;
	}

}
