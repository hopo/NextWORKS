package kr.or.nextit.common.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.nextit.common.service.CodeVo;

public class ComServiceDao {

	private static ComServiceDao instance = new ComServiceDao();

	private ComServiceDao() {
	}

	public static ComServiceDao getInstance() {
		if (instance == null) {
			instance = new ComServiceDao();
		}
		return instance;
	}

	/**
	 * 
	 * 코드 리스트를 반환
	 * 
	 * @param conn
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<CodeVo> selectCodeItems(Connection conn, String param) throws Exception {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT			 			");
		sql.append("       code_parents			");
		sql.append("       , code_id			");
		sql.append("       , code_name			");
		sql.append("       , code_description	");
		sql.append("       , reg_date			");
		sql.append("       , use_at				");
		sql.append(" FROM				 		");
		sql.append(" 		tb_com_code	 		");
		sql.append(" WHERE        	 			");
		sql.append("        code_parents = ?	");

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, param);

		ResultSet rs = pstmt.executeQuery();

		List<CodeVo> result = new ArrayList<>();

		while (rs.next()) {
			CodeVo item = new CodeVo();
			item.setCodeParents(rs.getString("code_parents"));
			item.setCodeId(rs.getString("code_id"));
			item.setCodeName(rs.getString("code_name"));
			item.setCodeDescription(rs.getString("code_description"));
			item.setRegDate(rs.getString("reg_date"));
			item.setUseAt(rs.getString("use_at"));
			
			result.add(item);
		}

		return result;
	}

}
