package kr.or.nextit.exam;

public class TotalSum {
	public static void main(String[] args) {
		int n = 10;

		int ex1 = loop(n);
		System.out.printf("ex1: %d\n", ex1);
		int ex2 = gaus(n);
		System.out.printf("ex2: %d\n", ex2);

	}
	static int loop(int n) {
		int i = 1;
		int ret = 0;

		while (i <= n) {
			ret += i;
			i++;
		}
		return ret;
	}
	static int gaus(int n) {
		int ret = (1 + n) * (n / 2);
		if (n % 2 != 0) {
			ret += n / 2 + 1;
		}
		return ret;
	}
}
