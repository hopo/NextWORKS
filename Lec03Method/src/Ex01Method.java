
public class Ex01Method {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		// int c = a + b;
		// 메서드 호출
		int c = add(a, b);
		System.out.println("두 수의 합 :" + c);
		
		int maxNum = 0;
		if (a >= b) {
			maxNum = a;
		} else {
			maxNum = b;
		}
		System.out.printf("큰 수 :  %d\n", maxNum);
		
		int x = 30;
		int y = 15;
		System.out.printf("큰 수 :  %d", max(x, y));

	}
	
	public static int max(int x, int y) {
		int maxNum = 0;
		if(x >= y) {
			maxNum = x;
		} else {
			maxNum =y;
		}
		
		return maxNum;
	}

	public static int add(int x, int y) {
		// 명령문
		int result = x + y;
		return result;
	}
	
}
