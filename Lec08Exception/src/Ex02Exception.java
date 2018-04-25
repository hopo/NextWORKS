import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex02Exception {

	public static void main(String[] args) {

		try {
			methodA();
		} catch (NullPointerException e) {
			System.out.println("main: " + e.getMessage());

		}

		methodB();

		try {
			methodC();
		} catch (FileNotFoundException e) {
			System.out.println("main: " + e.getMessage());
			// e.printStackTrace();
		}

		System.out.println("===== PROGRAM TERM =====");

	}

	public static void methodA() {
		System.out.println(">>>>> methodA() call <<<<<");
		// 강제 Exception occur
		throw new NullPointerException("### Null Pointer Error");

	}

	public static void methodB() {
		try {
			System.out.println(">>>>> methodB() call <<<<<");
			// Checked exception
			throw new IOException("### IO Exception");
		} catch (IOException e) {
			System.out.println("methodB : " + e.getMessage());
		}

	}

	// Exception 전가
	public static void methodC() throws FileNotFoundException {
		System.out.println(">>>>> methodC() call <<<<<");
		methodD();

	}

	// Exception 전가
	public static void methodD() throws FileNotFoundException {
		System.out.println(">>>>> methodD() call <<<<<");
		throw new FileNotFoundException("### File Not Found");

	}

}
