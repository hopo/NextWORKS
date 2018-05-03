interface ISample {
	public void methodC();
}

class Sample {

	public void methodA() {
		System.out.println(">>>>> MethodA call <<<<<");
	}

	public void methodB() {
		System.out.println(">>>>> MethodB call <<<<<");
	}

}

class SampleChild extends Sample {
	@Override
	public void methodA() {
		System.out.println(">>>>> Overrided SampleChild.MethodA call <<<<<");
	}
}

public class Ex04NestedClass {

	// ! Instance Member Method
	public void printMessage(ISample s) {
		// ;; parameter로 interface를 받고 있기 때문에
		// ;; printMessage Method를 call하는 순간 ISample를 구현되어야 한다. 
		// ;; line82 : #5. 익명 중첩 클래스 생성 방식 4
		s.methodC();
	}

	public void disp() {

		System.out.println("===== Ex04NestedClass.disp() =====");

		System.out.println();
		// #1. 기존 클래스 생성 방식
		System.out.println("#1. 기존 클래스 생성 방식");
		Sample s1 = new Sample();
		s1.methodA();
		s1.methodB();
		SampleChild s2 = new SampleChild(); // SampleChild에서 오버라이드
		s2.methodA();

		System.out.println();
		// #2. 익명 중첩 클래스 생성 방식 1
		System.out.println("#2. 익명 중첩 클래스 생성 방식 Anony1");
		Sample s3 = new Sample() {
			@Override
			public void methodA() {
				System.out.println("@@@@@ 새롭게 재정의한 methodA() @@@@@");
			}
		};
		s3.methodA();
		s3.methodB();

		System.out.println();
		// #3. 익명 중첩 클래스 생성 방식 2
		System.out.println("#3. 익명 중첩 클래스 생성 방식 Anony2");
		new Sample() {
			@Override
			public void methodB() {
				System.out.println("##### 새롭게 재정의한 methodB() #####");
			}
		}.methodB();

		System.out.println();
		// #4. 익명 중첩 클래스 생성 방식 3
		// ;; Interface는 구현되기 전 객체 생성 불가.
		// ;; Anonymous Nested Class로 표현 될 때,
		// ;; Interface를 implements하며 동시에 객체 생성하는 격.
		System.out.println("#4. 익명 중첩 클래스 생성 방식 Anony3");
		new ISample() {
			@Override
			public void methodC() {
				System.out.println("^^^^^ 재정의한 methodC() ^^^^^");
			}
		}.methodC();

		System.out.println();
		// #5. 익명 중첩 클래스 생성 방식 4
		System.out.println("#5. 익명 중첩 클래스 생성 방식 Anony4");
		printMessage(new ISample() {
			@Override
			public void methodC() {
				System.out.println("$$$$$ 새롭게 태어난 methodC() $$$$$");
			}
		});
	}

	public static void main(String[] args) {

		Ex04NestedClass outer = new Ex04NestedClass();
		outer.disp();

	}

}
