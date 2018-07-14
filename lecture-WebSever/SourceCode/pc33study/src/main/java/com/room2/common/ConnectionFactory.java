package com.room2.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * "오라클 데이터베이스 연결을 위한 커넥션을 생산하는 클래스"
 * 
 * @author pc33
 *
 */
public class ConnectionFactory {

	String driver;
	String url;
	String user;
	String password;
	int maxConn = 0;

	/**
	 * ! 클래스 내부에서 객체를 생성하여 getInstance()로 객체를 사용할 수 있게 한다
	 */
	private static ConnectionFactory instance = new ConnectionFactory();

	/**
	 * ! private 생성자
	 */
	private ConnectionFactory() {

		try {

			Properties prop = new Properties();
			prop.load(this.getClass().getResourceAsStream("/db.properties")); // ;;;src/main/resources/

			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			if (prop.getProperty("maxConn") != null) {
				maxConn = Integer.parseInt(prop.getProperty("maxConn"));
			}

			Class.forName(driver); // ;;;더 알아보자
			System.out.printf(">>> ConnectionFactory %s 로딩 성공\n", driver);

		} catch (Exception e) {

			e.printStackTrace(); // ;;;IOException, ClassNotFoundException

		}

	}

	/**
	 * @return ConnectionFactory
	 */
	public static ConnectionFactory getInstance() {
		if (instance == null) {
			instance = new ConnectionFactory();
		}

		return instance;
	}

	/**
	 * @return Connection
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	/**
	 * @return int
	 */
	public int getMaxConn() {
		return maxConn;
	}

}
