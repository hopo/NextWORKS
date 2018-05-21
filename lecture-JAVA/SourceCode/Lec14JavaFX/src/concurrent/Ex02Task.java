package concurrent;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ex02Task extends Application {

	// !!! JavaFX Application Thread
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("Ex02TaskRoot.fxml"));
		
		Scene scene =  new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ex02Task");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
