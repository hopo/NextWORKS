package pc33.gdrive07;

import java.io.File;

import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class GdriveController {

	private GdriveController() {
	}

	private static GdriveController instance = new GdriveController();

	public static GdriveController getInstance() {
		return instance;
	}

	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	private TextArea textArea = null;
	private TextField textField = null;

	public void setTextCon(TextArea textArea, TextField textField) {
		this.textArea = textArea;
		this.textField = textField;
	}

	GdriveCommand gdCommand = new GdriveCommand();

	public void handleList() {
		System.out.println(">>> Action 'list' ");
		gdCommand.list(textArea);
	}

	public void handleUpload() {
		System.out.println(">>> Action 'upload'");

		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(primaryStage);

		if (file != null) {
			System.out.println("File Path: " + file.getPath());
			gdCommand.upload(file.getPath());
		}

	}

	public void handleDownload() {
		System.out.println(">>> Action 'download'");

		// String id = "19vYy3YYYhEPzo6R6CXe7Df0Sg245QnoL"; // ;; 다운로드할 파일 선택하기.
		String downId = textField.getText();

		DirectoryChooser directoryChooser = new DirectoryChooser();
		File directory = directoryChooser.showDialog(primaryStage);
		textField.clear();

		if (directory != null) {
			System.out.println("Download Directory: " + directory.getPath());
			gdCommand.download(downId, directory.getPath());
		} else {
			System.out.println("Download Directory: default Directory");
			// gdCommand.download(downId, "/Users/hp/Downloads");
			gdCommand.download(downId, "/home/pc33/Downloads");

		}
	}

	public void handleDelete() {
		System.out.println(">>> Action 'delete'");

		String deleteId = textField.getText();
		textField.clear();
		
		gdCommand.delete(deleteId);

	}

	public void handleExit() {
		System.out.println(">>> Program TERMINATED.");
		Platform.exit();
	}

}
