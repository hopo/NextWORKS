import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MemberMain {

	public static void main(String[] args) throws IOException {

		// 입력 받을 준비
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		List<Member> members = new ArrayList<Member>();
		int num = 2;

		for (int i = 0; i < num; i++) {
			Member member = new Member();
			members.add(member);

			System.out.print("이름 : ");
			member.setName(reader.readLine());

			System.out.print("나이 : ");
			member.setAge(Integer.parseInt(reader.readLine()));

			System.out.print("성별(m/f) : ");
			member.setGender((char) reader.read());
			reader.readLine();

			System.out.print("전화 : ");
			member.setPhone(reader.readLine());
		}
		
		// 출력이요
		System.out.println("========== 회원목록 ==========");
		System.out.println("이름\t 나이\t 성별\t 전화번호");
		for(int i = 0; i < members.size(); i++) {
			System.out.printf(
				"%s\t %d\t %c\t %s\n",
				members.get(i).getName(), members.get(i).getAge(), members.get(i).getGender(), members.get(i).getPhone()
			);
		}
		System.out.println("==============================");

	}
}
