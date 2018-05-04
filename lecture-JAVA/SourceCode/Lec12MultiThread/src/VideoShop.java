import java.util.Vector;

public class VideoShop {

	// 비디오 목록
	Vector<String> videoList = new Vector<>();

	public VideoShop() {
		videoList.add("밴드 오브 브라더스 1-1");
		videoList.add("밴드 오브 브라더스 1-2");
		videoList.add("밴드 오브 브라더스 1-3");
		videoList.add("밴드 오브 브라더스 1-4");
	}

	// 비디오 대여
	public synchronized String lendVideo() {
		while (videoList.size() == 0) {
			try {
				System.out.println(Thread.currentThread().getName() + "대기~");
				wait(); // 자원 없다. 반납할 때 까지 대기.
			} catch (InterruptedException e) {
			}
		}
		String video = videoList.remove(videoList.size() - 1);
		return video;

	}

	// 비디오 반납
	public synchronized void returnVideo(String video) {
		videoList.add(video);
		// notify(); //  반납되었다고 알랴줌. if로 컨트롤
		notifyAll(); // while로 컨트롤

	}

}
