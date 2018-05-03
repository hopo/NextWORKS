import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// *Inheritance Relation : Hashtable <- Properties
public class Ex08Properties {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Properties prop = new Properties();

		// // ! properies.setProperty()
		// prop.setProperty("user_id", "san");
		// prop.setProperty("user_name", "이산");
		// prop.put("user_pwd", 1234); // Property Class는 setProperty()를 이용하세요
		//
		// System.out.println("user_id=" + prop.getProperty("user_id"));

		// ! properies.load()
		prop.load(new FileInputStream("src/application.properties"));
		// Class.forName(driverClass);

		System.out.println("driver=" + prop.getProperty("driver"));
		System.out.println("url=" + prop.getProperty("url"));
		System.out.println("user=" + prop.getProperty("user"));
		System.out.println("password=" + prop.getProperty("password"));

		// // ! xml 파일에 저장
		// prop.storeToXML(new FileOutputStream("application.xml"), "JDBC
		// Configuration");
		// System.out.println("xml 파일이 만들어졌습니다.");

	}

}
