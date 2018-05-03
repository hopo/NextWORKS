
public class PolymorphismMain {

	public static void main(String[] args) {
		
		// 최상위 클래스는 Account
		// 나머지는 inheritance 관계
		
		Account acc = new Account("123-45-6789", "이산", 100000);

		CheckingAccount check =
			new CheckingAccount("435-32-5533", "설현", 2000000, "2323-5535-6565-6908");
		
		CreditLineAccount minus =
			new CreditLineAccount("484-55-2237", "소향", 500000, 1000000);
		
		BonusPointAccount bonus =
			new BonusPointAccount("934-44-6556", "태연", 800000, 1500);
		
		// Polymorphism 속성을 이용한 disp()
		// acc를 제외한 Parameter인 Object들은 Upcasting된다.
		disp(acc);
		disp(check);
		disp(minus);
		disp(bonus);
		
	}
	
	public static void disp(Account acc) {
		// 아래 변수들은 최상위 Class의 Instance인 Account acc의 field
		System.out.println("=============== 계좌정보 출력 ===============");
		System.out.println("계좌번호 : " + acc.accountNo);
		System.out.println("예 금 주 : " + acc.ownerName);
		System.out.println("잔    액 : " + acc.balance);

		if(acc instanceof BonusPointAccount) {
			BonusPointAccount bonus = (BonusPointAccount)acc; // Downcasting
			System.out.println("포 인 트 : " + bonus.bonusPoint);
		}

		System.out.println();
	}

}
