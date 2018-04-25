import java.io.IOException;

public class Ex01Exception {

	// args : command line parameter
	public static void main(String[] args) {

		// Unchecked(Runtime) Exception 1
		// try { // exception watch
		//
		// System.out.println(args[0] + "! good to see you~");
		// System.out.println(args[1] + "! good to see you~~");
		//
		// } catch(ArrayIndexOutOfBoundsException ex) {
		//
		// System.out.println(" Catched exception : " + ex.getMessage());
		// System.out.println("Usage : java Ex01Exception Value1 Value2");
		//
		// }

		// Unchecked Exception 2
		// int num = 15;
		// int result = 0;
		// for (int i = 1; i <= 10; i++) {
		// try {
		// int x = (int) (Math.random() * 10); // 0~9
		// result = num / x; // exception position
		// System.out.println(i + " time: " + result);
		//
		// } catch (ArithmeticException ex) {
		// System.out.println("Do not divide by zero");
		// i--;
		// }
		//
		// }
	

		// Checked(Compile) Exception
		try {
			System.out.print("INPUT >> ");
			int x = System.in.read();
			System.out.println("Data = " + (char)x);
		} catch (IOException e) {
			System.out.println("catched IO Exception");
		}


	}

}
