package pc33.gdrive09;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Gdrive extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		// ! GdriveView 클래스에 만들어진 root를 가져온다;
		Parent root = new GdriveView().load();

		// ! GdriveController의 오브젝트 생성;
		// 컨트롤러에서 사용할 수 있게 Stage primaryStage를 셋 해준다;
		GdriveController gdController = GdriveController.getInstance();
		gdController.setPrimaryStage(primaryStage);

		// ! 가져온 root를 이용하여 scene 오브젝트 생성;
		Scene scene = new Scene(root);

		// ! primaryStage setting 씬 셋, 타이틀 셋 그리고 화면에 보여주기;
		primaryStage.setScene(scene);
		primaryStage.setTitle("pc33.gdrive");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
