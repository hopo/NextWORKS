package com.room2.member.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.room2.common.ConnectionPool;
import com.room2.member.service.MemberService;
import com.room2.member.service.MemberVo;

/**
 * "MemberService 구현 클래스"
 * 
 * @author pc33
 *
 */
public class MemberServiceImpl implements MemberService {

	ConnectionPool connectionPool = ConnectionPool.getInstance();
	MemberServiceDao memberDao = MemberServiceDao.getInstance();

	public List<MemberVo> selectMemberList(HttpServletRequest req) {

		Connection conn = null;
		List<MemberVo> result = null;

		String findMem_id = req.getParameter("findMem_id");

		try {

			// !! Dao에서는 로직 수행만 할 수 있게 Service에서 conn을 관리한다
			conn = connectionPool.getConnection();
			result = memberDao.selectMemberList(conn, findMem_id);

		} catch (Exception e) {
			e.printStackTrace(); // InterruptedException, SQLException
		} finally {
			connectionPool.releaseConnection(conn);
			req.setAttribute("findMem_id", findMem_id);
		}

		return result;
	}

	public MemberVo selectMemberItem(String mem_id) {

		Connection conn = null;
		MemberVo result = null;

		try {

			conn = connectionPool.getConnection();

			result = memberDao.selectMemberItem(conn, mem_id);

		} catch (Exception e) {
			e.printStackTrace(); // InterruptedException, SQLException
		} finally {
			connectionPool.releaseConnection(conn);
		}

		return result;
	}

}
