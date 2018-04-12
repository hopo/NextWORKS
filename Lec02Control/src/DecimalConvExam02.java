import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// *Soution.2
public class DecimalConvExam02 {

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
		boolean minus = false;
		String pattern = "";

		if(num < 0) {
			num *= -1;
			minus = true;
		}


		// 2진수 구하기;
		int temp = num;
		for(int i = 0; i < 32; i++) {
			if(minus && i == 32-1) {
				pattern = "1" + pattern;
			} else {
				pattern = (temp % 2) + pattern; // 0 or 1
			}

			temp = temp /2;
		}
		System.out.println("2진수 : " + pattern);

		// 8진수 구하기;
		temp = num;
		pattern = "";
		for(int i = 0; i < 32/3 +1; i++) {
			if(minus && i == 31/3) {
				pattern = "1" + pattern;
			} else {
				pattern = (temp % 8) + pattern;
			}

			temp = temp /8;
		}
		System.out.println("8진수 : " + pattern);

		// 16진수 구하기;
		temp = num;
		pattern = "";
		for(int i = 0; i < 32/4; i++) {

			switch(temp % 16) {
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
				if(minus &&i == 32/4-1) {
					pattern = "1" + pattern;
				} else {
					pattern = (temp % 16) + pattern;
				}
			}

			temp = temp/16;
		}

		System.out.println("16진수 : " + pattern);
	}

}
