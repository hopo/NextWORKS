package practice;

public class SeparateVolume implements Lendable {
	String requestNo;
	String bookTitle;
	
	String borrower;
	String checkOutDate;
	byte state;
	
	
	SeparateVolume(String requestNo, String bookTitle) {
		this.requestNo = requestNo;
		this.bookTitle = bookTitle;
		this.state = STATE_NORMAL;
	}
	
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if(this.state == STATE_NORMAL) {
			this.borrower = borrower;
			this.checkOutDate = checkOutDate;
			this.state = STATE_BORROWED;
			System.out.printf(">>> Book '%s' is borrowed: %s (%s)\n", this.bookTitle, borrower, checkOutDate);
		} else {
			System.out.printf(">>> CheckOut DENIED");
		}
	}
	
	@Override
	public void checkIn() {
		this.state = STATE_NORMAL;
		System.out.println(">>> BOOK CheckIn");
	}
	
}
