import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10Array {

	public static void main(String[] args) throws IOException {
		// EXAM)
		// "이름\t 나이\t 성별\t 전화\t 주소\n"		
		// 3명의 정보를 받아라

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[][] table = new String[5][3];

        for(int i = 0; i < table[0].length; i++) {
            System.out.printf("[%d people]\n", i);

            System.out.print("*이름: "); 
            table[0][i] = reader.readLine();

            System.out.print("*나이: "); 
            table[1][i] = reader.readLine();

            System.out.print("*성별(m/f): "); 
            table[2][i] = reader.readLine();

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
