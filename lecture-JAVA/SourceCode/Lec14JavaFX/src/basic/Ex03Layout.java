package basic;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ex03Layout extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		HBox root = new HBox();
		// ; 사방테두리 Insets
		root.setPadding(new Insets(10, 10, 10, 10));
		// ; 박스 사이의 간격
		root.setSpacing(10);

		TextField textField = new TextField();
		// ; textField 폭
		textField.setPrefWidth(200);

		Button button = new Button("OK");
		// button.setText("OK");

		ObservableList<Node> list = root.getChildren();

		list.add(textField);
		list.add(button);

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Ex03Layout");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
