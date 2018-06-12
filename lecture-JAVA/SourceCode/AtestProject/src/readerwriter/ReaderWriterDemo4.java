package readerwriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderWriterDemo4 {

	public static void main(String[] args) throws IOException {

		String[] cmdArr = { "which", "gdrive" };
		Process proc = Runtime.getRuntime().exec(cmdArr);
		BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		
		String x = reader.readLine();
		System.out.println(x);

	}
}
