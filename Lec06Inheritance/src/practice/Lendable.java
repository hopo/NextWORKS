package practice;

public interface Lendable {
	
	byte STATE_BORROWED = 0;
	byte STATE_NORMAL = 1;
	
	void checkOut(String borrower, String date);
	
	void checkIn();
}
