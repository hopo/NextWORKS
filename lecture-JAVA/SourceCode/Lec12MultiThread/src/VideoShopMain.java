
public class VideoShopMain {
	
	// 공유 자원
	public static VideoShop videoShop = new VideoShop();
	
	public static void main(String[] args) {
		
		Customer c1 = new Customer("AAA");
		Customer c2 = new Customer("BBB");
		Customer c3 = new Customer("CCC");
		Customer c4 = new Customer("DDD");
		Customer c5 = new Customer("EEE");
		Customer c6 = new Customer("FFF");
		
		// 개발자는 Thread를 start()만 시킬뿐
		// 다음은 Thread 스케쥴러가 관리
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		c5.start();
		c6.start();
		
	}

}
