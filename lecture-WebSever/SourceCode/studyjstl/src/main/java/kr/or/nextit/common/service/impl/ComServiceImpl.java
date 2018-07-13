package kr.or.nextit.common.service.impl;

import java.sql.Connection;
import java.util.List;

import kr.or.nextit.comm.ConnectionPool;
import kr.or.nextit.common.service.CodeVo;
import kr.or.nextit.common.service.ComService;

public class ComServiceImpl implements ComService {

	private ConnectionPool connectionPool = ConnectionPool.getInstance();
	private ComServiceDao comDao = ComServiceDao.getInstance();

	@Override
	public List<CodeVo> selectCodeSex() {
		Connection conn = null;
		List<CodeVo> result = null;

		try {

			conn = connectionPool.getConnection();

			result = comDao.selectCodeItems(conn, "sex");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectionPool.releaseConnection(conn);
		}

		return result;
	}

}
