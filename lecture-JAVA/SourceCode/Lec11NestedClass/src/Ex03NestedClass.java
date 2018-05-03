
public class Ex03NestedClass {

	int outerField1 = 10;
	int outerField2 = 10;

	public void disp() {
		System.out.println("===== Ex03NestedClass.disp() call =====");

		// ! Local Variable
		int localVar1 = 12000;
		// localVar1 = 10;

		// ! Local Inner Class
		class LocalInner {

			int innerField1 = 120;
			int innerField2 = 220;

			// ; Method의 parameter가 final이면 (아마도) Local Inner Class의 Method이다.
			public void print(final String msg) {
				System.out.println("===== LocalInner.print() call =====");
				System.out.println("outerField1 = " + outerField1);
				System.out.println("outerField2 = " + outerField2);
				System.out.println("innerField1 = " + innerField1);
				System.out.println("innerField2 = " + innerField2);
				// ;; Local Inner Class 내 변수로 사용될 시, final 또는 final 형태 데이터야 한다.
				System.out.println("localVar1 = " + localVar1); // Outer Class Member: int localVar1
				System.out.println("msg = " + msg); // Inner Class Member: String msg
			}

		}

		// ! Local Inner Class 객체 생성
		LocalInner inner = new LocalInner();
		inner.print("TEST");
	}

	public static void main(String[] args) {

		Ex03NestedClass outer = new Ex03NestedClass();
		outer.disp();

	}

}
