
public class InheritanceMain {
	
	public static void main(String[] args) {
		
		CheckingAccount check;
		check = new CheckingAccount("123-43-323", "이산", 150000, "4343-6263-5535-2344");
		
		// 부모 클래스에서 상속 받은 메서드 호출.
		int money = check.withdraw(50000);
		System.out.println("!check.withdraw(50000)");
		System.out.println("인출금액 : " + money);
		System.out.println("잔    액 : " + check.balance);
		
		System.out.println();
		
		//  자신의 메서드 호출
		money = check.pay("4343-6263-5535-2344", 12000);
		System.out.println("!check.pay(\"4343-6263-5535-2344\", 12000)");
		System.out.println("지불금액 : " + money);
		System.out.println("잔    액 : " + check.balance);
		
	}

}
