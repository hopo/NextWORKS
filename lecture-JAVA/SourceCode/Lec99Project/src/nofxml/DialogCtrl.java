package nofxml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class DialogCtrl {

	static void openDialog(File selectedFile, TextArea txtDocument) {
		// !! file 읽어오는 Thread (work thread)
		Thread thread = new Thread() {
			@Override
			public void run() {
				BufferedReader reader = null;

				try {
					reader = new BufferedReader(new FileReader(selectedFile));
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

	static void saveDialog(File selectedFile, TextArea txtDocument) {
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
