package fxgogo04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Pc33MenuToolBarRootController implements Initializable {

	// ! start()로 부터 primaryStage를 받아라.
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@FXML
	TextArea textArea;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void handleNew(ActionEvent event) {
		System.out.println("CLICK: new\n");
	}

	public void handleOpen(ActionEvent event) throws IOException {
		System.out.println("CLICK: open\n");

		String openPath = handleOpenFile(event);

		System.out.println(openPath + "\n 파일을 선택하였네여!\n");

		BufferedReader reader = null;
		PrintWriter writer = new PrintWriter(System.out);
		reader = new BufferedReader(new FileReader(openPath));

		String text = ""; // ~~~ StringBuffer 생각해보자.
		while (true) {
			String str = reader.readLine();	// ;; readLine(): 라인 개행을 없애고 읽는다
			if (str == null) {
				break;
			}
			text += str + "\n";
			// writer.println(str); 	//;; consol출력시.
		}
		// writer.flush();	// ;; 8kb차기 전 보내기
		textArea.appendText(text);

		try {
			if (reader != null) {
				reader.close();
			}
			if (writer != null) {
				writer.close();
			}
		} catch (IOException e) {
		}

	}

	public void handleSave(ActionEvent event) {
		System.out.println("CLICK: save\n");
	}

	public void handleClose(ActionEvent event) {
		System.out.println(">> 프로그램 종료 <<");
		Platform.exit();
	}

	/*
	 * [[ Dialog Part ]]
	 */

	public String handleOpenFile(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();

		File openFile = fileChooser.showOpenDialog(primaryStage);

		// if (openFile != null) { System.out.println("Open File Path: " +
		// openFile.getPath());}

		if (openFile == null) {
			return null;
		}
		return openFile.getPath();
	}

	/*
	 * // ! DirectoryChoocse public void handleOpenDirectory(ActionEvent event) {
	 * DirectoryChooser directoryChooser = new DirectoryChooser();
	 * 
	 * File directory = directoryChooser.showDialog(primaryStage);
	 * 
	 * if (directory != null) { System.out.println("Directory Path: " +
	 * directory.getPath());
	 * 
	 * } }
	 */

	/*
	 * // ! handlePopup() public void handlePopup(ActionEvent event) throws
	 * IOException { Popup popup = new Popup();
	 * 
	 * HBox root = FXMLLoader.load(getClass().getResource("Ex07Popup.fxml"));
	 * 
	 * // ; '#'을 이용하여 xml tag인 id 를 기준으로 가져온다. // ; Controller가 Root.fxml이랑 1:1로
	 * 연결되어 있기 때문이다. // ;; Node 객체로 넘어오니 하위 객체로 downcasting 해준다. ImageView imageView
	 * = (ImageView) root.lookup("#imageView"); imageView.setImage(new
	 * Image("/res/images/info.png"));
	 * 
	 * Label lblMessage = (Label) root.lookup("#lblMessage");
	 * lblMessage.setText("1개의 메시지가 도착.");
	 * 
	 * popup.getContent().add(root); popup.setAutoHide(true); // ;; 포커스 이동시 자동 닫기
	 * popup.show(primaryStage);
	 * 
	 * }
	 */

	/*
	 * // ! handleCustom() public void handleCustom(ActionEvent event) throws
	 * IOException { Stage dialog = new Stage(StageStyle.UTILITY);
	 * 
	 * AnchorPane root = FXMLLoader.load(getClass().getResource("Ex07Login.fxml"));
	 * 
	 * // !! 컨트롤 lookup TextField txtId = (TextField) root.lookup("#txtId");
	 * PasswordField txtPwd = (PasswordField) root.lookup("#txtPwd"); Button
	 * btnLogin = (Button) root.lookup("#btnLogin");
	 * 
	 * // !! 이벤트 handling btnLogin.setOnAction((e) -> { String id = txtId.getText();
	 * String pwd = txtPwd.getText(); dialog.close();
	 * 
	 * System.out.println("ID: " + id + "\nPassword: " + pwd); });
	 * 
	 * Scene scene = new Scene(root); dialog.setScene(scene);
	 * 
	 * // !! Main Window Set dialog.initOwner(primaryStage); // !! Window Modal Set
	 * ; 콜하지 않는다면 modaless dialog.initModality(Modality.WINDOW_MODAL);
	 * 
	 * dialog.setTitle("로그인 화면"); dialog.show(); }
	 */

}
