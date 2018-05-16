public class Ex02System {

	public static void main(String[] args) {

//		// !! ex) System.exit()
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		while (true) {
//			System.out.print("Command : ");
//			String str = "";
//			try {
//				str = reader.readLine();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			if ("exit".equals(str)) {
//				System.out.println(" >>> Program terminate. <<<");
//				// ;; Process terminate. exit()
//				System.exit(0); // ;; 0: 정상종료, 0 이외는 비정상 종료.
//			}
//			System.out.println("str : " + str);
//		}

		// !! ex) 1970년 1월 1일 00시 ~ 지금까지 밀리세컨 시간.
		System.out.println("System.currentTimeMillis(): " + System.currentTimeMillis());

		// !! ex)
		// long startTime = System.currentTimeMillis();
		long startTime = System.nanoTime();
		long sum = 0;
		for (int i = 0; i <= 10000; i++) {
			sum += i;
		}
		// long duration = System.currentTimeMillis() - startTime;
		long duration = System.nanoTime() - startTime;
		System.out.println("\n1~10000 총 합 " + sum + "의 경과시간 : " + duration + "ns");

		// !!! 시스템 프로퍼티(key=value) 정보 읽어오기
		// ex) os.name=Linux
		System.out.println("\nOperate System : " + System.getProperty("os.name"));
		System.out.println("Java Version : " + System.getProperty("java.version"));

		// !!! property 전체 정보 보기
		// System.getProperties().list(System.out);

	}

}
