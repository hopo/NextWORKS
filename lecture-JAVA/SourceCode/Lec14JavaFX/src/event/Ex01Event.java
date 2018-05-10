package event;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ex01Event extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		
//		Parent root = FXMLLoader.load(getClass().getResource("Ex01EventRoot.fxml"));
		HBox root = new HBox();
		
		// CONTAINER (layout) set --- {{{
		// * Root *
		root.setAlignment(Pos.CENTER);
		root.setSpacing(10);
		root.setPrefSize(300, 200);
		root.setPadding(new Insets(10));
		
		Button btn1 = new Button("Button1");
		Button btn2 = new Button("Button2");

		// * (children) Event Handling *
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("CLICK! Button 1");
			}
		});

		btn2.setOnAction((event) -> System.out.println("CLICK! Button 2"));
	
		root.getChildren().addAll(btn1, btn2);
		// }}} --- end line


		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ex01Event");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
	

}
