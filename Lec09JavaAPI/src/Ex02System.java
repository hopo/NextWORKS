//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.time.Duration;

public class Ex02System {

	public static void main(String[] args)  {

		// BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//
		// while (true) {
		// System.out.print("Command : ");
		//
		// String str = reader.readLine();
		//
		// if ("exit".equals(str)) {
		// System.out.println(" >>> Program terminate. <<<");
		// // Process terminate. exit()
		// System.exit(0); // 0: 정상종료, 0 이외는 비정상 종료.
		// }
		//
		//
		// System.out.println("str : " + str);
		//
		// }

		// 1970년 1월 1일 00시 ~ 지금까지 밀리세컨 시간.
		// System.out.println(System.currentTimeMillis());

		// long startTime = System.currentTimeMillis();
//		long startTime = System.nanoTime();
//
//		long sum = 0;
//		for (int i = 0; i < 10000; i++) { sum += i; }
//		System.out.println(sum);

		// long duration = System.currentTimeMillis() - startTime;
//		long duration = System.nanoTime() - startTime;
//		System.out.println("경과시간 : " + duration + "ns");
		
		
		// 시스템 프로퍼티(key=value) 정보 읽어오기
		// ex) os.name=Linux
		System.out.println("Operate System : " + System.getProperty("os.name"));
		System.out.println("Java Version : " + System.getProperty("java.version"));
		
		// property 정보 보기
		System.getProperties().list(System.out);
		

	}

}
