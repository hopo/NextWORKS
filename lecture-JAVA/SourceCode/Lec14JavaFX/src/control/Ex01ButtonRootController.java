package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Ex01ButtonRootController implements Initializable {
	
	@FXML CheckBox chkNikon;
	@FXML CheckBox chkCanon;
	@FXML CheckBox chkSony;

	@FXML VBox imageBox;
	
	@FXML RadioButton rdoNikon;
	@FXML RadioButton rdoCanon;
	@FXML RadioButton rdoSony;
	
	@FXML ImageView rdoImageView;
	
	@FXML ToggleGroup togGroup;
	@FXML Rectangle rectangle;
	
	ToggleGroup rdoGroup = new ToggleGroup();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// *** UI 컨트롤 초기화, 이벤트 핸들링 등록, 속성 감시 및 바인딩 ***
		
		// !! 라디오 버튼들 그루핑
		rdoNikon.setToggleGroup(rdoGroup);
		rdoCanon.setToggleGroup(rdoGroup);
		rdoSony.setToggleGroup(rdoGroup);
		
		// !! 토글 그룹에 대한 속성(Property) 감시1.
		// -> RadioButton (ImageView에 이미지 올리기)
		rdoGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				System.out.println("선택된 라디오 버튼 :" + newValue.getUserData());
				
				rdoImageView.setImage(new Image("/res/images/"+ newValue.getUserData()));
			}
		});
		
		// !! 토글 그룹에 대한 속성(Property) 감시2.
		// -> ToggleButton (shape 안에 색 채우기)
		togGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				rectangle.setFill((Color)newValue.getUserData());
			}
		});
	}
	
	public void handleChkAction(ActionEvent event) {
		
		imageBox.getChildren().clear();
		
		// ; isSelected(): 선택되었는가?
		if(chkNikon.isSelected()) {
			ImageView imageView = new ImageView();
			imageView.setImage(new Image("/res/images/" + chkNikon.getUserData()));
			imageView.setFitWidth(40);
			imageView.setFitHeight(40);
			imageBox.getChildren().add(imageView);
		}
		if(chkCanon.isSelected()) {
			ImageView imageView = new ImageView();
			imageView.setImage(new Image("/res/images/" + chkCanon.getUserData()));
			imageView.setFitWidth(40);
			imageView.setFitHeight(40);
			imageBox.getChildren().add(imageView);
		}
		if(chkSony.isSelected()) {
			ImageView imageView = new ImageView();
			imageView.setImage(new Image("/res/images/" + chkSony.getUserData()));
			imageView.setFitWidth(40);
			imageView.setFitHeight(40);
			imageBox.getChildren().add(imageView);
		}
		
	}
	
	// ! 화면 종료
	public void handleClose(ActionEvent event) {
		Platform.exit();
	}

}
