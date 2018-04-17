import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex10b {

	public static void main(String[] args) throws IOException {
		// EXAM)
		// "이름\t 나이\t 성별\t 전화\t 주소\n"		
		// 3명의 정보를 받아라

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	    String[] info = {"이름", "나이", "성별", "전화", "주소"};	

        String[][] table = new String[3][info.length];

        for(int i = 0; i < table.length; i++) {
            System.out.printf("[%d people]\n", i);
            for(int j = 0; j < info.length; j++) {
                System.out.printf("*%s: ", info[j]); 
                table[i][j] = reader.readLine();
            }
        }
		

		// print data
		System.out.print("==================== Print Private Infomation ====================\n");
		System.out.print("이름\t 나이\t 성별\t 전화\t\t 주소\n");
        for(int i = 0; i < table.length; i++) {
            for(int j = 0; j < table[i].length; j++) {
                System.out.printf("%s\t ", table[i][j]);	
            }
            System.out.println();
        }
		System.out.print("==================================================================\n");
		
	}
}
