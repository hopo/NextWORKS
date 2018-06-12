package pc33.gdrive;

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

		String downId = textField.getText();
		if (!downId.isEmpty()) {
			DirectoryChooser directoryChooser = new DirectoryChooser();
			File directory = directoryChooser.showDialog(primaryStage);

			if (directory != null) {
				System.out.println("Download Directory: " + directory.getPath());
				gdCommand.download(downId, directory.getPath());
			} else {
				System.out.println("Download Directory: default Directory");
				gdCommand.download(downId, Gpath.getDownloadPath());
			}
		}
	}

	public void handleDelete() {
		System.out.println(">>> Action 'delete'");
		textArea.clear();
		textArea.appendText(">>> DELETE PROCESS <<<");

		String deleteId = textField.getText();

		if (!deleteId.isEmpty()) {
			gdCommand.delete(deleteId);
		}

	}

	public void handleExit() {
		System.out.println(">>> Program TERMINATED.");
		Platform.exit();
	}

	public void handleAbout() {
		System.out.println(">>> Action 'about' ");
		gdCommand.about(textArea);
	}

}
