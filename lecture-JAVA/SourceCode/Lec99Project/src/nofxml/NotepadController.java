package nofxml;

import java.io.File;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class NotepadController {
	
	DialogController dialog = new DialogController();

	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public void handleNew(ActionEvent event) {
	}

	public void handleOpen(TextArea textArea) {
		System.out.println("> handleOpen");
		FileChooser fileChooser = new FileChooser();

		File file = fileChooser.showOpenDialog(primaryStage);

		dialog.openDialog(file, textArea);

		if (file != null) {
			System.out.println("File Path: " + file.getPath());
		}

	}

	public void handleSave(ActionEvent event) {
	}

	public void handleExit() {
		System.out.println(">>> program exit");
		Platform.exit();
	}
}
