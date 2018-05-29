package notepadfx11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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

public class FxNotepadRootController implements Initializable {

	/* primaryStage 받기 위한 세터 */
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	@FXML
	TextArea txtDocument;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	// ! Menu _File
	public void handleNew(ActionEvent event) {
		System.out.println("액션: New");

		txtDocument.clear();
		primaryStage.setTitle("noname");
	}

	public void handleOpen(ActionEvent event) {
		System.out.println("액션: Open");

		FileChooser fileChooser = new FileChooser();
		File selecetedFile = fileChooser.showOpenDialog(primaryStage);

		if (selecetedFile != null) {
			// System.out.println(selecetedFile.getPath());
			primaryStage.setTitle(selecetedFile.getPath());

			// !! file 읽어오는 Thread (work thread)
			Thread thread = new Thread() {
				@Override
				public void run() {
					BufferedReader reader = null;

					try {
						reader = new BufferedReader(new FileReader(selecetedFile));
						txtDocument.clear();

						while (true) {
							String str = reader.readLine();
							if (str == null) {
								break;
							}

							// ;; 컨트롤의 변경은 JavaFX Application Thread에게로 위임
							Platform.runLater(() -> {
								txtDocument.appendText(str + "\n");
							});

							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							if (reader != null) {
								reader.close();
							}
						} catch (Exception e2) {
						}
					}
				}
			};

			thread.setDaemon(true);
			thread.start();
		}
	}

	public void handleSave(ActionEvent event) {
		System.out.println("액션: Save");

		FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showSaveDialog(primaryStage);

		if (selectedFile != null) {
			primaryStage.setTitle(selectedFile.getPath());
			PrintWriter writer = null;

			try {

				writer = new PrintWriter(new FileWriter(selectedFile));
				writer.write(txtDocument.getText());
				writer.flush();

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				writer.close();
			}

		}
	}

	public void handleExit(ActionEvent event) {
		System.out.println("액션: Exit");
		Platform.exit();
	}

	// ! Menu _Edit
	public void handleCut(ActionEvent event) {
		System.out.println("액션: Cut");
		txtDocument.cut();
	}

	public void handleCopy(ActionEvent event) {
		System.out.println("액션: Copy");
		txtDocument.copy();
	}

	public void handlePaste(ActionEvent event) {
		System.out.println("액션: Paste");
		txtDocument.paste();
	}

}
