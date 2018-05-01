import java.util.Random;

public class Ex14Random {
	
	public static void main(String[] args) {
		
		// ! 난수 발생
		System.out.println("Math.random() : " + Math.random()); // 0.0 <= x < 1.0
		

		// ! Random class를 이용하여
		Random random = new Random();
		System.out.println(random.nextInt());	// int형 범위 난수 발생
		System.out.println(random.nextInt(10));	// 0~9 int형 범위 난수 발생
		System.out.println(random.nextFloat());	// float형 0.0 <= x < 1.0
		System.out.println(random.nextDouble());	// double형 0.0 <= x < 1.0
		System.out.println(random.nextBoolean());	// true or false
		
		
		// ; seed 배정하지 않은경우
		random = new Random(); // System.nanoTime()이 parameter로 들어가는 것과 같다.
		System.out.println("========== seed 없는 경우 ==========");
		System.out.println(random.nextInt(200));
		System.out.println(random.nextInt(200));
		System.out.println(random.nextInt(200));

		// ; seed 배정하지 않은경우
		random = new Random(1L); // 일반적으로 난수발생 테스트를 위해 사용
		System.out.println("========== seed 있는 경우 ==========");
		System.out.println(random.nextInt(200));
		System.out.println(random.nextInt(200));
		System.out.println(random.nextInt(200));
		
	}

}
