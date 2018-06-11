package readerwriter;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ReaderWriterDemo {

	public static void main(String[] args) throws IOException {

		String[] cmdArr = { "which", "gdrive" };
		Process proc = Runtime.getRuntime().exec(cmdArr);
		BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

		cmdArr[0] = reader.readLine();
		// cmdArr[0] = "/usr/local/bin/gdrive"; // ;; 아마도 일반 bin 폴더
		cmdArr[1] = "help";

		Process proc2 = Runtime.getRuntime().exec(cmdArr);

		reader = new BufferedReader(new InputStreamReader(proc2.getInputStream()));

		PrintWriter writer = new PrintWriter(new FileWriter("/home/pc33/io/test0609.txt"));

		try {

			while (true) {
				String line = reader.readLine();
				if (line == null) {
					System.out.println(" >>> 파일 쓰기 완료!");
					break;
				}
				writer.println(line);
			}

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
