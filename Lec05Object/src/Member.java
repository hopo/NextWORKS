
public class Member {
	
	// 회원 정보를 위한 필드선언
	private String name;
	private int age;
	private char gender;
	private String phone;

	// private 인스턴스 필드들의 getter and setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age < 0 || age > 120) {
			age = -1;	// input error
		}
		this.age = age;
	}

	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		if(gender == 'm' || gender == 'f') {
			gender = '-'; // input error
		}
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
