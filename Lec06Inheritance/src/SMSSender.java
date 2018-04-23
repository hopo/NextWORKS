
public class SMSSender extends MessageSender {
	
	// Field of SMSSender Instance
	String returnPhoneNo; // 회신 전화번호
	String message; // 메시지 내용
	
	// Constructor of SMSSender
	SMSSender(String title, String senderName, String returnPhoneNo, String message) {
		super(title, senderName);
		this.returnPhoneNo = returnPhoneNo;
		this.message = message;
	}
	
	@Override
	void sendMessage(String recpient) {
		System.out.println("=============== 문자메시지 전송 ===============");
		System.out.println("제      목 : " + title);
		System.out.println("받는  사람 : " + recpient);
		System.out.println("보내는사람 : " + senderName);
		System.out.println("회신전화번호 : " + returnPhoneNo);
		System.out.println("메시지내용 : " + message);
		System.out.println();
	}

}
