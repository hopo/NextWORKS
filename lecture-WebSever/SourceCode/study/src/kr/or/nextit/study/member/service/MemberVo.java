package kr.or.nextit.study.member.service;

// member Value Object
public class MemberVo {

	private String id;
	private String name;
	private String gender;
	private int age;
	private String hp;
	private String post;
	private String addr;
	
	private String[] flag;
	private String flagDisplay;
	private String flag2;
	
	private String message;
	private boolean result;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}

	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String[] getFlag() {
		return flag;
	}
	public void setFlag(String[] flag) {
		this.flag = flag;
	}

	public String getFlag2() {
		return flag2;
	}
	public void setFlag2(String flag2) {
		this.flag2 = flag2;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	
	public String getFlagDisplay() {
		return flagDisplay;
	}
	public void setFlagDisplay(String flagDisplay) {
		this.flagDisplay = flagDisplay;
	}
	
}
