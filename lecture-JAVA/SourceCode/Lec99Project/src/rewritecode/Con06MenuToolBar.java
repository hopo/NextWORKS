package rewritecode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Con06MenuToolBar extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		/* [[ Parent Object ]] */

		/* 1.Static 메서드 load()를 이용하여 Parent 변수에 바로 assignment */
		// Parent root =
		// FXMLLoader.load(getClass().getResource("Con06MenuToolBarRoot.fxml"));

		/* 2.1을 쪼개어 보기 */
		FXMLLoader loader = null;
		loader = new FXMLLoader(getClass().getResource("Con06MenuToolBarRoot.fxml"));
		Parent root = loader.load();
		
		
		/* [[ Scene Object ]] */
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Con06MenuToolBar");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
