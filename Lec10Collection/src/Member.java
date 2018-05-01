
// sensei solution
// ValueObject
public class Member {
	
	private String name;
	private int age;
	private char gender;
	private String phone;
	
	Member(){}
	
	Member(String name, int age, char gender, String phone){
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
	}

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
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
