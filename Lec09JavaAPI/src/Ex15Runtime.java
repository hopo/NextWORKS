import java.io.IOException;

public class Ex15Runtime {

	// ## 현재 시스템의 Process를 실행시킬 수 있는 Runtime 클래스
	public static void main(String[] args) throws IOException {
		
		
		Runtime runtime = Runtime.getRuntime();
		
		// String command = "xed abc.txt";
//		String command = "firefox www.naver.com";
		String command = "gnome-calculator";
		
		runtime.exec(command);
		
		
	}

}
