package practice;

public class AppCDInfo extends CDInfo implements Lendable {
	String borrower;
	String checkOutDate;
	byte state;
	
	AppCDInfo(String registerNo, String title){
		super(registerNo, title);
        this.state = STATE_NORMAL;
	}

    @Override
	public void checkOut(String borrower, String checkOutDate) {
		if(this.state == STATE_NORMAL) {
			this.borrower = borrower;
			this.checkOutDate = checkOutDate;
			this.state = STATE_BORROWED;
			System.out.printf(">>> AppCD '%s' is borrowed: %s (%s)\n", super.title, borrower, checkOutDate);
		} else {
			System.out.printf(">>> CheckOut DENIED");
		}
	}
	
	@Override
	public void checkIn() {
		this.state = STATE_NORMAL;
		System.out.println(">>> CD CheckIn");
	}
	
}
