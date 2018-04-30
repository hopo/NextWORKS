import java.text.MessageFormat;

public class Ex12MessageFormat {

	public static void main(String[] args) {

		String message = "회원 ID : {0} / 회원이름 : {1} / 전화번호 : {2}"; 

		String id = "san";
		String name = "이산";
		String phone = "010-123-5678";

		Object[] arguements = { id, name, phone }; // array를 이용할 때.
		// String message = prop.getProperty("common.message"); // property를 이용할 때.

		// System.out.println(MessageFormat.format(message, id, name, phone));
		System.out.println(MessageFormat.format(message, arguements));

	}

}
