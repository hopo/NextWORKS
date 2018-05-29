package notepadfx11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// *** sensei
public class FxNotepad extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("FxNotepadRoot.fxml"));

		Parent root = loader.load(); // ;; load()는 인스턴스, 클래스 메서드 둘다 있음
		
		FxNotepadRootController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("FxNotepad");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
