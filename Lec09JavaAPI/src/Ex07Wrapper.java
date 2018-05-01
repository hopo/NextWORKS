
public class Ex07Wrapper {

	public static void main(String[] args) {

		Integer num1 = new Integer(10); // 0x1200; Boxing : 기본형 -> 객체
		Integer num2 = new Integer("20"); // 0x1500;
		Integer num3 = new Integer(20); // 0x1500;
		
		System.out.println("num1.hashCode() : " + num1.hashCode());
		System.out.println("num2.hashCode() : " + num2.hashCode());
		System.out.println("num3.hashCode() : " + num3.hashCode());

		// ! Unboxing Ex1)
		// num1.intValue() : Unboxing : 객체 -> 기본형
		// int sum = num1.intValue() + num2.intValue();

		// ! Unboxing Ex2)
		int sum = num1 + num2; // 자바 1.5 버전 이후. Auto Unboxing 제공
		System.out.println("sum = " + sum);
		
		disp(new Double(3.14));	// 래퍼 클래스
		disp(128.24);	// 기본형 데이터. Auto Boxing

	}
	
	public static void disp(Double d) {
		System.out.println(d);
	}

}
