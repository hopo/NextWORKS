package control;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Ex07DialogRootController implements Initializable{
	
	//  !! Ex07Dialog.start()로 부터 primaryStage 받아 오기
	private Stage primaryStage;
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {}
	
	// ! handle Actions
	public void handleOpenFile(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		
		// ; 우측하단 파일 범주 설정
		fileChooser.getExtensionFilters().addAll(
					new ExtensionFilter("Text File", "*.txt"),
					new ExtensionFilter("Java File", "*.java"),
					new ExtensionFilter("FXML File", "*.fxml"),
					new ExtensionFilter("Image File", "*.jpg", "*.jpeg", "*.gif", "*.png", "*.bmp"),
					new ExtensionFilter("All File", "*.*")
				);
		
		File selectedFile = fileChooser.showOpenDialog(primaryStage);
	
		if(selectedFile != null) {
			System.out.println("Open File Path: " + selectedFile.getPath()); // ;; 파일 경로 출력
		}
	}

	public void handleSaveFile(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();

		File saveFile = fileChooser.showSaveDialog(primaryStage);
		
		if(saveFile != null) {
			System.out.println("Savae File Path: " + saveFile.getPath()); // ;; 파일 경로 출력
		}
	}

	public void handleOpenDirectory(ActionEvent event) {
		DirectoryChooser directoryChooser  = new DirectoryChooser();
		
		File directory = directoryChooser.showDialog(primaryStage);
		
		if(directory != null) {
			System.out.println("Directory Path: " + directory.getPath());
			
		}
	}

	public void handlePopup(ActionEvent event) throws IOException {
		Popup popup = new Popup();
		
		HBox root = FXMLLoader.load(getClass().getResource("Ex07Popup.fxml"));

		// ; '#'을 이용하여 xml tag인 id 를 기준으로 가져온다.
		// ; Controller가 Root.fxml이랑 1:1로 연결되어 있기 때문이다.
		// ;; Node 객체로 넘어오니 하위 객체로 downcasting 해준다.
		ImageView imageView = (ImageView)root.lookup("#imageView"); 
		imageView.setImage(new Image("/res/images/info.png"));

		Label lblMessage = (Label)root.lookup("#lblMessage");
		lblMessage.setText("1개의 메시지가 도착.");
		
		popup.getContent().add(root);
		popup.setAutoHide(true); // ;; 포커스 이동시 자동 닫기
		popup.show(primaryStage);
		
	}

	public void handleCustom(ActionEvent event) throws IOException  {
		Stage dialog = new Stage(StageStyle.UTILITY);

		AnchorPane root = FXMLLoader.load(getClass().getResource("Ex07Login.fxml"));
		
		// !! 컨트롤 lookup
		TextField txtId = (TextField) root.lookup("#txtId");
		PasswordField txtPwd = (PasswordField) root.lookup("#txtPwd");
		Button btnLogin = (Button) root.lookup("#btnLogin");
		
		// !! 이벤트 handling
		btnLogin.setOnAction((e) -> {
			String id = txtId.getText();
			String pwd = txtPwd.getText();
			dialog.close();
			
			System.out.println("ID: "+ id + "\nPassword: " + pwd);
		});
		
		Scene scene = new Scene(root);
		dialog.setScene(scene);
		
		// !! Main Window Set
		dialog.initOwner(primaryStage);
		// !! Window Modal Set ; 콜하지 않는다면 modaless
		dialog.initModality(Modality.WINDOW_MODAL);
		
		dialog.setTitle("로그인 화면");
		dialog.show();

	}

}
