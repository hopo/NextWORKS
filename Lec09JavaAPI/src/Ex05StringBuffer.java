
public class Ex05StringBuffer {

	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer("Java Programming is "); // 초기값 16문자

		// ; length(), capcaity()
		System.out.println("length() : " + sb.length());
		System.out.println("capacity() : " + sb.capacity());

		// !! 문자열 조작 메서드
		// ; append(), insert(), delete()
		System.out.println("append() : " + sb.append("껌이다."));
		System.out.println("insert() : " + sb.insert(20, "not "));
		System.out.println("append() : " + sb.delete(20, 24));

		// // !! String VS StringBuffer 속도 비교
		// String str = "자바 쌤은 ";
		// StringBuffer sb2 = new StringBuffer("자바 쌤은 ");
		//
		// // a)String
		// long startTime = System.currentTimeMillis();
		// for(int i = 0; i < 20000; i++) {
		// str += "개멋쪄";
		//
		// }
		// long duration = System.currentTimeMillis() - startTime;
		// System.out.println(">> String 경과시간: " + duration);
		//
		// // b)StringBuffer
		// startTime = System.currentTimeMillis();
		// for(int i = 0; i < 20000; i++) {
		// sb2.append("개멋쪄");
		//
		// }
		// duration = System.currentTimeMillis() - startTime;
		// System.out.println(">> StringBuffer 경과시간: " + duration);

	}

}
