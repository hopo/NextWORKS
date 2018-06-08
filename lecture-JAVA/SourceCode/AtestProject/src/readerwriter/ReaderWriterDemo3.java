package readerwriter;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ReaderWriterDemo3 {

	public static void main(String[] args) throws IOException {
		
		String[] cmaArr = {"/home/pc33/.golang/bin/gdrive", "help"};
	
		Process proc = Runtime.getRuntime().exec(cmaArr);

		BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		PrintWriter writer = new PrintWriter(new FileWriter("/home/pc33/io/test0608.txt"));


		try {

			while (true) {
				String line = reader.readLine();
				if (line == null) {
					System.out.println(" >>> QUIT");
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
			} catch (Exception e2) {}
		}

	}

}
