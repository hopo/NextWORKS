package kr.or.nextit.exam;

public class Gugudan {
	public static void main(String[] args) {

//		gugudan();
		gugudan02();

	}


	static void gugudan() {
		for (int a = 2; a <= 9; a++) {
			for (int b = 1; b <= 9; b++) {
				System.out.printf("%d x %d = %d\n", a, b, a * b);
			}
		}
	}

	static void gugudan02() {
		int a = 2;
		int b = 1;

		while (a <= 9) {
			System.out.printf("%d x %d = %d\n", a, b, a * b);
			b++;
			if (b > 9) {
				a++;
				b = 1;
			}
		}

	}
}