import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemberMain {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력 받을 사람의 수는 얼마인가
		System.out.print("몇명? ");
		int memCnt = Integer.parseInt(reader.readLine());

		// Member 객체(Object)들로 이루어진 배열(Array)
		Member[] mems = new Member[memCnt];
		
		// 각각의 Member 객체들의 정보들을 입력 받는다.
		for(int i = 0; i < memCnt; i++) {
			System.out.printf("[ID %d]\n", i+1);
			mems[i] = new Member();

			System.out.print("이름 : ");
			mems[i].setName(reader.readLine());

			System.out.print("나이 : ");
			mems[i].setAge(Integer.parseInt(reader.readLine()));

			System.out.print("성별(m/f) : ");
			mems[i].setGender((char)reader.read());
			reader.readLine();

			System.out.print("전화 : ");
			mems[i].setPhone(reader.readLine());

		}
		
		
		// 입력 받은 정보를 출력하기
		System.out.println("======================== 회원 정보 ========================");
		System.out.printf("ID |\t 이름\t 나이\t 성별\t 전화\n");
		System.out.println("-----------------------------------------------------------");
		for(int i = 0; i < mems.length; i++){ dispMember(mems, i); }
		System.out.println("===========================================================");
	}
	
	// 명부(mems[])와 아이디를 입력하면 정보들을 출력하는 메서드
	static void dispMember(Member[] mems, int id) {
		System.out.printf(
			"%02d |\t %s\t %d\t %c\t %s\n",
			id+1, mems[id].getName(), mems[id].getAge(), mems[id].getGender(), mems[id].getPhone()
		);
	}
	
}
