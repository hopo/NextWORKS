package nofxml;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

class NotepadView {
	
	static BorderPane root;
	
	static BorderPane load() {
		makeRoot();
		return root;
	}

	static void makeRoot() {
		root = new BorderPane();

		// /VBox
		VBox vBox = new VBox();

		// /VBox/MenuBar
		MenuBar menuBar = new MenuBar();

		// /VBox/MenuBar/Menu{File}
		Menu menuFile = new Menu();
		menuFile.setText("_FILE");
		menuFile.setMnemonicParsing(true);

		//
		// ^분기 MenuItem{New}
		// /VBox/MenuBar/Menu{File}/MenuItem{New}
		MenuItem menuItemNew = new MenuItem();

		// /VBox/MenuBar/Menu{File}/MenuItem{New}/KCC
		KeyCodeCombination kccNew = new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN);
		menuItemNew.setAccelerator(kccNew);

		// /VBox/MenuBar/Menu{File}/MenuItem{New}/ImageView
		ImageView imgView = new ImageView();

		// /VBox/MenuBar/Menu{File}/MenuItem{New}/ImageView/Image
		Image img = new Image("@../../res/images/new.png");
		imgView.setImage(img);
		menuItemNew.setGraphic(imgView);

		//
		// ^분기 MenuItem{Open}
		// /VBox/MenuBar/Menu{File}/MenuItem{Open}
		MenuItem menuItemOpen = new MenuItem();

		// /VBox/MenuBar/Menu{File}/MenuItem{Open}/KCC
		KeyCodeCombination kccOpen = new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN);
		menuItemOpen.setAccelerator(kccOpen);

		// /VBox/MenuBar/Menu/MenuItem{New}/ImageView
		imgView = new ImageView();

		// /VBox/MenuBar/Menu{File}/MenuItem{Open}/ImageView/Image
		img = new Image("@../../res/images/open-folder.png");
		imgView.setImage(img);
		menuItemOpen.setGraphic(imgView);

		//
		// ^분기 MenuItem{Save}
		// /VBox/MenuBar/Menu{File}/MenuItem{Save}
		MenuItem menuItemSave = new MenuItem();

		// /VBox/MenuBar/Menu{File}/MenuItem{Save}/KCC
		KeyCodeCombination kccSave = new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN);
		menuItemSave.setAccelerator(kccSave);

		// /VBox/MenuBar/Menu/MenuItem{New}/ImageView
		imgView = new ImageView();

		// /VBox/MenuBar/Menu{File}/MenuItem{Save}/ImageView/Image
		img = new Image("@../../res/images/save.png");
		imgView.setImage(img);
		menuItemSave.setGraphic(imgView);

		//
		// ^분기 SeparatorMenuItem
		// /VBox/MenuBar/Menu{File}/SepaatorMenuItem
		SeparatorMenuItem separator = new SeparatorMenuItem();

		//
		// ^분기 MenuItem{Exit}
		// /VBox/MenuBar/Menu{File}/MenuItem{Exit}
		MenuItem menuItemExit = new MenuItem();

		// /VBox/MenuBar/Menu{File}/MenuItem{Save}/KCC
		KeyCodeCombination kccExit = new KeyCodeCombination(KeyCode.W, KeyCombination.CONTROL_DOWN);
		menuItemExit.setAccelerator(kccExit);

		menuItemExit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("close!");
				Platform.exit();
			}
		});

		//
		// /VBox/MenuBar/Menu{File}/ : MenuItem들의 추가
		menuFile.getItems().add(menuItemNew);
		menuFile.getItems().add(menuItemOpen);
		menuFile.getItems().add(menuItemSave);
		menuFile.getItems().add(separator);
		menuFile.getItems().add(menuItemExit);

		// ^
		// /VBox/MenuBar/Menu{Edit}
		Menu menuEdit = new Menu();
		menuEdit.setText("_EDIT");
		menuEdit.setMnemonicParsing(true);

		// ^
		// /VBox/MenuBar/Menu{Help}
		Menu menuHelp = new Menu();
		menuHelp.setText("_HELP");
		menuHelp.setMnemonicParsing(true);

		//
		// /VBOX/MenuBar/ : Menu들의 추가
		menuBar.getMenus().add(menuFile);
		menuBar.getMenus().add(menuEdit);
		menuBar.getMenus().add(menuHelp);

		// /VBox/ToolBar
		ToolBar toolBar = new ToolBar();

		// ^
		// /VBox/ToolBar/Button{New}
		Button btnNew = new Button();

		// /VBox/ToolBar/Button{New}/Tooltip
		Tooltip tipNew = new Tooltip("새로운파일");
		btnNew.setTooltip(tipNew);

		imgView = new ImageView();
		img = new Image("@../../res/images/new.png");
		imgView.setImage(img);
		btnNew.setGraphic(imgView);

		// ^
		// /VBox/ToolBar/Button{Open}
		Button btnOpen = new Button();

		// /VBox/ToolBar/Button{Open}/Tooltip
		Tooltip tipOpen = new Tooltip("파일열기");
		btnOpen.setTooltip(tipOpen);

		imgView = new ImageView();
		img = new Image("@../../res/images/open-folder.png");
		imgView.setImage(img);
		btnOpen.setGraphic(imgView);

		// ^
		// /VBox/ToolBar/Button{Save}
		Button btnSave = new Button();

		// /VBox/ToolBar/Button{Save}/Tooltip
		Tooltip tipSave = new Tooltip("파일저장하기");
		btnSave.setTooltip(tipSave);

		imgView = new ImageView();
		img = new Image("@../../res/images/save.png");
		imgView.setImage(img);
		btnSave.setGraphic(imgView);

		//
		// /VBox/ToolBar/ : Item 들의 추가
		toolBar.getItems().add(btnNew);
		toolBar.getItems().add(btnOpen);
		toolBar.getItems().add(btnSave);

		//
		// /VBox/ : Children 의 추가
		vBox.getChildren().add(menuBar);
		vBox.getChildren().add(toolBar);

		// ^
		// /TextArea
		TextArea textArea = new TextArea();

		//
		// / : Top & Center 세팅
		root.setTop(vBox);
		root.setCenter(textArea);
	}
}
