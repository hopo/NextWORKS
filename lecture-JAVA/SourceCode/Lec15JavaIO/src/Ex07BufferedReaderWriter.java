import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex07BufferedReaderWriter {

	public static void main(String[] args) {

		BufferedReader reader = null;
		BufferedWriter writer = null;

		try {

			reader = new BufferedReader(new FileReader("src/Ex07BufferedReaderWriter.java"));
			writer = new BufferedWriter(new FileWriter("/home/pc33/io/Ex07BufferedReaderWriter.txt"));

			while (true) {
				String str = reader.readLine(); // ;; readLine(): 라인 개행을 없애고 읽는다
				if (str == null) {
					break;
				}
				writer.write(str + "\n");
				// writer.newLine(); // ;; 라인 개행을 해준다
			}

			writer.flush(); // ;; 8kb(default) 차기 전 보내기

			System.out.println("File Write 종료.");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {

				if (reader != null) {
					reader.close();
				}
				if (writer != null) {
					writer.close();
				}
			} catch (Exception e2) {
			}

		}

	}

}
