
/*
아래의 형태를 가지느 클래스를 명명하기를
JavaBeans, VO(Value Object), Model
규약에 따라서 getter setter
*/

public class Person {

	// !접근제한자 (Access Modifier) : public, protected, default, private
	// protected: 같은 패키지 + 다른 패키지 상속관계시
	// default: 같은 패키지만
	// private: 필드를 담고 있는 클래스 내에서만

	// String name; // 이름, field of Instance
	private String name; // 이름
	// static int age; // 나이, field of Class
	private int age; // 나이
	private char gender; // 성별
	private String phone; // 전화

	// !생성자(Constructor)
	Person() {
	} // default Constructor

	// this(String, int) Constructor
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// this(String, int, char, String) Constructor
	Person(String name, int age, char gender, String phone) {
		this(name, age); // Call other Constructor, 첫줄에 호출 되어야 한다.
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
