import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

// [과제 5] 키보드로부터 입력 받은 문자열을 파일로 저장하는 프로그램을 작성하시오.
public class Exam05 {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = null;
		reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("filename?: ");
		String filename = reader.readLine();
		String path = "testIO/" + filename;

		PrintWriter writer = null;
		writer = new PrintWriter(new FileWriter(path));

		System.out.println(">>> 입력하세요 ");
		System.out.println("(save and quit: /q): ");

		while (true) {
			String str = reader.readLine();
			if (str.equals("/q")) {
				break;
			}
			writer.printf(str + '\n');
		}
		writer.flush();

		System.out.println(">>> " + path + "로 파일 출력 완료.");
	}

}
