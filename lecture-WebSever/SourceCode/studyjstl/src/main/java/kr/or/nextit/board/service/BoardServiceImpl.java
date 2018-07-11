package kr.or.nextit.board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.or.nextit.comm.ConnectionPool;

public class BoardServiceImpl implements BoardService {

	// ; ConnectionPool 와 BoardServiceDao 를 사용하겠다!
	ConnectionPool connectionPool = ConnectionPool.getInstance();
	BoardServiceDao boardDao = BoardServiceDao.getInstance();

	@Override
	public List<BoardVo> boardList(HttpServletRequest request) {

		String findTitle = request.getParameter("findTitle");

		List<BoardVo> result = new ArrayList<>();

		// 1.드라이버 로딩
		// ---------------------------------------
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver"); // ;;import 오라클 드라이버

			// 2.연결설정
			// -----------------------------------
			// conn = connectionPool.getConnection();

			// !! QUERY
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT ");
			sql.append(" 	idx, board_type, title, reg_date, up_date, reg_user ");
			sql.append(" FROM ");
			sql.append(" 	tb_board ");
			sql.append(" WHERE title LIKE '%' || ? || '%' ");
			sql.append(" ORDER BY ");
			sql.append(" 	up_date DESC ");
			sql.append(" 	,idx ASC ");

			// 3.구문객체 생성
			// ---------------------------------------
			pstmt = conn.prepareStatement(sql.toString()); // ;쿼리 객체 생성
			pstmt.setString(1, findTitle);

			// 4.구문객체 실행
			// -------------------------------------
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVo item = new BoardVo();
				item.setIdx(rs.getString("idx"));
				item.setBoard_type(rs.getString("board_type"));
				item.setTitle(rs.getString("title"));
				item.setReg_date(rs.getString("reg_date"));
				item.setUp_date(rs.getString("up_date"));
				item.setReg_user(rs.getString("reg_user"));

				result.add(item); // ;;각각의 레코드를 List에 추가
			}

			request.setAttribute("findTitle", ((findTitle != null) ? findTitle : "")); // ;;elTag로 사용 가능하게 한다

		} catch (Exception ex) {
			// ;;SQLExceiption and ClassNotFoundExceoption

			System.out.println(ex);
			ex.printStackTrace();

		} finally {

			// 5. 자원 해제
			// -------------------------------------
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			}

			// 6. DB커넥션 해제
			// -------------------------------------
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
				}
			}

		}

		return result;
	}

	@Override
	public List<BoardVo> selectBoardList(HttpServletRequest request) {

		// ;Connction을 사용할것이다.
		Connection conn = null;

		// ;List<Board>의 타입으로 리턴할 것이다.
		List<BoardVo> result = null;

		// ;파라미터 값으로 넘어오는 'findTitle'
		String findTitle = request.getParameter("findTitle");

		try {

			// ;; connectionPool로 부터 사용할 Connection을 받아온다
			conn = connectionPool.getConnection();

			// ;; boardDao에 있는 select쿼리를 사용하겠다
			result = boardDao.selectBoardList(conn, findTitle);

		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			// ;; 릴리즈 커넥션
			connectionPool.releaseConnection(conn);
			request.setAttribute("findTitle", findTitle);

		}

		return result;
	}

	// !목록에다 한 건의 레코드를 입력한다
	@Override
	public BoardVo insertBoardItem(HttpServletRequest request) {
		Connection conn = null;

		// List<BoardVo> result = null;

		BoardVo params = new BoardVo();

		params.setBoard_type(request.getParameter("board_type"));
		params.setTitle(request.getParameter("title"));
		params.setContents(request.getParameter("contents"));
		params.setReg_user(request.getParameter("reg_user"));

		try {

			// params.setIdx("9"); // (임시)인서트 아이디 값
			// ;Unique id 를 사용 할 수도 있다. //UUID.randomUUID().toString();

			conn = connectionPool.getConnection();

			boardDao.insertBoardItem(conn, params);

			params.setResult(true);
			params.setMessage("정상 등록 되었습니다.");

		} catch (Exception ex) {
			params.setResult(false);
			params.setMessage(ex.getMessage());
			ex.printStackTrace();

		} finally {
			connectionPool.releaseConnection(conn);
		}

		return params;
	}

	// !한 건의 목록을 조회한다
	@Override
	public BoardVo selectBoardItem(String idx) {

		Connection conn = null;

		BoardVo params = new BoardVo();
		BoardVo result = null;
		params.setIdx(idx);

		try {
			conn = connectionPool.getConnection();

			result = boardDao.selectBoardItem(conn, params);

			return result;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectionPool.releaseConnection(conn);
		}

		return result;
	}

	// !한 건의 목록을 수정한다
	@Override
	public BoardVo updateBoardItem(HttpServletRequest request) {
		BoardVo params = new BoardVo();
		params.setIdx(request.getParameter("idx"));
		params.setReg_user(request.getParameter("reg_user"));
		params.setTitle(request.getParameter("title"));
		params.setContents(request.getParameter("contents"));
		params.setBoard_type(request.getParameter("board_type"));

		Connection conn = null;

		try {

			conn = connectionPool.getConnection();

			int updCnt = boardDao.updateBoardItem(conn, params);

			params.setResult(true);
			params.setMessage(String.format("%d 건이 수정 되었다.", updCnt));

			request.setAttribute("item", params);

		} catch (Exception e) {
			params.setResult(false);
			params.setMessage(e.getMessage());
			e.printStackTrace();
		} finally {
			connectionPool.releaseConnection(conn);
		}

		return params;
	}

	// !한 건의 목록을 삭제한다
	@Override
	public BoardVo deleteBoardItem(String idx) {
		BoardVo params = new BoardVo();
		params.setIdx(idx);

		Connection conn = null;

		try {
			conn = connectionPool.getConnection();

			int delCnt = boardDao.deleteBoardVo(conn, params);

			params.setResult(true);
			params.setMessage(String.format("%d 건이 삭제 되었다.", delCnt));
		} catch (Exception e) {
			params.setResult(false);
			params.setMessage(e.getMessage());
			e.printStackTrace();
		} finally {
			connectionPool.releaseConnection(conn);
		}

		return params;
	}
}
