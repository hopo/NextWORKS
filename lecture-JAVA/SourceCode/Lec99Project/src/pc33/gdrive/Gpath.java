package pc33.gdrive;

import java.io.File;

public class Gpath {

	private static String homePath = System.getenv("HOME");
	private static String gdrivePath = homePath + "/.gdrive"; // ;디렉토리.
	private static String gdriveFile = gdrivePath + "/gdrive"; // ;파일.
	// private static String gdriveFile = "/usr/local/bin/gdrive";

	public static String getHomePath() {
		return homePath;
	}

	public static String getGdrivePath() {
		if (!new File(gdrivePath).exists()) {
			return null;
		}
		return gdrivePath;
	}

	public static String getGdriveFile() {
		if (!new File(gdriveFile).exists()) {
			return null;
		}
		return gdriveFile;
	}

}
