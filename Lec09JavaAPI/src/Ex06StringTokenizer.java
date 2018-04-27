import java.util.StringTokenizer;

public class Ex06StringTokenizer {

	public static void main(String[] args) {
		
		// !!! Overloading StringTokenizer()

		// // exA)
		// String str = "지디 태양 탑 승리 대성";
		// StringTokenizer st = new StringTokenizer(str); // 구분자: "/s"(default)
		//
		// while(st.hasMoreTokens()) {
		// String name = st.nextToken();
		// System.out.println(name);
		// }

		// // exB)
		// String str = "지디,태양,탑,승리,대성"; // CommaSeperateValues
		// StringTokenizer st = new StringTokenizer(str, ",");
		//
		// while (st.hasMoreTokens()) {
		// String name = st.nextToken();
		// System.out.println(name);
		// }

		// // exC)
		// String str = "지디,태양|탑@승리-대성"; // CommaSeperateValues
		// StringTokenizer st = new StringTokenizer(str, ",|@-"); // 다중 구분자
		//
		// while (st.hasMoreTokens()) {
		// String name = st.nextToken();
		// System.out.println(name);
		// }

		// exD)
		String str = "지디,태양|탑@승리-대성"; // CommaSeperateValues
		StringTokenizer st = new StringTokenizer(str, ",|@-", true); // 구분자 포함 출력 

		while (st.hasMoreTokens()) {
			String name = st.nextToken();
			System.out.println(name);
		}
	}

}
