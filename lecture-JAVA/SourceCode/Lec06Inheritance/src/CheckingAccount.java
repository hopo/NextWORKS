/*
 ;클래스 관계 명칭
 child class - parent class
 sub class - super class
*/

public class CheckingAccount extends Account {

	String cardNo; // Class CheckingAccount 의 field

	CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		// super(); // 상위 클래스의 생성자 호출, Account()를 자동 호출.
		// super.accountNo = accountNo;
		// super.ownerName = ownerName;
		// super.balance = balance;

		super(accountNo, ownerName, balance);

		this.cardNo = cardNo;
	}
	
	// !직불카드 사용액 지불
	int pay(String cardNo, int amount) {
		if(!this.cardNo.equals(cardNo) || balance < amount) {	// 반드시 객체 비교는 equals() 사용.
			System.out.println("지불 불가!");
			return 0;
		}
		balance -= amount;
		return amount;
	}

}
