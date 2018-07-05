package kr.or.nextit.study.board.service;

import javax.servlet.http.HttpServletRequest;

import kr.or.nextit.study.member.service.SessionVo;

public class BoardServiceImpl implements BoardService {

	@Override
	public BoardVo setBoardItem(HttpServletRequest request) {
		BoardVo board = null;

		try {
			board = new BoardVo();

			// 저장된 리퀘스트 파라미터 가져오기
			String title = request.getParameter("title");
			board.setTitle(title);

			// 저장된 세션에서 가져오기
			SessionVo info = (SessionVo) request.getSession().getAttribute("info");
			board.setRegUser(info.getId());

			board.setContent(request.getParameter("content"));

			board.setResult(true);
			board.setMessage("나 정상 처리 되었어용~");

			return board;

		} catch (Exception ex) {
			board = new BoardVo();

			board.setResult(false);
			board.setMessage(ex.getMessage());
			ex.printStackTrace();

			return board;
		}

	}

}
