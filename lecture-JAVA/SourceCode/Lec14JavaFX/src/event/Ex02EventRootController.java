package event;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Ex02EventRootController implements Initializable {

	@FXML
	Button btn1; // ;Dependency Injenction => 제어의 역전(IoC)
	@FXML
	Button btn2;
	@FXML
	Button btn3;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// *** UI 컨트롤 초기화, 이벤트 핸들러 등록, 속성 감시 및 바인딩 ***

		// * 이벤트 핸들러 등록 *
		// ;; initialize method 안에서 이벤트 처리
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("CLICK! btn1");
			}
		});
		// ;; initialize method 밖에서 이벤트 처리
		btn2.setOnAction((event) -> handleBtn2Action(event));
		// ;; *Root.fxml 파일에서 컨트롤. fxml 파일 btn3 부분에서
		// btn3.setOnAction((event) -> handleBtn2Action(event));

	}

	// ; ActionEvent에는 여러 정보가 담겨 있어 parameter로 받는다
	public void handleBtn2Action(ActionEvent event) {
		System.out.println("CLICK! btn2");
	}

	public void handleBtn3Action(ActionEvent event) {
		System.out.println("CLICK! btn3");
	}

}
