package pc33.gdrive05;

import java.io.File;

import javafx.application.Platform;
import javafx.scene.control.TextArea;
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

	public void setTextArea(TextArea textArea) {
		this.textArea = textArea;
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
		String Id = "19vYy3YYYhEPzo6R6CXe7Df0Sg245QnoL"; // ;; 다운로드할 파일 선택하기.

		DirectoryChooser directoryChooser = new DirectoryChooser();
		File directory = directoryChooser.showDialog(primaryStage);

		if (directory != null) {
			System.out.println("Download Directory: " + directory.getPath());
			gdCommand.download(Id, directory.getPath());
		} else {
			System.out.println("Download Directory: default Directory");
			gdCommand.download(Id, "/Users/hp/Downloads");

		}
	}

	public void handleExit() {
		System.out.println(">>> Program TERMINATED.");
		Platform.exit();
	}

}
