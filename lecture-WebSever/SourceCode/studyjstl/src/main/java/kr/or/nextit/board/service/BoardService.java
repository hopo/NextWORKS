package kr.or.nextit.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {

	/**/
	public List<BoardVo> boardList(HttpServletRequest request);

	/**
	 * 글 리스트
	 * 
	 * @param request
	 * @return
	 */

	public List<BoardVo> selectBoardList(HttpServletRequest request);

	/**
	 * 글 등록
	 * 
	 * @param request
	 * @return
	 */
	public BoardVo insertBoardItem(HttpServletRequest request);
	
	/**
	 * 한 건의 글 조회
	 * 
	 * @param idx
	 * @return
	 */
	public BoardVo selectBoardItem(String idx);

	/**
	 * 한 건의 글 수정
	 * 
	 * @param request
	 * @return
	 */
	public BoardVo updateBoardItem(HttpServletRequest request);

	/**
	 * 한 건의 글 삭제
	 * 
	 * @param idx
	 * @return
	 */
	public BoardVo deleteBoardItem(String idx);
}
