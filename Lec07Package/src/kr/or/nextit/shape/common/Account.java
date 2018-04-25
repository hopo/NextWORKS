package kr.or.nextit.shape.common;

public class Account {

	// Member field
	protected String accountNo;
	protected String ownerName;
	protected int balance;
	
	// Constructor
	protected Account() {};

	protected Account(String accountNo, String ownString, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownString;
		this.balance = balance;
	}
	
	// Member method
	// void deposit(int)
	protected void deposit(int amount) {
		balance += amount;
	}
	
	// int withdraw(int)
	protected int withdraw(int amount) {
		if(balance < amount) {
			System.out.println("잔액이 부족합니다.");
			return 0;
		}
		balance -= amount;
		return amount;
	}
	
}
