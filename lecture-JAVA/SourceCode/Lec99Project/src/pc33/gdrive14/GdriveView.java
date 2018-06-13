package pc33.gdrive14;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GdriveView {

	// ! GdriveView 클래스의 컨스트럭터가 호출되면 root를 만든다;
	public GdriveView() {
		makeRoot();
	}

	// ! / 'root'는 BorderPane으로 만든다
	private static BorderPane root = new BorderPane();

	// /VBox
	// ; 보더페인의 top영역
	private VBox vBox = new VBox();

	// /TextArea
	// ; 보더페인의 center영역
	private TextArea textArea = new TextArea();

	// /HBox
	// ; 보더페인의 bottom영역
	private HBox hBox = new HBox();

	// ! 뷰에서 컨트롤러를 이용할 수 있게 GdriveController 오브젝트를 생성한다; (싱글톤 방식이다);
	GdriveController gdController = GdriveController.getInstance();

	// ! 외부에서 load()를 호출하면 Parent를 리턴해준다; 컨트롤러 인스턴스의 handleList()를 콜 해주면서 리스트를 뿌려준다;
	public Parent load() {
		if (Gpath.getGdrivePath() == null) {
			textArea.appendText("제대로 작동 하지 않습니다.");
		} else {
			gdController.handleList();
		}
		return root;
	}


	/*
	 *  View의 실체 root를 만든다
	 *  
	 */
	private void makeRoot() {
		
		/*
		 *  makeRoot();
		 *   상단부1 - 메뉴바 만들기.
		 * 
		 */

		// /VBox/MenuBar
		// ;; 탑영역에 들어가는 메뉴바
		MenuBar menuBar = new MenuBar();

		// /VBox/MenuBar/Menu{FILE}
		// ;; 메뉴바에서 메뉴 FILE
		Menu menuFile = new Menu("_FILE");
		menuFile.setMnemonicParsing(true);

		// /VBox/MenuBar/Menu{FILE}/MenuItem{List}
		// ;; 메뉴바에서 메뉴 FILE 아래 메뉴아이템 List
		MenuItem menuItemList = new MenuItem("List");
		KeyCodeCombination kccList = new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN);
		menuItemList.setAccelerator(kccList);
		menuItemList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gdController.handleList();
			}
		});

		// /VBox/MenuBar/Menu{FILE}/MenuItem{Upload}
		// ;; 메뉴바에서 메뉴 FILE 아래 메뉴아이템 Upload
		MenuItem menuItemUpload = new MenuItem("Upload");
		KeyCodeCombination kccUpload = new KeyCodeCombination(KeyCode.U, KeyCombination.CONTROL_DOWN);
		menuItemUpload.setAccelerator(kccUpload);
		menuItemUpload.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gdController.handleUpload();
				gdController.handleList();
			}
		});

		// /VBox/MenuBar/Menu{FILE}/MenuItem{Download}
		// ;; 메뉴바에서 메뉴 FILE 아래 메뉴아이템 Download
		MenuItem menuItemDownload = new MenuItem("Download");
		menuItemDownload.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gdController.handleDownload();
			}
		});

		// /VBox/MenuBar/Menu{FILE}/MenuItem{Delete}
		// ;; 메뉴바에서 메뉴 FILE 아래 메뉴아이템 Delete
		MenuItem menuItemDelete = new MenuItem("Delete");
		menuItemDelete.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gdController.handleDelete();
			}
		});

		// /VBox/MenuBar/Menu{FILE}/SepatatorMenuItem
		SeparatorMenuItem separator = new SeparatorMenuItem();

		// /VBox/MenuBar/Menu{FILE}/MenuItem{Exit}
		// ;; 메뉴바에서 메뉴 FILE 아래 메뉴아이템 Exit
		MenuItem menuItemExit = new MenuItem("Exit");
		KeyCodeCombination kccExit = new KeyCodeCombination(KeyCode.W, KeyCombination.CONTROL_DOWN);
		menuItemExit.setAccelerator(kccExit);
		menuItemExit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gdController.handleExit();
			}
		});

		// /VBox/MenuBar/Menu{HELP}
		Menu menuHelp = new Menu("_HELP");
		menuFile.setMnemonicParsing(true);

		// /VBox/MenuBar/Menu{HELP}/MenuItem{about}
		MenuItem menuItemAbout = new MenuItem("about");
		menuItemAbout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gdController.handleAbout();
			}
		});
		

		/*
		 *  makeRoot();
		 *   상단부2 - 툴바 만들기.
		 *   
		 */

		// /VBox/ToolBar
		// ;; 탑영역에 들어가는 툴바
		ToolBar toolBar = new ToolBar();

		// /VBox/ToolBar/ 아래 버튼들.
		Button btnList = new Button();
		Button btnUpload = new Button();
		Button btnAbout = new Button();

		// ; 버튼에 넣을 이미지를 위한 오브젝트.
		ImageView imgView = null;
		Image img = null;

		// /VBox/ToolBar/Button{List}
		Tooltip tipList = new Tooltip("LIST: Ctrl+L");
		btnList.setTooltip(tipList);
		btnList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gdController.handleList();
			}
		});
		imgView = new ImageView();
		img = new Image("@../../res/images/new.png");
		imgView.setImage(img);
		btnList.setGraphic(imgView);

		// /VBox/ToolBar/Button{Upload}
		Tooltip tipUpload = new Tooltip("Upload: Ctrl+U");
		btnUpload.setTooltip(tipUpload);
		btnUpload.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gdController.handleUpload();
				gdController.handleList();
			}
		});
		imgView = new ImageView();
		img = new Image("@../../res/images/save.png");	//;;change img
		imgView.setImage(img);
		btnUpload.setGraphic(imgView);

		// /VBox/ToolBar/Button{About}
		Tooltip tipAbout = new Tooltip("About");
		btnAbout.setTooltip(tipAbout);
		btnAbout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gdController.handleAbout();
			}
		});
		imgView = new ImageView();
		img = new Image("@../../res/images/open-folder.png");	// ;;change img
		imgView.setImage(img);
		btnAbout.setGraphic(imgView);
		
		
		/*
		 *  makeRoot();
		 *   하단부 텍스트필드와 다운로드, 삭제버튼.
		 *   
		 */

		// /HBox/TextField
		// ;; 다운로드할 아이디를 넣는 박스
		TextField textField = new TextField();
		textField.setPrefWidth(400);
		textField.setPromptText("Insert Id");
		gdController.setTextCon(textArea, textField);

		// /HBox/Button{Download}
		// ;; 다운로할 아이디를 넘겨줄 버튼
		Button btnDownload = new Button("Download");
		btnDownload.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gdController.handleDownload();
				gdController.handleList();
			}
		});

		// /HBox/Button{Download}
		// ;; 다운로할 아이디를 넘겨줄 버튼
		Button btnDelete = new Button("Delete");
		btnDelete.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gdController.handleDelete();
				gdController.handleList();
			}
		});


		/*
		 *  makeRoot();
		 *   만들어진 control들의 setting
		 *   
		 */

		// [set] /VBox/MenuBar/Menu{FILE}/
		menuFile.getItems().add(menuItemList);
		menuFile.getItems().add(menuItemUpload);
		menuFile.getItems().add(menuItemDownload);
		menuFile.getItems().add(menuItemDelete);
		menuFile.getItems().add(separator);
		menuFile.getItems().add(menuItemExit);

		// [set] /VBox/MenuBar/Menu{HELP}/
		menuHelp.getItems().add(menuItemAbout);

		// [set] /VBox/MenuBar/
		menuBar.getMenus().add(menuFile);
		menuBar.getMenus().add(menuHelp);

		// [set] /VBox/ToolBar/
		toolBar.getItems().add(btnList);
		toolBar.getItems().add(btnUpload);
		toolBar.getItems().add(btnAbout);

		// [set] /VBox/
		vBox.getChildren().add(menuBar);
		vBox.getChildren().add(toolBar);

		// [set] /HBox/
		hBox.getChildren().add(textField);
		hBox.getChildren().add(btnDownload);
		hBox.getChildren().add(btnDelete);

		// [set] /
		root.setPrefWidth(750);
		root.setPrefHeight(300);
		root.setTop(vBox);
		root.setCenter(textArea);
		root.setBottom(hBox);

	}
}
