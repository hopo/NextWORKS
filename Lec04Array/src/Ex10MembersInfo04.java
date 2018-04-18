import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10MembersInfo04 {

	public static void main(String[] args) throws IOException {
		// EXAM)
		// "이름\t 나이\t 성별\t 전화\t 주소\n"
		// 3명의 정보를 받아라

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("몇명을 입력하겠소? ");
		int mems = Integer.parseInt(reader.readLine());

		String[] name = new String[mems];
		int[] age = new int[mems];
		char[] gender = new char[mems];
		String[] phone = new String[mems];
		String[] address = new String[mems];

		for (int i = 0; i < mems; i++) {
			System.out.printf("[멤버 %d] : \n", i + 1);
			System.out.print("*이름: ");
			name[i] = reader.readLine();

			System.out.print("*나이: ");
			age[i] = Integer.parseInt(reader.readLine());

			System.out.print("*성별(m/f): ");
			gender[i] = (char) (reader.read());
			reader.readLine();

			System.out.print("*전화: ");
			phone[i] = reader.readLine();

			System.out.print("*주소: ");
			address[i] = reader.readLine();
		}

		// print data
		System.out.print("==================== Print Private Infomation ====================\n");
		System.out.print("ID|\t 이름\t 나이\t 성별\t 전화\t\t 주소\n");
		for (int i = 0; i < mems; i++) {
			System.out.printf("%d |\t %s\t %d\t %c\t %s\t %s\n", i + 1, name[i], age[i], gender[i], phone[i],
					address[i]);
		}
		System.out.print("==================================================================\n");

	}

}
