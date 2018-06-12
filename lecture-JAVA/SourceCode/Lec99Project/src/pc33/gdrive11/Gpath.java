package pc33.gdrive11;

import java.io.File;

public class Gpath {

	private static String homePath = System.getenv("HOME");
	private static String gdrivePath = homePath + "/.gdrive"; // ;디렉토리.
	private static String gdrive = gdrivePath + "/gdrive"; // ;파일.

	public static String getHomePath() {
		return homePath;
	}

	public static String getGdrivePath() {
		if (!new File(gdrivePath).exists()) {
			return null;
		}
		return gdrivePath;
	}

	public static String getGdrive() {

		if (!new File(gdrive).exists()) {
			return null;
		}

System.out.println("!" + gdrive);
		return gdrive;
	}

}
