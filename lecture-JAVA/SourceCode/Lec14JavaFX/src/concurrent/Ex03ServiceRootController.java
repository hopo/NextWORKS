package concurrent;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Ex03ServiceRootController implements Initializable {

	@FXML ProgressBar progressBar;
	@FXML Label lblProgress;
	@FXML Label lblResult;

	TimeService service;

	// ; Member Inner Class
	class TimeService extends Service<Integer> {

		@Override
		protected Task<Integer> createTask() {
			Task<Integer> task = new Task<Integer>() {

				@Override
				protected void succeeded() { lblResult.setText(getValue() + ""); }

				@Override
				protected void cancelled() { lblResult.setText("취소됨."); }

				@Override
				protected void failed() { lblResult.setText("예외 발생."); }

				@Override
				protected Integer call() throws Exception {
					int result = 0;

					for (int i = 1; i <= 100; i++) {
						if (isCancelled()) { break; }

						result += i;

						updateProgress(i, 100);
						updateMessage(i + "");

						try { Thread.sleep(100); }
						catch (InterruptedException e) {}
					}

					return result;
				}
			};
	
			progressBar.progressProperty().bind(task.progressProperty());
			lblProgress.textProperty().bind(task.messageProperty());

			return task;
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new TimeService();
		service.start();
	}

	public void handleStart(ActionEvent event) {
		//service = new TimeService();
		//service.start();
		lblResult.setText("");
		service.restart();
	}

	public void handleStop(ActionEvent event) {
		service.cancel();
	}

}
