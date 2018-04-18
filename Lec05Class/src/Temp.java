import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Temp {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("몇명? ");
		int memCnt = Integer.parseInt(reader.readLine());

		Person[] member = new Person[memCnt];

		int age;
		char gender;
		String name, phone;

		for(int i = 0; i < memCnt; i++) {
			System.out.printf("[ID %d]\n", i+1);
			
			System.out.print("이름 : ");
			name = reader.readLine();

			System.out.print("나이 : ");
			age = Integer.parseInt(reader.readLine());

			System.out.print("성별(m/f) : ");
			gender = (char)reader.read();
			reader.readLine();

			System.out.print("전화 : ");
			phone = reader.readLine();

			member[i] = new Person(name, age, gender, phone);
		}
		
		
		System.out.println("======================== 회원 정보 ========================");
		System.out.printf("ID\t 이름\t 나이\t 성별\t 전화\n");
		System.out.println("-----------------------------------------------------------");

		for(int i = 0; i < member.length; i++){
			System.out.printf(
				" %d|\t %s\t %d\t %c\t %s",
				i+1, member[i].name, member[i].age, member[i].gender, member[i].phone
			);
			System.out.println();
		}
		System.out.println("===========================================================");
	}
	
}
