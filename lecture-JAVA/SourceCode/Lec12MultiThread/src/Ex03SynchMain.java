
public class Ex03SynchMain {
	
	// 공유자원
	public static BankAccount account = new BankAccount();
	
	public static void main(String[] args) {
		
		System.out.println("메인 스레드 시작");
		System.out.println("현재 잔액 : " + account.getBalance());
		
		Husband h = new Husband("이산") ;
		Wife w = new Wife("설현") ;
		
		h.start();
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
		}
		
		w.start();
		
		
		System.out.println("메인 스레드 종료");
		
	}

}
