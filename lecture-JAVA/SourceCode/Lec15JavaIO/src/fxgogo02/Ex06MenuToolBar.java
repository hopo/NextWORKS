package fxgogo02;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Ex06MenuToolBar extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Ex06MenuToolBarRoot.fxml")); 
		BorderPane root = loader.load();

		Ex06MenuToolBarRootController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ex06MenuToolBar"); 
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
