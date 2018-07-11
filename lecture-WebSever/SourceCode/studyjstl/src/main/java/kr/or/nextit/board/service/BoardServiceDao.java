package kr.or.nextit.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardServiceDao {

	// ! Singleton Pattern.
	// ;; 메서드만 있는 클래스다 보니 객체를 여러개 생성할 필요가 없다.
	private static BoardServiceDao instance = new BoardServiceDao();

	private BoardServiceDao() {
	}

	// ;; 외부에서 호출만
	public static BoardServiceDao getInstance() {
		if (instance == null) {
			instance = new BoardServiceDao();
		}
		return instance;
	}

	// ! board 목록 조회
	// ;; call하는 쪽에서 conn을 생성 그리고 exception 처리
	public List<BoardVo> selectBoardList(Connection conn, String findTitle) throws SQLException {

		// ; query 작성
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT			 					");
		sql.append("       idx, board_type, title,		");
		sql.append("       reg_date, up_date, reg_user	");
		sql.append(" FROM				 				");
		sql.append(" 		tb_board	 				");
		sql.append(" WHERE title LIKE '%' || ? || '%'   ");
		sql.append(" ORDER BY up_date DESC, idx ASC 	");

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setString(1, findTitle);

		// ; query 실행
		ResultSet rs = pstmt.executeQuery();

		// ; result set 뿌리기
		List<BoardVo> result = new ArrayList<>();
		while (rs.next()) {
			BoardVo item = new BoardVo();
			item.setIdx(rs.getString("idx"));
			item.setBoard_type(rs.getString("board_type"));
			item.setTitle(rs.getString("title"));
			item.setReg_date(rs.getString("reg_date"));
			item.setUp_date(rs.getString("up_date"));
			item.setReg_user(rs.getString("reg_user"));

			result.add(item);
		}

		return result;
	}

	/*
	 * // ! 회원 정보 조회 public BoardVo selectBoardVo(Connection conn, String mem_id)
	 * throws SQLException {
	 * 
	 * StringBuffer query = new StringBuffer();
	 * 
	 * query.append(" SELETE			 "); query.append("       mem_id		 ");
	 * query.append("     , mem_pwd	 "); query.append("     , mem_name	 ");
	 * query.append("     , mem_phone	 "); query.append("     , mem_email	 ");
	 * query.append("     , reg_date	 "); query.append(" FROM				 ");
	 * query.append(" 		tb_BoardVo	 "); query.append(" WHERE ");
	 * query.append(" 		mem_id = ?   ");
	 * 
	 * PreparedStatement pstmt = conn.prepareStatement(query.toString());
	 * 
	 * pstmt.setString(1, mem_id); ResultSet rs = pstmt.executeQuery();
	 * 
	 * BoardVo result = null;
	 * 
	 * if (rs.next()) { BoardVo item = new BoardVo();
	 * 
	 * item.setIdx(rs.getString("idx")); item.setTitle(rs.getString("mem_pwd"));
	 * item.setReg_date(rs.getString("reg_date"));
	 * item.setUp_date(rs.getString("up_date"));
	 * item.setReg_user(rs.getString("reg_user")); }
	 * 
	 * return null; }
	 */
	// ================================================================================
	// ! board 글 등록(C)
	public int insertBoardItem(Connection conn, BoardVo params) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO tb_board ( ");
		sql.append("       idx 		  		");
		sql.append("     , board_type 		");
		sql.append("     , title			");
		sql.append("     , contents			");
		sql.append("     , reg_date			");
		sql.append("     , up_date			");
		sql.append("     , reg_user			");
		sql.append(" ) VALUES (				");
		sql.append("	   	 seq_ex.nextval ");
		sql.append(" 	   , ?				");
		sql.append(" 	   , ?				");
		sql.append(" 	   , ?				");
		sql.append(" 	   , sysdate		");
		sql.append(" 	   , sysdate		");
		sql.append(" 	   , ?				");
		sql.append(" ) 						");

		// sql.append(" select count(*) + 1 as num from tb_board "); // ?: 4
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		int updCnt;
		try {

			int i = 1;
			// pstmt.setInt(i++, Integer.parseInt(params.getIdx()));
			pstmt.setString(i++, params.getBoard_type());
			pstmt.setString(i++, params.getTitle());
			pstmt.setString(i++, params.getContents());
			pstmt.setString(i++, params.getReg_user());

			updCnt = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new SQLException("###에러가 발생하였다 : " + e.getMessage(), e);
		}

		return updCnt;
	}

	// ================================================================================
	// ! board item 하나 읽어오기(R)
	public BoardVo selectBoardItem(Connection conn, BoardVo params) throws Exception {

		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT idx 		 ");
		sql.append("      , board_type   ");
		sql.append("      , title        ");
		sql.append("      , contents     ");
		sql.append("      , reg_date     ");
		sql.append("      , up_date      ");
		sql.append("      , reg_user     ");
		sql.append(" FROM tb_board       ");
		sql.append(" WHERE idx = ?       ");

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setInt(1, Integer.parseInt(params.getIdx()));

		ResultSet rs = pstmt.executeQuery();

		BoardVo result = new BoardVo();
		if (rs.next()) {
			result.setIdx(String.format("%d", rs.getInt("idx")));
			result.setBoard_type(rs.getString("board_type"));
			result.setTitle(rs.getString("Title"));
			result.setContents(rs.getString("contents"));
			result.setReg_date(rs.getString("Reg_date"));
			result.setUp_date(rs.getString("up_date"));
			result.setReg_user(rs.getString("Reg_user"));
		}

		return result;
	}

	// ================================================================================
	// ! 한 건의 목록 수정(U)
	public int updateBoardItem(Connection conn, BoardVo params) throws Exception {

		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE						");
		sql.append("     tb_board 				");
		sql.append(" SET 						");
		sql.append("       board_type = ?		");
		sql.append("     , title = ?			");
		sql.append("     , contents = ?			");
		sql.append("     , up_date = SYSDATE	");
		sql.append("     , reg_user = ?			");
		sql.append(" WHERE						");
		sql.append(" 		 idx = ? 			");

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		int i = 1;
		pstmt.setString(i++, params.getBoard_type());
		pstmt.setString(i++, params.getTitle());
		pstmt.setString(i++, params.getContents());
		pstmt.setString(i++, params.getReg_user());
		pstmt.setInt(i++, Integer.parseInt(params.getIdx()));

		int updCnt = pstmt.executeUpdate();

		return updCnt;
	}

	// ================================================================================
	// ! 한 건의 목록 삭제(D)
	public int deleteBoardVo(Connection conn, BoardVo params) throws Exception {
		String sql = " DELETE FROM tb_board WHERE idx = ? ";

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		pstmt.setInt(1, Integer.parseInt(params.getIdx()));

		int delCnt = pstmt.executeUpdate();

		return delCnt;
	}

}
