package convjavacode;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class Con06MenuToolBarRootController implements Initializable  {
	
	@FXML TextArea textArea;

	@Override
	public void initialize(URL location, ResourceBundle resources) {}
	
	public void handleNew(ActionEvent event) { textArea.appendText("ActionEvent : New\n"); }
	public void handleOpen(ActionEvent event) { textArea.appendText("ActionEvent : Open\n"); }
	public void handleSave(ActionEvent event) { textArea.appendText("ActionEvent : Save\n"); }
	public void handleExit(ActionEvent event) { Platform.exit(); }
}
