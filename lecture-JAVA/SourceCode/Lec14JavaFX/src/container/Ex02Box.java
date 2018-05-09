package container;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ex02Box extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("Ex02BoxRoot.fxml"));
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ex02Box");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) { launch(args); }
}
