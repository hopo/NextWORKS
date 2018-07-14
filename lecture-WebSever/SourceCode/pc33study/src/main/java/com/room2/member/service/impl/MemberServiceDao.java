package com.room2.member.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.room2.member.service.MemberVo;

/**
 * "Member 서비스를 위한 쿼리들"
 * 
 * @author pc33
 *
 */
public class MemberServiceDao {

	private static MemberServiceDao instance = new MemberServiceDao();

	private MemberServiceDao() {

	}

	public static MemberServiceDao getInstance() {
		if (instance == null) {
			instance = new MemberServiceDao();
		}
		return instance;
	}

	public List<MemberVo> selectMemberList(Connection conn, String findMem_id) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT							");
		sql.append(" 	  mem_id					");
		sql.append("  	, mem_name					");
		sql.append("  	, mem_phone					");
		sql.append("  	, mem_email					");
		sql.append("  	, reg_date					");
		sql.append("  	, mem_ip					");
		sql.append("  	, del_at					");
		sql.append(" FROM							");
		sql.append("  	tb_member					");
		sql.append(" WHERE 							");
		sql.append(" 	mem_id LIKE '%' || ? || '%' ");
		sql.append(" ORDER BY 						");
		sql.append(" 	reg_date ASC 				");

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, findMem_id);

		ResultSet rs = pstmt.executeQuery();

		// !! ResultSet -> List.add(MemberVo)
		List<MemberVo> result = new ArrayList<MemberVo>();
		while (rs.next()) {
			MemberVo item = new MemberVo();
			item.setMem_id(rs.getString("mem_id"));
			item.setMem_name(rs.getString("mem_name"));
			item.setMem_phone(rs.getString("mem_phone"));
			item.setMem_email(rs.getString("mem_email"));
			item.setReg_date(rs.getString("reg_date"));
			item.setMem_ip(rs.getString("mem_ip"));
			item.setDel_at(rs.getString("del_at"));
			;

			result.add(item);
		}

		return result;
	}

	public MemberVo selectMemberItem(Connection conn, String mem_id) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT							");
		sql.append(" 	  mem_id					");
		sql.append(" 	, mem_pwd 					");
		sql.append("  	, mem_name					");
		sql.append("  	, mem_phone					");
		sql.append("  	, mem_email					");
		sql.append(" FROM							");
		sql.append("  	tb_member					");
		sql.append(" WHERE 							");
		sql.append(" 	mem_id = ?        			");

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, mem_id);

		ResultSet rs = pstmt.executeQuery();
		rs.next();

		MemberVo result = new MemberVo();

		result.setMem_id(rs.getString("mem_id"));
		result.setMem_pwd(rs.getString("mem_pwd"));
		result.setMem_name(rs.getString("mem_name"));
		result.setMem_phone(rs.getString("mem_phone"));
		result.setMem_email(rs.getString("mem_email"));
		

		return result;
	}

}
