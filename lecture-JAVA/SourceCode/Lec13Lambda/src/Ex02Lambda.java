
public class Ex02Lambda {

	public static void main(String[] args) {

		// ! 기존 익명 중첩 클래스 방식
		MyFunctionalInterface mfi = new MyFunctionalInterface() {
			@Override
			public int method(int a, int b) {
				return a + b;
			}
		};
		System.out.println("기존: " + mfi.method(10, 20));

		// ! 람다 #1
		mfi = (a, b) -> {
			return a - b;
		};
		System.out.println("람다식 #1: " + mfi.method(10, 20));

		// ! 람다 #2
		mfi = (a, b) -> a * b;
		System.out.println("람다식 #2: " + mfi.method(10, 20));

	}
}
