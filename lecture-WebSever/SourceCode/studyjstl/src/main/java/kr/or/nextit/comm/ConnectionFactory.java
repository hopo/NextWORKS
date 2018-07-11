package kr.or.nextit.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	String driver;
	String url;
	String user;
	String password;
	int maxConn = 0;

	private static ConnectionFactory instance = new ConnectionFactory();

	private ConnectionFactory() {

		try {

			// !properties 인스턴스 생성
			Properties prop = new Properties();
			prop.load(this.getClass().getResourceAsStream("/db.properties"));

			// !properties로부터 읽어오는 영역
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			if (prop.getProperty("maxConn") != null) {
				maxConn = Integer.parseInt(prop.getProperty("maxConn"));
			}

			// !driver 로딩
			Class.forName(driver);
			//System.out.println(driver + " 로딩 성공!"); // ;;;확인

		} catch (Exception ex) {

			// ;IOException and ClassNotFoundException
			ex.printStackTrace();

		} 
	}

	public static ConnectionFactory getInstance() {
		if(instance == null) {
			instance = new ConnectionFactory();
		}
		return instance;
	}

	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, password);

		return conn;
	}
	
	public int getMaxConn() {
		return maxConn;
	}

}
