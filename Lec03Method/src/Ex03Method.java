import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03Method {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("10진수 : ");
		int num = Integer.parseInt(reader.readLine());
		
		System.out.println("2진수: " + toBinaryString(num));
		System.out.println("8진수: " + toOctalString(num));
		System.out.println("16진수: " + toHexString(num));
	}

	public static String convert(int num, int shift) {
		String pattern = "";
		int mask = (1 << shift) - 1;	// 1 * 2^n
		do {
			switch (num & mask) {
			case 10: pattern = "A" + pattern; break;
			case 11: pattern = "B" + pattern; break;
			case 12: pattern = "C" + pattern; break;
			case 13: pattern = "D" + pattern; break;
			case 14: pattern = "E" + pattern; break;
			case 15: pattern = "F" + pattern; break;
			default: pattern = (num & mask) + pattern;
			}
			num = num >>> shift;
		} while(num > 0);
		
		return pattern;

	}

	public static String toBinaryString(int num) { return convert(num, 1); }
	public static String toOctalString(int num) { return convert(num, 3); }
	public static String toHexString(int num) { return convert(num, 4); }
	
}
