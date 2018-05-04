import java.util.Random;

public class Customer extends Thread {

	public Customer(String name) {
		this.setName(name);
	}

	@Override
	public void run() {

		// synchronized (VideoShopMain.videoShop) {

		// 비디오 대여
		String video = VideoShopMain.videoShop.lendVideo();
		
		if (video == null) {
			System.out.println(getName() + "가 대여 실패!");
			return ;
		}

		// 비디오 시청
		System.out.println(getName() + "가 " + video + " 대여.");
		System.out.println(getName() + "가 " + video + " 시청 중.");

		Random random = new Random();

		try {
			int x = random.nextInt(3) + 1; // 0 ~ 2
			Thread.sleep(1000 * x);
		} catch (InterruptedException e) {
		}

		// 비디오 반납
		VideoShopMain.videoShop.returnVideo(video);

		System.out.println(getName() + "가 " + video + " 반납.");

		// }

	}

}
