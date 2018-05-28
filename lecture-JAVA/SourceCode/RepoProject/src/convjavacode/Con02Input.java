package convjavacode;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Con02Input extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Parent root = FXMLLoader.load(getClass().getResource("Con02InputRoot.fxml"));
		
		AnchorPane root = new AnchorPane();

		Separator separator = new Separator();
		separator.setLayoutX(47.0);
		separator.setLayoutY(385.0);
		separator.setPrefHeight(26.0);
		separator.setPrefWidth(447.0);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Con02Input");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) { launch(args); }
}