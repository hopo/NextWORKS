package practice;

public class AppCDInfo extends CDInfo implements Lendable {
	String borrower;
	String checkOutDate;
	byte state;
	
	AppCDInfo(String registerNo, String title, String borrower, String checkOutDate){
		super(registerNo, title);
		this.borrower = borrower;
		this.checkOutDate = checkOutDate;
	}
	
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(this.state == STATE_NORMAL) {
			this.borrower = borrower;
			this.checkOutDate = checkOutDate;
			this.state = STATE_BORROWED;
			System.out.printf("AppCD %s is borrowed: %s [%s]\n", super.title, borrower, checkOutDate);
		} else {
			System.out.printf("The CD is DENIED CHECKOUT");
		}
	}
	
	@Override
	public void checkIn() {
		this.state = STATE_NORMAL;
	}
	
}
