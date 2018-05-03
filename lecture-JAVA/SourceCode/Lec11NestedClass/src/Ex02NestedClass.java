
public class Ex02NestedClass {

	// *** Instance Member Filed
	int outerField1 = 10;
	int outerField2 = 20;
	static int outerField3 = 30;

	// *** Instance Member Method
	public void disp() {
		System.out.println("========== disp() call =========");

	}

	// *** Static Member Inner Class (Nested Class)
	static class StaticInner {
		// ** Field
		int innerField1 = 200;
		int innerField2 = 300;
		static int innerField3 = 400; // static(class) field

		public void print() {
			System.out.println("========== Inner.print() call =========");

			// ; Outer Class의 Member들을 내 것처럼 사용 가능.
//			System.out.println("outerField1" + outerField1); // Outer Class의 Instance Field 접근 불가
//			System.out.println("outerField2" + outerField2);
			System.out.println("outerField3" + outerField3);
			System.out.println("innerField1" + innerField1);
			System.out.println("innerField2" + innerField2);
		}
	}
	
	public static void main(String[] args) {
		
		// Static Inner Class 객체 생성
		Ex02NestedClass.StaticInner inner = new Ex02NestedClass.StaticInner();

		inner.print();
		
	}

}
