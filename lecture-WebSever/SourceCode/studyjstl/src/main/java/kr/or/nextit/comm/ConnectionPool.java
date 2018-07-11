package kr.or.nextit.comm;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {

	private static Vector<Connection> pool = new Vector<>();

	private static ConnectionPool instance = new ConnectionPool();
	
	// ;ConnectionPool의 get인스턴스
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

	// ;pool 초기화 (sychronized)
	private synchronized void initPool() throws SQLException {
		destroyPool(); // ;clear

		ConnectionFactory factory = ConnectionFactory.getInstance();

		// ;10개(db.properties의 maxConn)의 커넥션을 pool에 add
		for (int i = 0; i < factory.getMaxConn(); i++) {
			pool.add(factory.getConnection());
		}

	}

	// ;pool의 커넥션 폐기 (sychronized) 
	private synchronized void destroyPool() throws SQLException {
		for (int i = 0; i < pool.size(); i++) {
			Connection conn = pool.get(i);
			if (conn != null) {
				conn.close();
			}
		}
		pool.clear();
	}

	// ! pool의 대여 (sychronized) 
	public synchronized Connection getConnection() throws InterruptedException {
		if (pool.size() == 0) {
			wait();
		}

		// ;;pool에서 컨 하나 빼기
		Connection conn = pool.remove(pool.size() - 1);

		return conn;
	}

	// ! 풀의 반납 (sychronized) 
	public synchronized void releaseConnection(Connection conn) {
		// ;;받아온 conn을 pool에 넣기
		pool.add(conn);
		notify();
	}

}
