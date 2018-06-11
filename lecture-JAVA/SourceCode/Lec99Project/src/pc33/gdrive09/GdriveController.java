package pc33.gdrive09;

import java.io.File;
import java.io.IOException;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class GdriveController {

	// ! GdriveController 컨스트럭터 (private)
	// ! 외부에서 인스턴스를 부를 수 있게 한다(싱글톤)
	private GdriveController() {
	}

	private static GdriveController instance = new GdriveController();

	public static GdriveController getInstance() {
		return instance;
	}

	// ! 이 클래스 내에서 Stage를 사용 하기 위해 받아오는 메서드
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	// ! 이 클래스 내에서 TextArea, TextField를 사용 하기 위해 받아오는 메서드
	private TextArea textArea = null;
	private TextField textField = null;

	public void setTextCon(TextArea textArea, TextField textField) {
		this.textArea = textArea;
		this.textField = textField;
	}

	// ! 실질적인 커맨드를 사용하기 위해 GdriveController 오브젝트 생성
	GdriveCommand gdCommand = new GdriveCommand();

	public void handleList() {
		System.out.println(">>> Action 'list' ");
		gdCommand.list(textArea);
	}

	public void handleUpload() {
		System.out.println(">>> Action 'upload'");

		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(primaryStage);

		if (file != null) {
			System.out.println("File Path: " + file.getPath());
			gdCommand.upload(file.getPath());
		}

	}

	public void handleDownload() {
		System.out.println(">>> Action 'download'");

		String downId = textField.getText();

		DirectoryChooser directoryChooser = new DirectoryChooser();
		File directory = directoryChooser.showDialog(primaryStage);
		textField.clear();

		if (directory != null) {
			System.out.println("Download Directory: " + directory.getPath());
			gdCommand.download(downId, directory.getPath());
		} else {
			System.out.println("Download Directory: default Directory");
			 gdCommand.download(downId, "/Users/hp/Downloads");
//			gdCommand.download(downId, "/home/pc33/Downloads");

		}
	}

	public void handleDelete() {
		System.out.println(">>> Action 'delete'");

		String deleteId = textField.getText();
		textField.clear();

		gdCommand.delete(deleteId);

	}

	public void handleExit() {
		System.out.println(">>> Program TERMINATED.");
		Platform.exit();
	}
	
	// !!! popup 사용할것인가?
	public void handlePopup() throws IOException {
		Popup popup = new Popup();
		
		HBox root = new HBox();
		root.prefHeight(30.0);
		root.prefWidth(250.0);
		
		Label lblMessage = new Label("MESSAGE");
		lblMessage.setTextFill(Paint.valueOf("#eeeeee"));
		
		root.getChildren().add(lblMessage);

		lblMessage.setText("1개의 메시지가 도착.");
		
		popup.getContent().add(root);
		popup.setAutoHide(true); // ;; 포커스 이동시 자동 닫기
		popup.show(primaryStage);
		
	}

}
