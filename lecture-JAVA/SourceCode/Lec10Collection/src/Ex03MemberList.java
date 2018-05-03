import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// ***sensei solution
public class Ex03MemberList {

	public static void main(String[] args) throws IOException {

		//  3명의 회원정보 입력/출력
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// Member[] members = new Member[3];
		ArrayList<Member> memberList = new ArrayList<>();
		
		for(int i = 0; i < 3; i++) {
			Member member = new Member();
			
			System.out.print("이름 : ");
			member.setName(reader.readLine());

			System.out.print("나이: ");
			member.setAge(Integer.parseInt(reader.readLine()));

			System.out.print("성별(m/f): ");
			member.setGender((char) reader.read());
			reader.readLine();

			System.out.print("전화: ");
			member.setPhone(reader.readLine());
			
			memberList.add(member);
		}
		
		System.out.println("============= 회원목록 =============");
		System.out.println("이름\t 나이\t 성별\t 전화번호");
		if(memberList != null && memberList.size() >0) {
//			for (int i = 0; i < memberList.size(); i++) {
//				Member member = memberList.get(i);
//				System.out.printf(
//					"%s\t %d\t %c\t %s\n",
//					member.getName(), member.getAge(), member.getGender(), member.getPhone()
//				);
//			}
			for (Member member : memberList) {
				System.out.printf(
					"%s\t %d\t %c\t %s\n",
					member.getName(), member.getAge(), member.getGender(), member.getPhone()
				);
			}
		}
		System.out.println("==================================");


//		// *** solution01 @MemberMain.java
//		// ! 입력 받을 준비
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		List<Member> members = new ArrayList<Member>();
//		Member member = null;
//		char term;
//
//		// ! 입력
//		do {
//			member = new Member();
//
//			System.out.print("이름: ");
//			member.setName(reader.readLine());
//
//			System.out.print("나이: ");
//			member.setAge(Integer.parseInt(reader.readLine()));
//
//			System.out.print("성별(m/f): ");
//			member.setGender((char) reader.read());
//			reader.readLine();
//
//			System.out.print("전화: ");
//			member.setPhone(reader.readLine());
//
//			members.add(member);
//
//			System.out.print(">> 더 추가하시겠습니까(y/n)? ");
//			term = (char) reader.read();
//			reader.readLine();
//
//		} while (term == 'y');
//
//		// ! 출력이요
//		System.out.println("============= 회원목록 =============");
//		System.out.println("이름\t 나이\t 성별\t 전화번호");
//		for (Member m : members) {
//			System.out.printf(
//				"%s\t %d\t %c\t %s\n",
//				m.getName(), m.getAge(), m.getGender(), m.getPhone()
//			);
//		}
//		System.out.println("==================================");

	}
}
