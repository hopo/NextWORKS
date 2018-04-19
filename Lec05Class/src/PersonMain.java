
public class PersonMain {

	public static void main(String[] args) {

		// !객체 생성
		// Person p = new Person();
		// Person p = new Person("설현", 25);
		Person p = new Person("소향", 41, 'F', "010-9999-8989");

		// p.name = "이산";
		// p.age = 35;
		// p.gender = 'M';
		// p.phone = "010-1234-5678";
		p.setName("설현");
		p.setAge(25);
		p.setGender('F');
		p.setPhone("010-4444-5678");

		// System.out.println("이름 : " + p.name);
		// System.out.println("나이 : " + p.age);
//		System.out.println("이름 : " + p.getName());
//		System.out.println("나이 : " + p.getAge());
//		System.out.println("성별 : " + p.getGender());
//		System.out.println("전화 : " + p.getPhone());
		
//		Person san = new Person();
//		san.name = "이산";	// san이라는 인스턴스의 인스턴스 필드 name
//		san.age = 30;
//		
//		Person hyun = new Person();
//		hyun.name = "설현"; // hyun이라는 인스턴스의 인스턴스 필드 name
//		
//		System.out.println("san.name = " + san.name);
//		System.out.println("san.age = " + san.age);
//		System.out.println("hyun.name = " + hyun.name);
//		System.out.println("hyun.age = " + Person.age);

	}

}
