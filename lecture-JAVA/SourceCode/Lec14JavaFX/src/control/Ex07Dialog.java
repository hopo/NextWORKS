package control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


// * 웹에서 Popup을 JavaFX에서는 Dialog(modal  성격)라고 부른다 *
// * JavaFX에서 Popup(modeless 성격)을 작은 창들 *
public class Ex07Dialog extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// !! Dialog를 사용하기 위하여 FXMLLoader 객체에 담아 사용
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Ex07DialogRoot.fxml"));
		Parent root = loader.load();
		
		// !! Ex07DialogRootController쪽에서 primaryStage를 이용할 수 있게 set
		Ex07DialogRootController controller = loader.getController();
		controller.setPrimaryStage(primaryStage);
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ex07Dialog");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) { launch(args); }
}
