
public class Ex01Method {

	public static void main(String[] args) {

		int a = 10;
		int b = 20;

		

//		 int c = a + b;
//		 // call method
//		 int c = add(a, b);
//		 System.out.println("두 수의 합 :" + c);
//		
//		 int maxNum = 0;
//		 if (a >= b) {
//		 maxNum = a;
//		 } else {
//		 maxNum = b;
//		 }
//		 System.out.printf("큰 수 : %d\n", maxNum);
//		
//		 int x = 30;
//		 int y = 15;
//		 System.out.printf("큰 수 : %d", max(x, y));

//		// #1. Call By Value
//		int x = 10;
//		makeDouble(x);
//		System.out.println("main x = " + x);
		
		// #2. Call By Reference (클래스, 배열, 열거형, 인터페이스...)
		StringBuffer sb = new StringBuffer("Java 라고 쓰고, ");
		printMsg(sb);
		System.out.println("main sb = " + sb);

	}
	
	public static void printMsg(StringBuffer sb) {
		sb.append("껌이라고 읽는다.");
		System.out.println("printMsg sb = " + sb);
	}

	public static void makeDouble(int x) {
		x = x * 2;
		System.out.println("makeDouble x = " + x);

	}

	public static int max(int x, int y) {
		int maxNum = 0;
		if (x >= y) {
			maxNum = x;
		} else {
			maxNum = y;
		}

		return maxNum;
	}

	public static int add(int x, int y) {
		// 명령문
		int result = x + y;
		return result;
	}

}
