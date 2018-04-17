import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10c {

	public static void main(String[] args) throws IOException {
		// EXAM)
		// "이름\t 나이\t 성별\t 전화\t 주소\n"		
		// 3명의 정보를 받아라

		String[] column = {"이름", "나이", "성별", "전화", "주소"};
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("HOW MANY ? ");
		int member = Integer.parseInt(reader.readLine());

		Object[][] table = new Object[column.length][member];
		table[0] = new String[member];
		table[1] = new Integer[member];
		table[2] = new Character[member];
		table[3] = new String[member];
		table[4] = new String[member];

		for(int i = 0; i < member; i++) {
            System.out.printf("[%d people]\n", i);

            System.out.print("*이름: "); 
            table[0][i] = reader.readLine();

            System.out.print("*나이: "); 
            table[1][i] = Integer.parseInt(reader.readLine());

            System.out.print("*성별(m/f): "); 
            table[2][i] = reader.readLine().toCharArray()[0];

            System.out.print("*전화: "); 
            table[3][i] = reader.readLine();

            System.out.print("*주소: "); 
            table[4][i] = reader.readLine();
		}
		
		// print data
		System.out.print("==================== Print Private Infomation ====================\n");
		System.out.print("이름\t 나이\t 성별\t 전화\t\t 주소\n");
        for(int i = 0; i < table[0].length; i++) {
            for(int j = 0; j < table.length; j++) {
                System.out.printf("%s\t ", table[j][i]);	
            }
            System.out.println();
        }
		System.out.print("==================================================================\n");
		
	}

}
