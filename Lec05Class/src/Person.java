
public class Person {
	
	// 클래스의 구성요소 [필드(=변수) + 메서드]
	String name;	// 이름
	int age;	// 나이
	char gender;	// 성별
	String phone;	// 전화

	// 생성자(Constructor)

	// default Constructor
	Person() {}
		
	// (String, int) Constructor
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	Person(String name, int age, char gender, String phone) {
		this(name, age); // Call other Constructor, 첫줄에 호출 되어야 한다.
		this.gender = gender;
		this.phone = phone;
	}

}
