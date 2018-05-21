package concurrent;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Ex01RunLaterRootController implements Initializable {
	
	@FXML Label lblTime;
	
	boolean stop = false;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {}
	
	public void handleStart(ActionEvent event) {
		stop = false;

		// ; 현재시간을 불러오기
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		
		// !! Worker Thread
		Thread thread = new Thread() {
			@Override
			public void run() {
				while(!stop) {
					String strTime = dateFormat.format(new Date());
					// ;; UI 변경은 JavaFX Application Thread에게 위임
					Platform.runLater(() -> { lblTime.setText(strTime); });
					
					try { Thread.sleep(100); }
					catch (InterruptedException e) {}
				}
			}
		};

		thread.setDaemon(true);
		thread.start();
	}

	public void handleStop(ActionEvent event) {
		stop = true;
	}

}
