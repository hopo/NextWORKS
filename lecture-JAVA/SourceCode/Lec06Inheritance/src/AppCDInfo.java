
public class AppCDInfo extends CDInfo implements Lendable {
	
	String borrower;	// 대출인 
	String date;	//대출일
	int state;	//대출 상태 (0: 대출가능, 1:대출불가-대출중)
	
	public AppCDInfo(String registNo, String title) {
		super(registNo, title);
	}

	@Override
	public void checkOut(String borrower, String date) {
		System.out.println("========== 부록 CD 대출 ==========");
		if(this.state == STATE_NORMALL) {
			this.borrower = borrower;
			this.date = date;
			this.state = STATE_BORROWED;
			System.out.println(">> " + title + " 부록CD대출 되었습니다.");
		} else {
			System.out.println(">> " + title + " 부록CD대출불가");
		}
		System.out.println();
	}

	@Override
	public void checkIn() {
		this.borrower = null;
		this.date = null;
		this.state = STATE_NORMALL;
	}
	

}