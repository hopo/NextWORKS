import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ex05FileReaderWriter {

	public static void main(String[] args) {

		FileReader reader = null;
		FileWriter writer = null;

		try {

			// #1. Stream Open
			reader = new FileReader("src/Ex05FileReaderWriter.java");
			writer = new FileWriter("/home/pc33/io/Ex05FileReaderWriter.txt");

			// #2. Stream Read & Writer
			char[] buff = new char[256];
			while (true) {
				// int x = reader.read(); // ;; 1)char
				int x = reader.read(buff); // ;; 2)char[]
				if (x < 0) {
					System.out.println("File Write Teminated.");
					break;
				}
				// writer.write(x); // ;; 1)char
				writer.write(buff, 0, x); // ;; 2)char[]
			} 

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			// #3. Stream Close
			if (reader != null) {
				try {
					reader.close(); 
				} catch (IOException e) {
				}
			}
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
				}
			}
		}
	}

}
