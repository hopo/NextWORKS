import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// sensei solution
public class Ex10Array05 {

	public static void main(String[] args) throws IOException {
		// EXAM)
		// "이름\t 나이\t 성별\t 전화\t 주소\n"		
		// 3명의 정보를 받아라

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int manCnt = 3;

		String[] name = new String[manCnt];
		int[] age = new int[manCnt];
		char[] gender = new char[manCnt];
		String[] phone = new String[manCnt];
		String[] address = new String[manCnt];
	
		for(int i = 0; i < manCnt; i++) {
			System.out.print("이름 : ");
			name[i] = reader.readLine();

			System.out.print("나이 : ");
			age[i] = Integer.parseInt(reader.readLine());

			System.out.print("성별(M/F) : ");
			gender[i] = (char)reader.read();
			reader.readLine();	// '\n' 제거

			System.out.print("전화 : ");
			phone[i] = reader.readLine();

			System.out.print("주소 : ");
			address[i] = reader.readLine();
		}

		System.out.println(">>>>>>>>>>>>>>> 회원주소록 <<<<<<<<<<<<<<<");
		System.out.println("이름\t 나이\t 성별\t 전화\t 주소");
		
		for(int i = 0; i < manCnt; i++) {
			System.out.printf("%s\t %d\t %c\t %s\t %s\n",
					name[i], age[i], gender[i], phone[i], address[i]);
		}
	}

}
