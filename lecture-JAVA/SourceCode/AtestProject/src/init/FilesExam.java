package init;

import java.io.File;

public class FilesExam {

	public static void main(String[] args) {
		// ! 환경변수 찾기.
		// System.getProperties().list(System.out);
		String env = System.getProperty("user.home").toString();
		System.out.println(env);

		env = System.getenv("HOME");
		System.out.println(env);

		// ! 파일 또는 디렉토리 존재하는가?
		String path = "/Users/hp/gdriveTest";
		File file = new File(path);

		if (file.exists()) {
			System.out.println("EXIST!");
		} else {
			System.out.println("make directory!");
			file.mkdir();
		}
	}

}
