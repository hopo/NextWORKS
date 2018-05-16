package control;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class Ex04MediaViewRootController implements Initializable {

	@FXML MediaView mediaView;
	@FXML Button btnPlay;
	@FXML Button btnPause;
	@FXML Button btnStop;

	@FXML ProgressBar progressBar;
	@FXML ProgressIndicator progressIndicator;
	@FXML Label lblTime;
	@FXML Slider slider;
	
	boolean endOfMedia = false;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// ! Media File Loading
		File mediaFile = new File("media/StayWithMeMV.m4v");
		String source = mediaFile.toURI().toString();

		Media media = new Media(source);
		MediaPlayer mediaPlayer = new MediaPlayer(media);

		mediaView.setMediaPlayer(mediaPlayer);

		// ! Event Handling
		btnPlay.setOnAction((event) -> {
			if(endOfMedia) {
				mediaPlayer.stop();
				endOfMedia = false;
			}
			mediaPlayer.play();

		});
		btnPause.setOnAction((event) -> { mediaPlayer.pause(); });
		btnStop.setOnAction((event) -> { mediaPlayer.stop(); });

		// ! Media Player 상태에 따른 제어
		mediaPlayer.setOnReady(() -> {
			System.out.println("setOnReady....");

			mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
				@Override
				public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {

					// ;; 처리상태 = 현재시간 / 전체시간
					double progress = mediaPlayer.getCurrentTime().toSeconds() / mediaPlayer.getTotalDuration().toSeconds();

					progressBar.setProgress(progress); // ; 범위 0.0 ~ 1.0
					progressIndicator.setProgress(progress);
					
					// ;; 시간 레이블
					lblTime.setText(
						(int)mediaPlayer.getCurrentTime().toSeconds() + "/"+ (int)mediaPlayer.getTotalDuration().toSeconds() + " sec"
					);
				}
			});

			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(true);

		});

		mediaPlayer.setOnPlaying(() -> {
			System.out.println("setOnPlaying....");

			btnPlay.setDisable(true);
			btnPause.setDisable(false);
			btnStop.setDisable(false);
		});

		mediaPlayer.setOnPaused(() -> {
			System.out.println("setOnPaused....");

			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(false);
		});

		mediaPlayer.setOnStopped(() -> {
			System.out.println("setOnStopped....");

			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(true);
		});

		mediaPlayer.setOnEndOfMedia(() -> {
			System.out.println("setOnEndOfMedia....");
			endOfMedia = true;
			
			progressBar.setProgress(1.0);
			progressIndicator.setProgress(1.0);

			btnPlay.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(false);
		});
		
		
		// ! Volume Control
		slider.setMax(1.0); // ; 슬라이더의 max값을 1.0으로 셋 (기본 100)
		slider.setValue(0.5);
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				System.out.println("volume check: " + (int)(newValue.doubleValue()*100) + "%");
				// mediaPlayer.setVolume(newValue.doubleValue() / 100);
				mediaPlayer.setVolume(newValue.doubleValue());
			}
		});

	}

}
