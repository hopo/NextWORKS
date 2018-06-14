

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.scene.control.TextArea;

public class GdriveCommand implements Gdrivable {

	BufferedReader reader = null;
	PrintWriter writer = null;

	String gdrive = Gpath.getGdrive(); // ;get gdrive file
	String gdrivePath = Gpath.getGdrivePath(); // ;get gdrive directory

	@Override
	public void list(TextArea textArea) {
		try {

			String[] cmdArray = { gdrive, "list" };

			Process process = Runtime.getRuntime().exec(cmdArray);
			process.waitFor();
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line = "";
			ArrayList<String> lines = new ArrayList<>();

//			textArea.clear();
			while (true) {
				line = reader.readLine();
				if (line == null) {
					break;
				}
				lines.add(line);
				textArea.appendText(line + "\n");
			}

			System.out.println(">>> List Print");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {}
		}

	}

	@Override
	public void upload(String filePath) {
		try {

			String[] cmdArray = { gdrive, "upload", filePath };

			Process process = Runtime.getRuntime().exec(cmdArray);
			process.waitFor();

			System.out.println(">>> " + filePath + " Upload Complete");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void download(String id, String downloadDirectory) {
		try {

			String[] cmdArray = { gdrive, "download", id, "--path", downloadDirectory };

			Process process = Runtime.getRuntime().exec(cmdArray);
			process.waitFor();

			System.out.println(">>>  Download Complete: " + downloadDirectory);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(String id) {
		try {

			String[] cmdArray = { gdrive, "delete", id };

			Process process = Runtime.getRuntime().exec(cmdArray);
			process.waitFor();

			System.out.println(">>>  Delete Complete!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void about(TextArea textArea) {
		try {

			String[] cmdArray = { gdrive, "about" };

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

			System.out.println(">>> Show About");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {}
		}
	}

}
