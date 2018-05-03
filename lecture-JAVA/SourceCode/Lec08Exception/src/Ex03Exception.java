import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex03Exception {

	public static void main(String[] args) {

		try {
			System.out.print("INPUT >> ");
			int x = System.in.read() - 48;

			switch (x) {
			case 1: throw new NullPointerException();
			case 2: throw new ArithmeticException();
			case 3: throw new ClassNotFoundException();
			case 4: throw new FileNotFoundException();
			case 5: throw new ClassCastException("5.CCE");
			case 6: throw new ArrayIndexOutOfBoundsException("6.AIOOBE");
			}

		} catch (IOException e) {
			System.out.println("!!! IO Exception occur");
		} catch (NullPointerException e) {
			System.out.println("!!! Null Pointer Exception occur");
		} catch (ArithmeticException e) {
			System.out.println("!!! Arithmetic Exception occur");
		} catch (ClassNotFoundException e) {
			System.out.println("!!! Class Not Found Exception occur");
			// } catch (FileNotFoundException e) { // IOExcetion의 하위 Class이다.
			// System.out.println("!!! File Not Found Exception occur");
		} catch (Exception e) {
			System.out.println("!!! Exception occur! " + e.getMessage());
		} finally {
			System.out.println("== here is finaly block ==");
		}

	}

}
