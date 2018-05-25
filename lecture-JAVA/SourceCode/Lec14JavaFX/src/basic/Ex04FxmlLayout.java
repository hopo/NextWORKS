package basic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Ex04FxmlLayout extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		HBox root = FXMLLoader.load(getClass().getResource("Ex04FxmlLayoutRoot.fxml"));

		// // *** full screen ; js question
		// Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		//
		// primaryStage.setX(primaryScreenBounds.getMinX());
		// primaryStage.setY(primaryScreenBounds.getMinY());
		// primaryStage.setWidth(primaryScreenBounds.getWidth());
		// primaryStage.setHeight(primaryScreenBounds.getHeight());

		Scene scene = new Scene(root); // Root Element

		primaryStage.setScene(scene);
		primaryStage.setTitle("Ex04FxmlLayout");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
