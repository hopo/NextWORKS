package pc33.gdrive15;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Gpath {

	private static String homePath = System.getenv("HOME");;
	private static String downloadPath = homePath + "/Desktop";
	// private static String gdrivePath = homePath + "/.gdrive"; // ;디렉토리.
	// private static String gdrive = gdrivePath + "/gdrive"; // ;파일.

	private static String properties = homePath + "/.gdrive/config.properties";

	public static String getHomePath() {
		return homePath;
	}

	public static String getDownloadPath() {
		return downloadPath;
	}

	/*
	 * getGdrivePath(); getGdrive(); 외부 프로퍼티즈 파일에서 정보를 읽어 온다
	 * 
	 */
	public static String getGdrivePath() {
		if (!new File(properties).exists()) {
			return null;
		}

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(properties));
		} catch (Exception e) {
			e.printStackTrace();
		}

		String gdrivePath = prop.getProperty("gdrivePath");

		if (!new File(gdrivePath).exists()) {
			return null;
		}
		return gdrivePath;
	}

	public static String getGdrive() {
		if (!new File(properties).exists()) {
			return null;
		}
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(homePath + "/.gdrive/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		String gdrive = prop.getProperty("gdrive");

		if (!new File(gdrive).exists()) {
			return null;
		}
		return gdrive;
	}

}
