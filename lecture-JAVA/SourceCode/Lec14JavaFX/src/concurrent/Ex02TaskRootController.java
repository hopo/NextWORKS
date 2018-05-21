package concurrent;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Ex02TaskRootController implements Initializable {
	
	@FXML ProgressBar progressBar;
	@FXML Label lblProgress;
	@FXML Label lblResult;
	
	Task<Integer> task;

	@Override
	public void initialize(URL location, ResourceBundle resources) {}
	
	public void handleStart(ActionEvent event) {
		lblResult.setText("");
		
		task = new Task<Integer>() {
		
			// ; 작업 상태별 callback 메서드들(succeeded(), cancelled(), failed())을 Override
			@Override
			protected void succeeded() {
				// ;; Task 클래스의 call()의 리턴 값 가져오기.
				lblResult.setText(getValue() + "");
			}
			
			@Override
			protected void cancelled() {
				lblResult.setText("취소됨.");
			}
			
			@Override
			protected void failed() {
				lblResult.setText("예외 발생.");
			}
			
			// ; Runnable.run() 과 비슷은 하지만 Task.call()은 리턴 값이 있다.
			@Override
			protected Integer call() throws Exception {
				
				int result = 0;
				
				for(int i = 1; i <=100; i++) {
					
					if(isCancelled()) { break; }

					result += i;

					// ;; Thread를 하게 되면 많이 사용하게 되는 progress와 message의 관련 메소드 
					updateProgress(i, 100);
					updateMessage(i + "");

					try { Thread.sleep(100); }
					catch (InterruptedException e) {}

				}
				
				return result;
			}
		};
		
		// ; bind()
		progressBar.progressProperty().bind(task.progressProperty());
		lblProgress.textProperty().bind(task.messageProperty());
		
		Thread thread = new Thread(task);
		
		thread.setDaemon(true);
		thread.start(); // ;; start() -> run() -> call()
	}

	public void handleStop(ActionEvent event) {
		task.cancel();
	}

}
