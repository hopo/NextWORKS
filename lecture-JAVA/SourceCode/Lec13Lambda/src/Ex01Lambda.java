
public class Ex01Lambda {
	public static void main(String[] args) {

		// 기존 익명 중첩 클래스 방식
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello, Anonymous Inner Class");
			}
		});

		t1.start();
		
		// 람다 표현식
		Thread t2 = new Thread(() -> {
			System.out.println("Hello, Lambda Expression");
		});
		t2.start();

	}

	// >> 표현의 방식은 서로 다르지만 내부적으로 같다.
}
