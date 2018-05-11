package bind;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class Ex02BindRootController implements Initializable {

	@FXML TextArea textArea1;
	@FXML TextArea textArea2;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// !!! UI 컨트롤 초기화, 이벤트 핸들러 등록, 속성 감시 및 바인딩.

		/* 속성감시 */
		// 단방향 바인딩
		// textArea2.textProperty().bind(textArea1.textProperty());

		// 양방향 바인딩
		textArea2.textProperty().bindBidirectional((textArea1.textProperty()));

		// *** confer)
		// Bindings.bindBidirectional(stringProperty, otherProperty, format);

	}

}
