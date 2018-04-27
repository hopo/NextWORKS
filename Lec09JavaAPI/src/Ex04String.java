
public class Ex04String {

	public static void main(String[] args) {

		String str = new String("Java String 예제");

		// ; length()
		int len = str.length();

		for (int i = 0; i < len; i++) {
			System.out.print("[" + str.charAt(i) + "]");
		}
		System.out.println();

		// !! String : literal
		String str1 = "Java는 껌이다."; // 0x1200
		// 문자열 리터럴 상수풀에 생상되어있고 같은 문자열이 존재시 재사용한다.
		// 다시, 같은 값의 문자열 리터럴이 있다면 재사용한다.

		// !! String : object
		String str2 = new String("Java는 껌이다."); // 0x1500

		// '==' 비교
		if (str1 == str2) {
			System.out.println("같은 문자열");
		} else {
			System.out.println("다른 문자열");
		}

		// ; equals()
		if (str1.equals(str2)) {
			System.out.println("같은 문자열");
		} else {
			System.out.println("다른 문자열");
		}

		String str3 = "Java Programming is 개쉽다.";

		// ; substring()
		System.out.println(str3.substring(5));
		System.out.println(str3.substring(5, 16));
		System.out.println(str3.substring(5, str3.indexOf(" is ")));

		//  ; toUpperCase(), toLowerCase()
		System.out.println(str3.toUpperCase());
		System.out.println(str3.toLowerCase());

		// ; endsWith(), startWith()
		String path = "/home/pc33/images/seolhyun.txt";
		if (path.endsWith(".jpg")) {
			System.out.println("Image File!");
		} else {
			System.out.println("Not Image File!");
		}

		String url = "http://localhost:8080/index.html";
		if (url.startsWith("http://localhost")) {
			System.out.println("Localhost!");
		} else {
			System.out.println("Not Localhost!");
		}

		// System.out.println(path.substring(path.lastIndexOf("/") + 1));
		System.out.println(path.substring(path.lastIndexOf(System.getProperty("file.separator")) + 1));

		// ; split()
		String email = "sohayng@nextit.or.kr";
		String[] strArray = email.split("@");
		System.out.println("ID : " + strArray[0]);
		System.out.println("Domain : " + strArray[1]);

	}
}
