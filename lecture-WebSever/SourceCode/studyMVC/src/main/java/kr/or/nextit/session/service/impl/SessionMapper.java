package kr.or.nextit.session.service.impl;

import java.util.HashMap;

import kr.or.nextit.member.service.MemberVo;

public interface SessionMapper {

	/**
	 * 세션매퍼: 로그인 체크
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public MemberVo selectLoginCheck(HashMap<String, Object> params) throws Exception;

}
