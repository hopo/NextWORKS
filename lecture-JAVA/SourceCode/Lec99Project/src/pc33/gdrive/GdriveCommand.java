package pc33.gdrive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.scene.control.TextArea;

public class GdriveCommand implements Gdrivable {

	BufferedReader reader = null;
	PrintWriter writer = null;

	String gdrive = Gpath.getGdrive();
	String gdrivePath = Gpath.getGdrivePath();

	@Override
	public void list(TextArea textArea) {
		// ! gdrive list
		try {

			String[] cmdArray = { gdrive, "list" };

			System.out.println("$ gdrive list");

			Process process = Runtime.getRuntime().exec(cmdArray);
			process.waitFor();
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line = "";
			ArrayList<String> lines = new ArrayList<>();

			textArea.clear();
			while (true) {
				line = reader.readLine();
				if (line == null) {
					break;
				}
				lines.add(line);
				textArea.appendText(line + "\n");
			}

			System.out.println(">>> list print");

		} catch (

		Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
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

	@Override
	public void about(TextArea textArea) {
		try {

			String[] cmdArray = { gdrive, "about" };

			System.out.println("$ gdrive about");

			Process process = Runtime.getRuntime().exec(cmdArray);
			process.waitFor();
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line = "";

			textArea.clear();
			while (true) {
				line = reader.readLine();
				if (line == null) {
					break;
				}
				textArea.appendText(line + "\n");
			}

			System.out.println(">>> show about");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e2) {
			}
		}
	}

}
