package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class Ex06MenuToolBarRootController implements Initializable {
	
	@FXML TextArea textArea;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
	
	public void handleNew(ActionEvent event) { textArea.appendText("New\n"); }
	public void handleOpen(ActionEvent event) { textArea.appendText("Open\n"); }
	public void handleSave(ActionEvent event) { textArea.appendText("Save\n"); }
	public void handleExit(ActionEvent event) { Platform.exit(); }

}
