
public interface Lendable {
	
	// public static final 자동으로 붙는다
	int STATE_NORMALL = 0;  
	int STATE_BORROWED = 1;

	// 대출하다
	void checkOut(String borrower, String date);
	
	// 반납하다
	void checkIn();

	// public abstract가 생략 되어 있다.

}
