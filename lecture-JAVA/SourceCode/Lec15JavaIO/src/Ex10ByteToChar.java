import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ex10ByteToChar {

	public static void main(String[] args) throws IOException {

		InputStreamReader reader = null;
		OutputStreamWriter writer = null;

		reader = new InputStreamReader(System.in); // ;; byte 기반으로 입력 받으나 문자기반으로 읽는다
		writer = new OutputStreamWriter(new FileOutputStream("/home/pc33/io/memo.txt")); // ;; byte 기반으로 입력 받으나 문자기반으로 읽는다

		System.out.println(">> 메모를 남겨주세요ㅕ. <<");

		while (true) {
			int x = reader.read();
			if (x < 0) {	// ;; 이클립스 콘솔에서는 ctrl-d
				System.out.println("끝이오");
				break;
			}
			writer.write(x);
		}
		writer.flush();	// ;; 버퍼를 쓰는 놈들이규나!

	}

}
