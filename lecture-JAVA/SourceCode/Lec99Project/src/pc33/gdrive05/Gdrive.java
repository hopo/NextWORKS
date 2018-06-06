package pc33.gdrive05;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Gdrive extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = new GdriveView().load();

		GdriveController gdController = GdriveController.getInstance();
		gdController.setPrimaryStage(primaryStage);

		Scene scene = new Scene(root);

		// ! primaryStage setting
		primaryStage.setScene(scene);
		primaryStage.setTitle("pc33.gdrive");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
