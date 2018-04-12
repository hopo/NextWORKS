import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// *Soution.3
public class DecimalConvExam03 {

	public static void main(String[] args) throws IOException {

		// 과제1> 10진수를 입력 받아 2진수, 8진수, 16진수로 출력하시오.
		// 예시)
		// 10진수 : 170
		// === 출력결과 ===
		// 2진수 : 00000000000000000000000010101010
		// 8진수 : 00000000252
		// 16진수 : 000000AA
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("10진수 : ");
		int num = Integer.parseInt(reader.readLine());
		String pattern = "";


		// 2진수 구하기;
		int temp = num;
		for(int i = 0; i < 32; i++) {
			pattern = (temp & 1) + pattern; // 0 or 1, 마직막 1bit 확인
			temp = temp >>> 1;
		}
		System.out.println("2진수 : " + pattern);

		// 8진수 구하기;
		temp = num;
		pattern = "";
		for(int i = 0; i < 32/3 +1; i++) {
			pattern = (temp & 7) + pattern; // 마지막 3bit 확인 temp & 0111
			temp = temp >>> 3; // 확인한 부분을 쉬프트
		}
		System.out.println("8진수 : " + pattern);

		// 16진수 구하기;
		temp = num;
		pattern = "";
		for(int i = 0; i < 32/4; i++) {
			switch(temp & 0xF) {
			case 10:
				pattern = "A" +pattern;
				break;
			case 11:
				pattern = "B" +pattern;
				break;
			case 12:
				pattern = "C" +pattern;
				break;
			case 13:
				pattern = "D" +pattern;
				break;
			case 14:
				pattern = "E" +pattern;
				break;
			case 15:
				pattern = "F" +pattern;
				break;
			default:
				pattern = (temp & 0xF) + pattern;
			}
			temp = temp >>> 4;
		}

		System.out.println("16진수 : " + pattern);
	}

}
