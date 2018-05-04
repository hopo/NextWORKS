
class RunnableThread implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {

			String name = Thread.currentThread().getName();
			System.out.println(name);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}

		}

	}
}

public class Ex02MultiThread {

	public static void main(String[] args) {

		System.out.println("===== Main Thread Start =====");

		RunnableThread runnableThread = new RunnableThread();

		Thread thread1 = new Thread(runnableThread);
		thread1.setName("위");

		Thread thread2 = new Thread(runnableThread, "아래");

		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {

				for (int i = 0; i < 10; i++) {

					String name = Thread.currentThread().getName();
					System.out.println(name);

					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
					}
				}
			}

		}, "무명");

		thread1.start();
		thread2.start();
		thread3.start();

		System.out.println("===== Main Thread Terminate =====");

	}

}
