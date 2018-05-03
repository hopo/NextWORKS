
public class SeperateVolume implements Lendable {
	String requestNo;	// 청구번호
	String writer;	// 저자
	String bookTitle;	// 책 제목

	String borrower;	// 대출인 
	String date;	//대출일
	int state;	//대출 상태 (0: 대출가능, 1:대출불가-대출중)
	
	SeperateVolume(String requestNo, String writer, String bookTitle) {
		this.requestNo = requestNo;
		this.writer = writer;
		this.bookTitle = bookTitle;
	}
	
	@Override
	public void checkOut(String borrower, String date) {
		System.out.println("========== 단행본 대출 ==========");
		if(this.state == STATE_NORMALL) {
			this.borrower = borrower;
			this.date = date;
			this.state = STATE_BORROWED;
			System.out.println(">> " + bookTitle + " 단행본 대출 되었습니다.");
		} else {
			System.out.println(">> " + bookTitle + " 단행본 대출불가");
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
