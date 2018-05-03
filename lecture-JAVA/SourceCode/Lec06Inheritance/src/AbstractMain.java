
public class AbstractMain {

	public static void main(String[] args) {
		// abstract class는 객체 생성이 안 된다.
		
		String title1 = "결제완료";
		String message1 = String.format("고객님께서 주문하신 상품이 정상 %s되었습니다.", title1);
		String title2 = "배송완료";
		String message2 = String.format("고객님께서 주문하신 상품이 정상 %s되었습니다.", title2); 
		
		EMailSender email1 = new EMailSender(title1, "12번가", "master@12st.co.kr", message1);
		SMSSender sms1 = new SMSSender(title1, "12번가", "02-1577-1212", message1);
		EMailSender email2 = new EMailSender(title2, "12번가", "master@12st.co.kr", message2);
		SMSSender sms2 = new SMSSender(title2, "12번가", "02-1577-1212", message2);

		// email1.sendMessage("san@naver.com");
		// sms1.sendMessage("010-1234-5678");
		// email2.sendMessage("san@naver.com");
		// sms2.sendMessage("010-1234-5678");

		// Polymorphism 속성을 이용하여
		send(email1, "san@naver.com");
		send(sms1, "010-1234-5678");
		send(email2, "san@naver.com");
		send(sms2, "010-1234-5678");

	}

	public static void send(MessageSender ms, String recipient) {

		// 상위 Class에서 추상화 된 메서드가
		// 각각의 하위 Class 에서 Overriding 된 메서드가 call 된다.
		// recipient 어떠한 객체가 들어가는냐에 따라서
		// EMailSender.sendMessage 또는 SMSSender.sendMessage
		ms.sendMessage(recipient);

	}

}
