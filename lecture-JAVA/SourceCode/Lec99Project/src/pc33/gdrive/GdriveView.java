package pc33.gdrive;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class GdriveView {

	/*
	 * GdriveView 클래스의 컨스트럭터 컨스트럭터가 호출되면 root를 만든다;
	 * 
	 */
	public GdriveView() {
		makeRoot();
	}

	/*
	 * root는 BorderPane으로 만든다;
	 */
	private static BorderPane root = new BorderPane();

	/*
	 * 뷰에서 컨트롤러를 이용할 수 있게 GdriveController 오브젝트를 생성한다; (싱글톤 방식이다);
	 */
	GdriveController gdController = GdriveController.getInstance();

	/*
	 * 외부에서 load()를 호출하면 Parent를 리턴해준다; 컨트롤러 인스턴스의 handleList()를 콜 해주면서 리스트를 뿌려준다;
	 */
	public Parent load() {
		gdController.handleList();
		return root;
	}

	/*
	 * 뷰의 실체 root를 만든다; makeRoot();
	 */
	private void makeRoot() {

		// /VBox
		// | 보더페인의 탑영역
		VBox vBox = new VBox();

		/*
		 * ! 컨트롤러에서 TextArea를 사용할 수 있게 넘겨준다;
		 */

		// /TextArea
		// | 보더페인의 센터영역
		TextArea textArea = new TextArea();
		gdController.setTextArea(textArea);

		MenuBar menuBar = new MenuBar();

		// /VBox/MenuBar/Menu{FILE}
		// | 메뉴바에서 메뉴 FILE
		Menu menuFile = new Menu("_FILE");
		menuFile.setMnemonicParsing(true);

		// /VBox/MenuBar/Menu{FILE}/MenuItem{List}
		// | 메뉴바에서 메뉴 FILE 아래 메뉴아이템 List
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
		// | 메뉴바에서 메뉴 FILE 아래 메뉴아이템 Upload
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
		// | 메뉴바에서 메뉴 FILE 아래 메뉴아이템 Download
		MenuItem menuItemDownload = new MenuItem("Download");
		// KeyCodeCombination kccDownload = new KeyCodeCombination(KeyCode.D,
		// KeyCombination.CONTROL_DOWN);
		// menuItemUpload.setAccelerator(kccDownload);
		menuItemDownload.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gdController.handleDownload();
			}
		});

		// /VBox/MenuBar/Menu{FILE}/SepatatorMenuItem
		SeparatorMenuItem separator = new SeparatorMenuItem();

		// /VBox/MenuBar/Menu{FILE}/MenuItem{Exit}
		// | 메뉴바에서 메뉴 FILE 아래 메뉴아이템 Exit
		MenuItem menuItemExit = new MenuItem("Exit");
		KeyCodeCombination kccExit = new KeyCodeCombination(KeyCode.W, KeyCombination.CONTROL_DOWN);
		menuItemExit.setAccelerator(kccExit);
		menuItemExit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gdController.handleExit();
			}
		});

		// [set] /VBox/MenuBar/Menu{FILE}/
		menuFile.getItems().add(menuItemList);
		menuFile.getItems().add(menuItemUpload);
		menuFile.getItems().add(menuItemDownload);
		menuFile.getItems().add(separator);
		menuFile.getItems().add(menuItemExit);

		// /VBox/MenuBar/Menu{HELP}
		Menu menuHelp = new Menu("_HELP");
		menuFile.setMnemonicParsing(true);

		// /VBox/MenuBar/Menu{HELP}/MenuItem{about}
		MenuItem menuItemAbout = new MenuItem("about");

		// [set] /VBox/MenuBar/Menu{HELP}/
		menuHelp.getItems().add(menuItemAbout);

		// [set] /VBox/MenuBar/
		menuBar.getMenus().add(menuFile);
		menuBar.getMenus().add(menuHelp);

		// [set] /VBox/
		vBox.getChildren().add(menuBar);

		// [set] /
		root.setPrefWidth(700);
		root.setPrefHeight(300);
		root.setTop(vBox);
		root.setCenter(textArea);
	}
}
