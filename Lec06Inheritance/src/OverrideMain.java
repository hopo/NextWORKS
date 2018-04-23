
public class OverrideMain {

	public static void main(String[] args) {

		CreditLineAccount minus =
			new CreditLineAccount("342-44-3904", "이산", 100000, 5000000);
		
		// 자식클래스에서 오버라이드한 메서드가 호출.
		int money = minus.withdraw(2000000);
		System.out.println("인출금액 : " + money);
		System.out.println("잔    액 : " + minus.balance);
		

		BonusPointAccount bonus =
			new BonusPointAccount("994-41-8889", "박보영", 100000, 1000);
		
		// 자식클래스에서 오버라이드한 메서드가 호출.
		bonus.deposit(1500000);
		System.out.println("잔    액 : " + bonus.balance);
		System.out.println("포 인 트 : " + bonus.bonusPoint);
			
	}

}
