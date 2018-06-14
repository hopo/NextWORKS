package pc33.gdrive04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javafx.scene.control.TextArea;

public class GdriveCommand implements Gdrivable {

	@Override
	public void list(TextArea textArea) {
		// ! gdrive list
		BufferedReader reader = null;
		PrintWriter writer = null;

		try {
			// ;; create a new array strings
			String[] cmdArray = new String[2];

			// ;; first argument is the program we want to open
			cmdArray[0] = "/usr/local/bin/gdrive";
			cmdArray[1] = "list";

			// ;; print a message
			System.out.println("$ gdrive list");

			// ;; create a process and execute cmdArray
			Process process = Runtime.getRuntime().exec(cmdArray);
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			writer = new PrintWriter("/Users/hp/.gdrive/info/list.txt"); // ;; 일단은 콘솔출력.

			String line = "";
			StringBuffer sbuf = new StringBuffer();
			
			textArea.clear();
			while (true) {
				if ((line = reader.readLine()) == null) {
					break;
				}
				sbuf.append(line + "\n");
				textArea.appendText(line + "\n"); // ;; 훗날 수정.
			}

			writer.println(sbuf);
			writer.flush();
			System.out.println(">>> list print");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException e) {
			}
		}

	}

	@Override
	public void download() {
		// ! gdrive download ID --path ./

	}

	@Override
	public void upload(String filePath) {
		// ! gdrive upload ./

		try {

			// ;; create a new array of 2 strings
			String[] cmdArray = new String[3];

			// ;; first argument is the program we want to open
			cmdArray[0] = "/usr/local/bin/gdrive";
			cmdArray[1] = "upload";

			// ;; second argument is a txt file we want to open with notepad
			cmdArray[2] = filePath;

			// ;; print a message
			System.out.println("$ gdrive upload {path}");

			// ;; create a process and execute cmdArray
			Process process = Runtime.getRuntime().exec(cmdArray);
			process.waitFor();

			// ;; print another message
			System.out.println(">>> " + filePath + " upload complete");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
