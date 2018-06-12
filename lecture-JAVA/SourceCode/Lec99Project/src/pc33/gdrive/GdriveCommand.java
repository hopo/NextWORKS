package pc33.gdrive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javafx.scene.control.TextArea;

public class GdriveCommand implements Gdrivable {

	BufferedReader reader = null;
	PrintWriter writer = null;

	String gdrive = Gpath.getGdriveFile();
	String gdrivePath = Gpath.getGdrivePath();

	@Override
	public void list(TextArea textArea) {

		// ! gdrive list
		try {

			String[] cmdArray = { gdrive, "list" };

			System.out.println("$ gdrive list");

			Process process = Runtime.getRuntime().exec(cmdArray);
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			writer = new PrintWriter(gdrivePath + "/list.txt");

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

		// ! gdrive upload {path}
		try {

			String[] cmdArray = { gdrive, "upload", filePath };

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

		// ! gdrive download {Id} --path {path}
		try {

			String[] cmdArray = { gdrive, "download", id, "--path", downloadDirectory };

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

		// ! gdrive delete {Id}
		try {

			String[] cmdArray = { gdrive, "delete", id };

			System.out.println("$ gdrive delete {Id}");

			Process process = Runtime.getRuntime().exec(cmdArray);
			process.waitFor();

			System.out.println(">>>  delete complete!!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
