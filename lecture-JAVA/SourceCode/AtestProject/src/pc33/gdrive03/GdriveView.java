package pc33.gdrive03;

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
		return root;
	}

	GdriveController gdController = GdriveController.getInstance();
	GdriveCommand gdCommand = new GdriveCommand();

	private void makeRoot() {
		gdCommand.list();

		VBox vBox = new VBox();

		TextArea textArea = new TextArea();

		MenuBar menuBar = new MenuBar();

		// /VBox/MenuBar/Menu{FILE}
		Menu menuFile = new Menu("_FILE");
		menuFile.setMnemonicParsing(true);

		// /VBox/MenuBar/Menu{FILE}/MenuItem{upload}
		MenuItem menuItemUpload = new MenuItem("upload");
		KeyCodeCombination kccUpload = null; // ;; have to make shortcut
		menuItemUpload.setAccelerator(kccUpload);
		menuItemUpload.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gdController.handleUpload();
			}
		});
		
		// /VBox/MenuBar/Menu{FILE}/SepatatorMenuItem
		SeparatorMenuItem separator = new SeparatorMenuItem();

		// /VBox/MenuBar/Menu{FILE}/MenuItem{exit}
		MenuItem menuItemExit = new MenuItem("exit");
		KeyCodeCombination kccExit = new KeyCodeCombination(KeyCode.W, KeyCombination.CONTROL_DOWN);
		menuItemExit.setAccelerator(kccExit);
		menuItemExit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				gdController.handleExit();
			}
		});

		// [set] /VBox/MenuBar/Menu{FILE}/
		menuFile.getItems().add(menuItemUpload);
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
