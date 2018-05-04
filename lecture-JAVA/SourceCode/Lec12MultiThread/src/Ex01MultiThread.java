
// !! 독립 스레드 : main Thread 죽어도 살아있다
// !! 데몬 스레드 : main Thread 죽으면 같이 죽는다
class SampleThread extends Thread {

	@Override
	public void run() {

		System.out.println("SampleThread 스레드 명 : " + Thread.currentThread().getName());

		for (int i = 1; i <= 40; i++) {
			System.out.print(i + " ");
			try {
				Thread.sleep(100); // 0.1초
			} catch (InterruptedException e) {
			}
		}

	}

}

public class Ex01MultiThread {

	public static void main(String[] args) {

		System.out.println("현재 스레드 명 : " + Thread.currentThread().getName());

		System.out.println("===== Program Start =====");
		
		// ! 스레드 생성 및 시작
		SampleThread thread = new SampleThread();
		thread.setDaemon(true); // daemon thread set. main 스레드 죽을 때 같이 죽어라.

		thread.start(); // thread start: start() call -> run() call

		for (char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch + " ");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}

		}

		System.out.println("\n===== Program Terminate =====");

	}

}
