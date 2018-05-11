package bind;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.text.Font;

public class Ex01PropertyRootController implements Initializable {

	@FXML
	Label label;
	@FXML
	Slider slider;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// !!! UI 컨트롤 초기화, 이벤트 핸들러 등록, 속성 감시 및 바인딩.

		/* 속성 감시 */
		// addListener() 제너릭 Number부터 super
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println("oldValue: " + oldValue);
				System.out.println("newValue: " + newValue);
				
				label.setFont(new Font(newValue.doubleValue()));
			}
		});

	}

}
