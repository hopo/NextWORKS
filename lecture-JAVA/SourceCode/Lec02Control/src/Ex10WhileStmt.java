import java.io.IOException;

public class Ex10WhileStmt {

	public static void main(String[] args) throws IOException {
		
		System.out.print("메시지를 남겨주세요 : ");
		
		while(true) {
			int x = System.in.read();
			if(x == -1) {
				System.out.println("입력을 종료합니다.");
				break;
			}
			System.out.print((char)x);
		}

		System.out.println(">>>> 프로그램 종료 <<<< ");


//		int sum = 0;
//		for(int i = 1; i <= 10; i++) {
//			sum += i;
//		}
//		System.out.println("For문 : " + sum);
//	
//		sum = 0;
//
//		int i = 1;
//		while(i <= 10) {
//			sum += i;
//			i++;
//		}
//		System.out.println("While문 : " + sum);
		


//		// for 구구단
//		for(int dan = 2; dan <= 9; dan++) {
//			System.out.println("===== " + dan + "단 ======");
//			for(int n = 1; n <=9; n++) {
//				System.out.printf("%d x %d = %d\n", dan, n, dan*n);
//			}
//		}
//
//		// while 구구단
//		int dan = 2;
//		while(dan <= 9) {
//			System.out.println("===== " + dan + "단 ======");
//			int n = 1;
//			while(n <= 9) {
//				System.out.printf("%d x %d = %d\n", dan, n, dan*n);
//				n++;
//			}
//			dan++;
//		}
		
		
	}

}
