package pc33.gdrive04;

import java.io.File;

import javafx.application.Platform;
import javafx.scene.control.TextArea;
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

	// Dialog dialog = new Dialog();
	GdriveCommand gdCommand = new GdriveCommand();

	public void handleList() {
		System.out.println(">>> list");
		gdCommand.list(textArea);
	}

	public void handleUpload() {
		System.out.println(">>> upload");

		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(primaryStage);

		// dialog.openDialog(file);

		if (file != null) {
			System.out.println("File Path: " + file.getPath());
			gdCommand.upload(file.getPath());
		} 

	}

	public void handleExit() {
		System.out.println(">>> Program TERMINATED.");
		Platform.exit();
	}

}
