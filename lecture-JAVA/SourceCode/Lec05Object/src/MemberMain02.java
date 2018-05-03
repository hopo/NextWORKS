import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// sensei solution
// Class Member02 need
public class MemberMain02 {

	public static void main(String[] args) throws IOException {

		// 입력 받을 준비
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Member02[] members = new Member02[3];

		for (int i = 0; i < members.length; i++) {
			// members[i] = new Member02();	// 변수 선언과 동시에 바로 넣을 경우
			Member02 member = new Member02();
			members[i] = member;

			System.out.print("이름 : ");
			members[i].setName(reader.readLine());

			System.out.print("나이 : ");
			members[i].setAge(Integer.parseInt(reader.readLine()));

			System.out.print("성별(m/f) : ");
			members[i].setGender((char) reader.read());
			reader.readLine();

			System.out.print("전화 : ");
			members[i].setPhone(reader.readLine());
		}
		
		// 출력이요
		System.out.println("========== 회원목록 ==========");
		System.out.println("이름\t 나이\t 성별\t 전화번호");
		for(int i = 0; i < members.length; i++) {
			System.out.printf(
				"%s\t %d\t %c\t %s\n",
				members[i].getName(), members[i].getAge(), members[i].getGender(), members[i].getPhone()
			);
		}
		System.out.println("==============================");

	}
}
