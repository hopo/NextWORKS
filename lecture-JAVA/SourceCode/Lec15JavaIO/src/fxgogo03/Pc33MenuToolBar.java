package fxgogo03;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Pc33MenuToolBar extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Pc33MenuToolBarRoot.fxml")); 
		BorderPane root = loader.load();

		// ! Controller에게 primaryStage를 넘겨 준
		Pc33MenuToolBarRootController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Pc33MenuToolBar"); 
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
