package basic;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Ex02AppMain extends Application {
	// Stage <- Scene <- (parent <- UI)

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 모든 UI Component는 Node의 Child
		// setter getter 를 갖고 있는 관련 JavaBeans를 이용

		// Root Set
		// VBox는 Parent의 child
		// root Container로 사용할 Object 생성
		VBox root = new VBox();

		// width, height 단위는 pixel
		root.setPrefWidth(350);
		root.setPrefHeight(150);
		root.setAlignment(Pos.CENTER);
		// control 간격
		root.setSpacing(10);

		// UI - Text
		Label lblText = new Label();
		lblText.setText("JavaFX Application");
		lblText.setFont(new Font(30));

		Button button = new Button();
		button.setText("확인");

		// // Event Handling
		// // 방법1) anonymous
		// // Functional Interface인 EventHandler를 impelement하면서 setOnAction()의 parameter로 넘김
		// button.setOnAction(new EventHandler<ActionEvent>() { 
		// @Override
		// public void handle(ActionEvent event) {
	 	// // jvm 종료
		// System.exit(0);
		// // platform 종료
		// Platform.exit();
		// }
		// });

		// 방법2) lambda
		button.setOnAction((event) -> Platform.exit());

		// UI들을 Root(parent)에 담음
		root.getChildren().add(lblText);
		root.getChildren().add(button);
		
		// Root를 Scene에 올림
		Scene scene = new Scene(root);

		// Scene을 Stage에 세팅. and show();
		primaryStage.setScene(scene);
		primaryStage.setTitle("[ JavaFX 애플리케이션 ]");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
