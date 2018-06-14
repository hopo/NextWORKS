package pc33.gdrive12;

import java.io.File;

import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
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
		textField.clear();
	}

	public void handleUpload() {
		System.out.println(">>> Action 'upload'");
		textArea.clear();
		textArea.appendText(">>> UPLOAD PROCESS <<<");

		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(primaryStage);

		if (file != null) {
			System.out.println("File Path: " + file.getPath());
			gdCommand.upload(file.getPath());
		}

	}

	public void handleDownload() {
		System.out.println(">>> Action 'download'");
		textArea.clear();
		textArea.appendText(">>> DOWNLOAD PROCESS <<<");

		String downName = textField.getText();
		if (!downName.isEmpty()) {
			DirectoryChooser directoryChooser = new DirectoryChooser();
			File directory = directoryChooser.showDialog(primaryStage);

			if (directory != null) {
				System.out.println("Download Directory: " + directory.getPath());
				gdCommand.download(downName, directory.getPath());
			} else {
				System.out.println("Download Directory: default Directory");
				gdCommand.download(downName, Gpath.getDownloadPath());
			}
		}
	}

	public void handleDelete() {
		System.out.println(">>> Action 'delete'");
		textArea.clear();
		textArea.appendText(">>> DELETE PROCESS <<<");

		String deleteName = textField.getText();

		if (!deleteName.isEmpty()) {
			gdCommand.delete(deleteName);
		}

	}

	public void handleExit() {
		System.out.println(">>> Program TERMINATED.");
		Platform.exit();
	}

	// !!! popup 사용할것인가?
	// public void handlePopup() throws IOException {
	// Popup popup = new Popup();
	//
	// HBox root = new HBox();
	// root.prefHeight(30.0);
	// root.prefWidth(250.0);
	//
	// Label lblMessage = new Label("MESSAGE");
	// lblMessage.setTextFill(Paint.valueOf("#eeeeee"));
	//
	// root.getChildren().add(lblMessage);
	//
	// lblMessage.setText("1개의 메시지가 도착.");
	//
	// popup.getContent().add(root);
	// popup.setAutoHide(true); // ;; 포커스 이동시 자동 닫기
	// popup.show(primaryStage);

	// }

}
