import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// solution.01
public class MemberMain {

	public static void main(String[] args) throws IOException {

		// ! 입력 받을 준비
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<Member> members = new ArrayList<Member>();
		Member member = null;
		char term;

		// ! 입력
		do {
			member = new Member();

			System.out.print("이름: ");
			member.setName(reader.readLine());

			System.out.print("나이: ");
			member.setAge(Integer.parseInt(reader.readLine()));

			System.out.print("성별(m/f): ");
			member.setGender((char) reader.read());
			reader.readLine();

			System.out.print("전화: ");
			member.setPhone(reader.readLine());

			members.add(member);

			System.out.print(">> 더 추가하시겠습니까(y/n)? ");
			term = (char) reader.read();
			reader.readLine();

		} while (term == 'y');

		// ! 출력이요
		System.out.println("============= 회원목록 =============");
		System.out.println("이름\t 나이\t 성별\t 전화번호");
		for (Member m : members) {
			System.out.printf(
				"%s\t %d\t %c\t %s\n",
				m.getName(), m.getAge(), m.getGender(), m.getPhone()
			);
		}
		System.out.println("==================================");

	}
}
