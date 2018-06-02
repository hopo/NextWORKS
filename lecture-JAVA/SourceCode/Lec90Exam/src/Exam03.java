import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// [과제 3] 개인 정보(이름, 나이, 성별, 전화번호)를 저장하는 클래스를 선언하고 3 명의 정보를 입력 받아 출력하는 프로그램을 작성하시오. (단, 개인정보를 표현하는 클래스의 이름은 Person 으로 한다.)

class Person {
	private String name;
	private int age;
	private char gender;
	private String phoneNumber;

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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}

public class Exam03 {

	public static void main(String[] args) throws IOException {
		int num = 3;

		Person people = null;
		ArrayList<Person> list = new ArrayList<>();

		BufferedReader reader = null;
		reader = new BufferedReader(new InputStreamReader(System.in));

		while (num != 0) {
			people = new Person();

			System.out.print("NAME? ");
			String name = reader.readLine();

			System.out.print("AGE(0~120)? ");
			int age = Integer.parseInt(reader.readLine());

			System.out.print("GENDER(F/M)? ");
			char gender = (char) reader.read();
			reader.readLine();

			System.out.print("PHONE_NUMBER? ");
			String phoneNumber = reader.readLine();

			people.setName(name);
			people.setAge(age);
			people.setGender(gender);
			people.setPhoneNumber(phoneNumber);

			list.add(people);

			num--;
			System.out.println("---");
		}

		System.out.println(">>> PRINT");
		System.out.printf("Name\tAge\tGender\tPhoneNumber\n");
		for (Person p : list) {
			System.out.printf(
					"%s\t%d\t%c\t%s\n",
					p.getName(), p.getAge(), p.getGender(), p.getPhoneNumber()
			);
		}
	}

}
