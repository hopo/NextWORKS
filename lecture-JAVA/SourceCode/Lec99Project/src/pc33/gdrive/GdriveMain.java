package pc33.gdrive;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pc33.gdrive.view.GdriveView;

public class GdriveMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = GdriveView.load();

		Scene scene = new Scene(root);

		// ! primaryStage setting
		primaryStage.setScene(scene);
		primaryStage.setTitle("gdrive");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
