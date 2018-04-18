
public class PersonMain {

	public static void main(String[] args) {

		// 객체 생성
		// Person p = new Person();
		// Person p = new Person("설현", 25);
		Person p = new Person("소향", 41, 'F', "010-9999-8989");

		// p.name = "이산";
		// p.age = 25;
		// p.gender = 'M';
		// p.phone = "010-1234-5678";

		System.out.println("이름 : " + p.name);
		System.out.println("나이 : " + p.age);
		System.out.println("성별 : " + p.gender);
		System.out.println("전화 : " + p.phone);

	}

}
