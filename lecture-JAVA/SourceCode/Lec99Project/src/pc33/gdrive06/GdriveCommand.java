package pc33.gdrive06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javafx.scene.control.TextArea;

// 할일: gdrive 로케이션
// list 출력할 폴더
public class GdriveCommand implements Gdrivable {
	
	String gdrive = "/home/pc33/.golang/bin/gdrive";

	@Override
	public void list(TextArea textArea) {
		// ! gdrive list
		BufferedReader reader = null;
		PrintWriter writer = null;

		try {
			// ;; create a new array strings
			String[] cmdArray = new String[2];

			// ;; first argument is the program we want to open
			cmdArray[0] = gdrive;
			cmdArray[1] = "list";

			// ;; print a message
			System.out.println("$ gdrive list");

			// ;; create a process and execute cmdArray
			Process process = Runtime.getRuntime().exec(cmdArray);
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//			writer = new PrintWriter("/Users/hp/.gdrive/info/list.txt");
			writer = new PrintWriter("/home/pc33/.gdrive/info/list.txt");

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
			cmdArray[0] = gdrive;
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
	public void download(String id, String downloadDirectory) {
		// ! gdrive download ID --path ./
		try {

			// ;; create a new array of strings
			String[] cmdArray = new String[5];

			// ;; first argument is the program we want to open
			cmdArray[0] = gdrive;
			cmdArray[1] = "download";
			cmdArray[2] = id;
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
