package kr.or.nextit.board.service;

import java.util.List;
import java.util.Map;

public interface BoardService {

	/**
	 * 게시글 목록 조회
	 * 
	 * @param paramMap
	 * @return List<BoardVo>
	 * @throws Exception
	 */
	public List<BoardVo> selectBoardList(Map<String, Object> paramMap) throws Exception;

	/**
	 * 게시글 상세 조회
	 * 
	 * @param paramVo
	 * @return BoardVo
	 * @throws Exception
	 */
	public BoardVo selectBoardView(BoardVo paramVo) throws Exception;

}
