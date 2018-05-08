package basic;

import javafx.application.Application;
import javafx.stage.Stage;

public class Ex01AppMain extends Application {

	
	public Ex01AppMain() {
		System.out.println(Thread.currentThread().getName() + " : 생성자 실행."); // 2 |JavaFX Application Thread
	}
	
	@Override
	public void init() throws Exception {
		System.out.println(Thread.currentThread().getName() + " : init() 실행."); // 3 |JavaFX-Launcher

	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(Thread.currentThread().getName() + " : start() 실행."); // 4 |JavaFX Application Thread
		
		primaryStage.setTitle("JavaFX Application");
		primaryStage.show();
		
	}
	
	@Override
	public void stop() throws Exception {
		System.out.println(Thread.currentThread().getName() + " : stop() 실행."); // 5 |JavaFX Application Thread
	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " : main() 실행."); // 1  |main
		launch(args);
	}
	

}
