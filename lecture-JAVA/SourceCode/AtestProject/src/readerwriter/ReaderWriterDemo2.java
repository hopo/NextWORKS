package readerwriter;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ReaderWriterDemo2 {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new FileWriter("/home/pc33/io/test0608.txt"));

		StringBuffer buff = new StringBuffer();

		try {

			while (true) {
				System.out.print("INPUT LINE: ");
				String line = reader.readLine();
				if (line.equals("/q")) {
					System.out.println("QUIT!!!");
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
