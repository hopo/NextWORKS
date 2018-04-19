import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemberMain {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("몇명? ");
		int memCnt = Integer.parseInt(reader.readLine());

		Member[] mems = new Member[memCnt];
		
		for(int i = 0; i < memCnt; i++) {
			mems[i] = new Member();
			System.out.printf("[ID %d]\n", i+1);

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
		
		
		System.out.println("======================== 회원 정보 ========================");
		System.out.printf("ID\t 이름\t 나이\t 성별\t 전화\n");
		System.out.println("-----------------------------------------------------------");

		for(int i = 0; i < mems.length; i++){
			System.out.printf(
				" %d|\t %s\t %d\t %c\t %s",
				i+1, mems[i].getName(), mems[i].getAge(), mems[i].getGender(), mems[i].getPhone()
			);
			System.out.println();
		}
		System.out.println("===========================================================");
	}
	
}
