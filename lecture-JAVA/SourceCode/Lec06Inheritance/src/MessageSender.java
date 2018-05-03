
public abstract class MessageSender {

	// 공통 필드
	String title; // 제목
	String senderName; // 보내는 사람

	MessageSender(String title, String senderName) {
		this.title = title;
		this.senderName = senderName;
	}

	// 공통 추상 메서드
	// 메시지를 송신기능.
	abstract void sendMessage(String recpient);

}
