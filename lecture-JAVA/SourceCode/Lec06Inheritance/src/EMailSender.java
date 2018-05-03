
public class EMailSender extends MessageSender {
	
	// Field of EmailSender Instance
	String senderAddr; // 발신자 이메일주소
	String emailBody; // 이메일 본문
	
	// Constructor of EMailSender
	EMailSender(String title, String senderName, String senderAddr, String emailBody) {
		super(title, senderName);
		this.senderAddr = senderAddr;
		this.emailBody = emailBody;
	}
	
	@Override
	void sendMessage(String recpient) {
		System.out.println("=============== 이메일 전송 ===============");
		System.out.println("제      목 : " + title);
		System.out.println("받는  사람 : " + recpient);
		System.out.println("보내는사람 : " + senderName);
		System.out.println("보내는사람  주소 : " + senderAddr);
		System.out.println("본      문 : " + emailBody);
		System.out.println();
		
	}
}
