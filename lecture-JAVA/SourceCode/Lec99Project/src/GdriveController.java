

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
	// ; 외부에서 끌어다 사용할 객체.
	private Stage primaryStage = null;
	private TextArea textArea = null;
	private TextField textField = null;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	public void setTextCon(TextArea textArea, TextField textField) {
		this.textArea = textArea;
		this.textField = textField;
	}

	// ! GdriveController 오브젝트 생성
	// ; 실질적인 gdrive controll 커맨드
	GdriveCommand gdCommand = new GdriveCommand();

	public void handleList() {
		System.out.println(">>> Action 'list'");
		textArea.clear();
		gdCommand.list(textArea);
		textField.clear();
	}

	public void handleUpload() {
		System.out.println(">>> Action 'upload'");
		textArea.clear();
		textArea.appendText("... UPLOAD PROCESS ...");

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
		textArea.appendText("... DOWNLOAD PROCESS ...");

		String downId = textField.getText();

		if (!downId.isEmpty()) {
			DirectoryChooser directoryChooser = new DirectoryChooser();
			File directory = directoryChooser.showDialog(primaryStage);

			if (directory != null) {
				gdCommand.download(downId, directory.getPath());
			} else {
				gdCommand.download(downId, Gpath.getDownloadPath());
			}
		}
	}

	public void handleDelete() {
		System.out.println(">>> Action 'delete'");
		textArea.clear();

		String deleteId = textField.getText();
		textArea.appendText("... DELETE PROCESS ...");

		if (!deleteId.isEmpty()) {
			gdCommand.delete(deleteId);
		}

	}

	public void handleExit() {
		System.out.println(">>> Program EXIT");
		Platform.exit();
	}

	public void handleAbout() {
		System.out.println(">>> Action 'about'");
		gdCommand.about(textArea);
	}

}
