package pc33.gdrive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javafx.scene.control.TextArea;

// 할일: gdrive 로케이션
// list 출력할 폴더
public class GdriveCommand implements Gdrivable {
	BufferedReader reader = null;
	PrintWriter writer = null;
	String gdrive = null; // ;; 훗날 수정 프로그램 초기화 문제

	public GdriveCommand() {
		String[] cmdArr = { "which", "gdrive" };

		try {

			Process proc = Runtime.getRuntime().exec(cmdArr);
			reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

			gdrive = reader.readLine();

		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("Not install!!");
		}
	}

	@Override
	public void list(TextArea textArea) {
		// ! gdrive list

		try {

			String[] cmdArray = { gdrive, "list" };

			// cmdArray[0] = gdrive;
			// cmdArray[1] = "list";

			System.out.println("$ gdrive list");

			Process process = Runtime.getRuntime().exec(cmdArray);
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			// writer = new PrintWriter("/Users/hp/.gdrive/info/list.txt");

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

			String[] cmdArray = { gdrive, "upload", filePath };

			// cmdArray[0] = gdrive;
			// cmdArray[1] = "upload";
			// cmdArray[2] = filePath;

			System.out.println("$ gdrive upload {path}");

			Process process = Runtime.getRuntime().exec(cmdArray);
			process.waitFor();

			System.out.println(">>> " + filePath + " upload complete");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void download(String id, String downloadDirectory) {
		// ! gdrive download ID --path ./
		try {

			String[] cmdArray = { gdrive, "download", id, "--path", downloadDirectory };

			// cmdArray[0] = gdrive;
			// cmdArray[1] = "download";
			// cmdArray[2] = id;
			// cmdArray[3] = "--path";
			// cmdArray[4] = downloadDirectory;

			System.out.println("$ gdrive download {Id} --path {path}");

			Process process = Runtime.getRuntime().exec(cmdArray);
			process.waitFor();

			System.out.println(">>>  download complete: " + downloadDirectory);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(String id) {

		try {

			String[] cmdArray = { gdrive, "delete", id };

			// cmdArray[0] = gdrive;
			// cmdArray[1] = "delete";
			// cmdArray[2] = id;

			System.out.println("$ gdrive delete {Id}");

			Process process = Runtime.getRuntime().exec(cmdArray);
			process.waitFor();

			System.out.println(">>>  delete complete!!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
