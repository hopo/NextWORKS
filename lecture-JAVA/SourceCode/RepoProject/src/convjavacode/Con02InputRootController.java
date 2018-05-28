package convjavacode;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Con02InputRootController implements Initializable {
	
	@FXML TextField txtTitle;
	@FXML PasswordField txtPassword;
	@FXML ComboBox<String> cmbOpen;
	@FXML DatePicker dateFinish;
	@FXML TextArea txtContent;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> items;
		items = FXCollections.observableArrayList(
					new String("공개"),
					new String("비공개")
				);
				
		cmbOpen.setItems(items);
		
		// ; default item set at ComboBox
		cmbOpen.getSelectionModel().select(1); // index
		
	}
	
	// ! 등록
	public void handleRegist(ActionEvent event) { 
		System.out.println("제    목: " + txtTitle.getText());
		System.out.println("비밀번호: " + txtPassword.getText());
		System.out.println("공개여부: " + cmbOpen.getValue());
		System.out.println("게시종료: " + dateFinish.getValue());
		System.out.println("내    용: " + txtContent.getText());
	}

	// ! 취소
	public void handleCancel(ActionEvent event) { 
		Platform.exit();
	}

}
