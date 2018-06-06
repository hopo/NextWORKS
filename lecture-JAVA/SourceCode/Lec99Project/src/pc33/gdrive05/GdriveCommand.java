package pc33.gdrive05;

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
			writer = new PrintWriter("/Users/hp/.gdrive/info/list.txt");

			String line = "";

			textArea.clear();
			while (true) {
				line = reader.readLine();
				if (line == null) {
					break;
				}
				writer.println(line);
				textArea.appendText(line + "\n"); // ;; 훗날 수정.
			}

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

	@Override
	public void download(String Id, String downloadDirectory) {
		// ! gdrive download ID --path ./
		try {

			// ;; create a new array of strings
			String[] cmdArray = new String[5];

			// ;; first argument is the program we want to open
			cmdArray[0] = "/usr/local/bin/gdrive";
			cmdArray[1] = "download";
			cmdArray[2] = Id;
			cmdArray[3] = "--path";
			cmdArray[4] = downloadDirectory;

			// ;; print a message
			System.out.println("$ gdrive download {Id} --path {path}");

			// ;; create a process and execute cmdArray
			Process process = Runtime.getRuntime().exec(cmdArray);
			process.waitFor();

			// ;; print another message
			System.out.println(">>>  download complete: " + downloadDirectory);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
