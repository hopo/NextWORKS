import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person implements Serializable {

	String name;
	int age;
	char gender;
	transient String phone; // transient 직렬화 대상에서 제외

	Person() {}

	Person(String name, int age, char gender, String phone) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
	}

}

// ; RMI (JAVA간 통신) -> Webservice (XML) -> REST API (Ajax 통신)
public class Ex09ObjectInOutStream {

	public static void main(String[] args) {
		Person[] person = { new Person("이산", 25, 'M', "010-1234-5678"), new Person("설현", 25, 'F', "010-1004-1004"),
				new Person("소향", 41, 'F', "010-1234-1234"), new Person("보영", 30, 'M', "010-9999-1111"), };

		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;

		try {

			oos = new ObjectOutputStream(new FileOutputStream("/home/pc33/io/person.ser"));

			// ! 객체의 직렬화 (Marshalling)
			for (Person p : person) {
				oos.writeObject(p);
			}
			System.out.println("파일 출력 완료.");

			// ! 객체의 역직렬화 (Unmarshalling)
			ois = new ObjectInputStream(new FileInputStream("/home/pc33/io/person.ser"));

			try {

				while (true) {
					Person p = (Person) ois.readObject();
					System.out.printf("%s, %d, %c, %s\n", p.name, p.age, p.gender, p.phone);
				}

			} catch (EOFException e) {
				System.out.println("다 읽었다.");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
				if (ois != null) {
					ois.close();
				}

			} catch (Exception e2) {
			}

		}

	}

}
