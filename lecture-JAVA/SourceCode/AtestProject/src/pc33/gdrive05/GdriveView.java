package pc33.gdrive05;

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
	
	public GdriveView() {
		makeRoot();
	}

	private static BorderPane root = new BorderPane();
	
	public Parent load() {
		gdController.handleList();
		return root;
	}

	GdriveController gdController = GdriveController.getInstance();

	private void makeRoot() {
		
		root.setPrefWidth(700);
		root.setPrefHeight(300);

		VBox vBox = new VBox();
		TextArea textArea = new TextArea();
		
		gdController.setTextArea(textArea);

		MenuBar menuBar = new MenuBar();

		// /VBox/MenuBar/Menu{FILE}
		Menu menuFile = new Menu("_FILE");
		menuFile.setMnemonicParsing(true);

		// /VBox/MenuBar/Menu{FILE}/MenuItem{list}
		MenuItem menuItemList = new MenuItem("List");
		KeyCodeCombination kccList = new KeyCodeCombination(KeyCode.L, KeyCombination.CONTROL_DOWN); 
		menuItemList.setAccelerator(kccList);
		menuItemList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gdController.handleList();
			}
		});

		// /VBox/MenuBar/Menu{FILE}/MenuItem{upload}
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

		// /VBox/MenuBar/Menu{FILE}/MenuItem{download}
		MenuItem menuItemDownload = new MenuItem("Download");
//		KeyCodeCombination kccDownload = new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_DOWN); 
//		menuItemUpload.setAccelerator(kccDownload);
		menuItemDownload.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gdController.handleDownload();
			}
		});
		
		// /VBox/MenuBar/Menu{FILE}/SepatatorMenuItem
		SeparatorMenuItem separator = new SeparatorMenuItem();

		// /VBox/MenuBar/Menu{FILE}/MenuItem{exit}
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
		root.setTop(vBox);
		root.setCenter(textArea);
	}
}
