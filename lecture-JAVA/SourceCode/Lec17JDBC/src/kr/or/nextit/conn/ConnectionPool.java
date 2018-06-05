package kr.or.nextit.conn;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {

	// ! 커넥션 풀
	private static Vector<Connection> pool = new Vector<>();

	private static ConnectionPool instance = new ConnectionPool();
	
	public static ConnectionPool getInstance() {
		if(instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
		
	}

	private ConnectionPool() {

		try {
			initPool();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// ! 풀 초기화
	private synchronized void initPool() throws SQLException {

		destroyPool();

		ConnectionFactory factory = ConnectionFactory.getInstance();

		// ; 10개의 커넥션을 풀에 add
		for (int i = 0; i < factory.getMaxConn(); i++) {
			pool.add(factory.getConnection());
		}

	}

	// ! 풀의 커넥션 폐기
	private synchronized void destroyPool() throws SQLException {

		for (int i = 0; i < pool.size(); i++) {
			Connection conn = pool.get(i);
			if (conn != null) {
				conn.close();
			}
		}
		pool.clear();
	}

	// ! 풀의 대여
	public synchronized Connection getConnection() throws InterruptedException {

		if (pool.size() == 0) {
			wait();
		}

		Connection conn = pool.remove(pool.size() - 1);

		return conn;
	}

	// ! 풀의 반납
	public synchronized void releaseConnection(Connection conn) {
		pool.add(conn);
		notify();
	}

}
