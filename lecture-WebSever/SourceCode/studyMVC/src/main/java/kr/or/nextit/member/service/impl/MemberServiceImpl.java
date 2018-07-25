package kr.or.nextit.member.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.nextit.com.mybatis.MybatisSqlSessionFactory;
import kr.or.nextit.member.service.MemberService;
import kr.or.nextit.member.service.MemberVo;

public class MemberServiceImpl implements MemberService {

	private SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();

	private static MemberServiceImpl instance = new MemberServiceImpl();

	private MemberServiceImpl() {}

	public static MemberServiceImpl getInstance() {
		if (instance == null) {
			instance = new MemberServiceImpl();
		}
		return instance;
	}

	private MemberMapper memberMapper;

	@Override
	public MemberVo insertItem(MemberVo params) throws Exception {

		SqlSession session = null;

		try {
				
			session = sqlSessionFactory.openSession();

			memberMapper = session.getMapper(MemberMapper.class);

			memberMapper.insertItem(params);

			params.setResult(true);
			params.setMessage("MemberServiceImpl.insertItem() 정상 처리 되었습니다.");

			session.commit(); // ;;;커밋을 때려 주세요

			return params;

		} catch (Exception e) {

			params = new MemberVo();

			params.setResult(false);
			params.setMessage(String.format("오까네가 알려주는 Exception : %s\n", e.getMessage()));

			session.rollback(); // ;;;실패하면 롤백

			return params;

		} finally {
			session.close();
		}

	}

	@Override
	public List<MemberVo> selectItems(MemberVo params) throws Exception {

		SqlSession session = null;

		List<MemberVo> result = null;

		try {

			session = sqlSessionFactory.openSession();
			memberMapper = session.getMapper(MemberMapper.class);

			result = memberMapper.selectItems(params);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public MemberVo selectViewItem(MemberVo params) throws Exception {

		SqlSession session = null;

		MemberVo result = null;

		try {

			session = sqlSessionFactory.openSession();
			memberMapper = session.getMapper(MemberMapper.class);
			
			result = memberMapper.selectViewItem(params);

		} catch (Exception e) {

			e.printStackTrace();
			result = null;

		} finally {
			session.close();
		}

		return result;
	}
	
	@Override
	public MemberVo updateItem(MemberVo params) throws Exception {

		SqlSession session = null;

		try {

			session = sqlSessionFactory.openSession();

			memberMapper = session.getMapper(MemberMapper.class);

			memberMapper.updateItem(params);

			params.setResult(true);
			params.setMessage("MemberServiceImpl.updateItem() 업데이트 처리 되었다.");

			session.commit(); // ;;;커밋을 때려 주세요

			return params;

		} catch (Exception e) {
			
			params = new MemberVo();
			params.setResult(false);
			params.setMessage(String.format("오까네가 알려주는 Exception : %s\n", e.getMessage()));

			session.rollback(); // ;;;실패하면 롤백

			return params;

		} finally {
			session.close();
		}

	}
	
	@Override
	public MemberVo deleteItem(MemberVo params) throws Exception {

		SqlSession session = null;

		try {

			session = sqlSessionFactory.openSession();

			memberMapper = session.getMapper(MemberMapper.class);

			memberMapper.deleteItem(params);

			params.setResult(true);
			params.setMessage("MemberServiceImpl.deleteItem() 탈퇴여부 처리 되었다.");

			session.commit(); // ;;;커밋을 때려 주세요

			return params;

		} catch (Exception e) {
			
			params = new MemberVo();
			params.setResult(false);
			params.setMessage(String.format("오까네가 알려주는 Exception : %s\n", e.getMessage()));

			session.rollback(); // ;;;실패하면 롤백

			return params;

		} finally {
			session.close();
		}
	}

}
