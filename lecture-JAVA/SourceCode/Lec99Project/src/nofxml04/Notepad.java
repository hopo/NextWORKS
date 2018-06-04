package nofxml04;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Notepad extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = NotepadView.load();
		System.out.println("root: " + root);

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Notepad_NoFXML");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
