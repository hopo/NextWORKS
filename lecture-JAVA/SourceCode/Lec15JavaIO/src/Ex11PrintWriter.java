import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex11PrintWriter {

	public static void main(String[] args) throws IOException {

		PrintWriter writer = null;

		// writer = new PrintWriter(System.out); // ;; 콘솔출력: byte기반
		// writer = new PrintWriter(System.out, true); // ;; 콘솔출력: byte기반 autoflush=true(printf, println 한정)
		writer = new PrintWriter(new FileWriter("/home/pc33/io/printwriter.txt")); // ;; 파일출력, char 기반

		writer.printf("%s %d %c %s\n", "이산", 25, 'M', "010-2323-6546");
		writer.printf("%s %d %c %s\n", "보영", 33, 'F', "010-2323-2323");
		writer.printf("%s %d %c %s\n", "지디", 23, 'M', "010-2323-6546");
		writer.printf("%s %d %c %s\n", "복남", 75, 'F', "010-2323-6546");

		writer.flush();

		System.out.println("파일 출력 완료");

	}

}
