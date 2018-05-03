
public class AccountMain {

	public static void main(String[] args) {
		
		Account acc1 = new Account("123-45-4343", "이산", 1500000);
		Account acc2 = new Account("122-87-3002", "설현", 100000);
		
		int amount = acc1.withdraw(200000);
		acc2.deposit(amount);
		
		disp(acc1);
		disp(acc2);
		
	}
	
	public static void disp(Account acc) {
		System.out.println("========== 계좌정보 ==========");
		System.out.println("예금주 : " + acc.ownerName);
		System.out.println("잔  액 : " + acc.balance);
		System.out.println();
	}

}
