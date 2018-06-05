package kr.or.nextit.conn;

import java.io.FileInputStream;
import java.io.IOException;
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
			Properties prop = new Properties();

			prop.load(new FileInputStream("src/db.properties"));

			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");

			if (prop.getProperty("maxConn") != null) {
				maxConn = Integer.parseInt(prop.getProperty("maxConn"));
			}

			Class.forName(driver);
			System.out.println(driver + " 로딩 성공!!");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
