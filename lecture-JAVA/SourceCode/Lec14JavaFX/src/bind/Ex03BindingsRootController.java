package bind;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class Ex03BindingsRootController implements Initializable {
	@FXML AnchorPane root;
	@FXML Circle circle;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// !!! UI 컨트롤 초기화, 이벤트 핸들러 등록, 속성 감시 및 바인딩.

		// ; 연산을 위한 Bindings class
		circle.centerXProperty().bind(Bindings.divide(root.widthProperty(),2));
		circle.centerYProperty().bind(Bindings.divide(root.heightProperty(),2));

	}

}
