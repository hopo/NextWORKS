
public class Ex01NestedClass {

	// *** Instance Member Filed
	int outerField1 = 10;
	int outerField2 = 20;

	// *** Instance Member Method
	public void disp() {
		System.out.println("========== disp() call =========");

		Inner inner = new Inner();
		inner.print();
	}

	// *** Instance Member Inner Class (Nested Class)
	class Inner {
		// ** Field
		int innerField1 = 200;
		int innerField2 = 300;

		public void print() {
			System.out.println("========== Inner.print() call =========");

			// ; Outer Class의 Member들을 내 것처럼 사용 가능.
			System.out.println("outerField1" + outerField1);
			System.out.println("outerField2" + outerField2);
			System.out.println("innerField1" + innerField1);
			System.out.println("innerField2" + innerField2);

			// Ex01NestedClass obj = new Ex01NestedClass();
			// obj.outerField1 = 1500;
			// obj.disp();
		}
	}

	public static void main(String[] args) {

		// 외부 클래스 또는 static 메서드에서 Inner 클래스 생성.
		Ex01NestedClass outer = new Ex01NestedClass();
		
		Ex01NestedClass.Inner inner = outer.new Inner();
		
		inner.print();

		// outer.disp();

	}

}
