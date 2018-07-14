package com.room2.common;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

/**
 * "데이터베이스 커넥션들의 모임 클래스"
 * 
 * @author pc33
 *
 */
public class ConnectionPool {

	private static Vector<Connection> pool = new Vector<Connection>();
	private static ConnectionPool instance = new ConnectionPool();

	private ConnectionPool() {

		try {
			initPool();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private synchronized void initPool() throws SQLException {
		destroyPool();

		ConnectionFactory factory = ConnectionFactory.getInstance();

		for (int i = 0; i < factory.getMaxConn(); i++) {
			pool.add(factory.getConnection());
		}

	}

	private synchronized void destroyPool() throws SQLException {
		// vector for each??
		for (Connection conn : pool) {
			if (conn != null) {
				conn.close();
			}
		}
		pool.clear();
	}

	public static ConnectionPool getInstance() {
		if (instance == null) {
			instance = new ConnectionPool();
		}

		return instance;
	}

	public synchronized Connection getConnection() throws InterruptedException {
		if (pool.size() == 0) {
			wait();
		}

		return pool.remove(pool.size() - 1);
	}

	public synchronized void releaseConnection(Connection conn) {
		pool.add(conn);
		notify();
	}

}
