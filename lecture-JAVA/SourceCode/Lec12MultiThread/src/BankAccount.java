
public class BankAccount {

	private int balance = 500000; // 잔액

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	// ! 입금
	// synchronized 동기화 '메서드' : 메서드 전체 LOCK
	public synchronized void deposit(int amount) {
		int balance = getBalance();

		try { Thread.sleep(2000); }
		catch (InterruptedException e) {}

		setBalance(balance + amount); // 지역변수 balance에 파라미터 amount를 더한다
	}

	// ! 출금
	// synchronized 동기화 '블럭' : 부분 LOCK
	public int withdraw(int amount) {

		synchronized (this) {

			int balance = getBalance();

			try { Thread.sleep(500); }
			catch (InterruptedException e) {}

			setBalance(balance - amount);
			return amount;

		}
	}
}
