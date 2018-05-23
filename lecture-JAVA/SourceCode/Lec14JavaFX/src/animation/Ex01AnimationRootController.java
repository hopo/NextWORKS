package animation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Ex01AnimationRootController implements Initializable {
	
	@FXML Button btnLogin;

	@Override
	public void initialize(URL location, ResourceBundle resources) {}
	
	public void handleLogin(ActionEvent event) throws IOException {
		
		// ! Login 화면 loading
		Parent login = FXMLLoader.load(getClass().getResource("Ex01Login.fxml"));
		
		StackPane root = (StackPane)btnLogin.getScene().getRoot();

		// ! Login 화면 추가
		root.getChildren().add(login);

		// !! 애니메이션 효과 (불투명도)
		login.setOpacity(0); // ;; value 범위 0.0 ~ 1.0

		// !! 타겟 속성, 종료값으로 구성
		KeyValue keyValue = new KeyValue(login.opacityProperty(), 1);

		// !! 애니메이션 속성의 지속시간
		KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
		
		// !! Play
		Timeline timeline = new Timeline();
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();

	}

}
