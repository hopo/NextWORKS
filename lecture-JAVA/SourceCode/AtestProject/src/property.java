import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class property {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {

		Properties prop = new Properties();

		// ! properies.load()
		String homePath = System.getenv("HOME");
		prop.load(new FileInputStream(homePath+"/.gdrive/config.properties"));
		// Class.forName(driverClass);

		System.out.println("homePath=" + prop.getProperty("homePath"));
		System.out.println("gdrivePath=" + prop.getProperty("gdrivePath"));
		System.out.println("gdrive=" + prop.getProperty("gdrive"));

	}

}
