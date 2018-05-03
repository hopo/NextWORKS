import kr.or.nextit.shape.common.Account;

public class BonusPointAccount extends Account {

	int bonusPoint; // 보너스 포인트

	BonusPointAccount(String accountNo, String ownerName, int balance, int bonusPoint) {
		super(accountNo, ownerName, balance);
		this.bonusPoint = bonusPoint;
	}

	
	// Parent의 method를 Override 할 때
	// Child의 method scope는 같거나 작다
	@Override
	protected void deposit(int amount) {
		balance += amount;
		bonusPoint += amount * 0.001;
	}

}
