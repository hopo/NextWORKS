
public class Test {

	public static void main(String[] args) {
		String[] strArr = new String[3];

		System.out.println(strArr);
		for (int i = 0; i < strArr.length; i++) {
			System.out.print(strArr[i] + " ");
		}
		System.out.println();
		System.out.println(strArr);
		
		strArr[0] = "ddd";
		System.out.println(strArr);
		System.out.println(strArr[0]);

	}

}
