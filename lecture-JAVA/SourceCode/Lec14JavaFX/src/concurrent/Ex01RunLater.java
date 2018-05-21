package concurrent;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ex01RunLater extends Application {

	// !!! JavaFX Application Thread
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("Ex01RunLaterRoot.fxml"));
		
		Scene scene =  new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ex01RunLater");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
