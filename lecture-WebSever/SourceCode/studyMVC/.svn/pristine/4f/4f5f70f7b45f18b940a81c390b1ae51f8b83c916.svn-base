package kr.or.nextit.board.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.nextit.board.service.BoardService;
import kr.or.nextit.board.service.BoardVo;
import kr.or.nextit.com.mybatis.MybatisSqlSessionFactory;


public class BoardServiceImpl implements BoardService {

	// ;mybatis에서 : ConnectionFactory가 하던 일
	private SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();

	private static BoardServiceImpl instance = new BoardServiceImpl();

	private BoardServiceImpl() {
	}

	public static BoardServiceImpl getInstance() {
		if (instance == null) {
			instance = new BoardServiceImpl();
		}
		return instance;
	}

	private BoardMapper boardMapper;

	@Override
	public List<BoardVo> selectBoardList(Map<String, Object> paramMap) throws Exception {

		SqlSession session = null;

		try {

			session = sqlSessionFactory.openSession();

			boardMapper = session.getMapper(BoardMapper.class);

			return boardMapper.selectBoardList(paramMap);

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		} finally {

			session.close();

		}

	}

	@Override
	public BoardVo selectBoardView(BoardVo paramVo) throws Exception {
		
		SqlSession session = null;

		try {

			session = sqlSessionFactory.openSession();

			boardMapper = session.getMapper(BoardMapper.class);

			return boardMapper.selectBoardView(paramVo);

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		} finally {
			session.close();
		}
		
	}

}
