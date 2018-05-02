import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

// HashMap 사용하여..
// Ex03MemberList.java를 가져옴.
// *** solution01
public class Ex07MemberList {

	public static void main(String[] args) throws IOException {

		// 3명의 회원정보 입력/출력
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Member[] members = new Member[3];
		// ArrayList<Member> memberList = new ArrayList<>();

		ArrayList<HashMap<String, Object>> memberList = new ArrayList<>();
		HashMap<String, Object> hmap = null;

		for (int i = 0; i < 2; i++) {
			hmap = new HashMap<>();

			System.out.print("name : ");
			hmap.put("name", reader.readLine());

			System.out.print("age : ");
			hmap.put("age", Integer.parseInt(reader.readLine()));

			System.out.print("gender : ");
			hmap.put("gender", (char) reader.read());
			reader.readLine();

			System.out.print("phone : ");
			hmap.put("phone", reader.readLine());

			memberList.add(hmap);
		}

		System.out.println("============= 회원목록 =============");
		System.out.println("이름\t 나이\t 성별\t 전화번호");
		for (HashMap<String, Object> m : memberList) {
			System.out.printf("%s\t %d\t %c\t %s\n", m.get("name"), m.get("age"), m.get("gender"),
					m.get("phone"));
		}
		System.out.println("====================================");

	}
}
