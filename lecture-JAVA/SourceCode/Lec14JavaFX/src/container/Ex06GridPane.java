package container;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// ..ing; check fxml file

public class Ex06GridPane extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("Ex06GridPaneRoot.fxml"));
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ex06GridPane");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) { launch(args); }
}
