
public class Account {

	// Member field
	String accountNo;
	String ownerName;
	int balance;
	
	// Constructor
	Account(String accountNo, String ownString, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownString;
		this.balance = balance;
	}
	
	// Member method
	// void deposit(int)
	void deposit(int amount) {
		balance += amount;
	}
	
	// int withdraw(int)
	int withdraw(int amount) {
		if(balance < amount) {
			System.out.println("잔액이 부족합니다.");
			return 0;
		}
		balance -= amount;
		return amount;
	}
	
}
