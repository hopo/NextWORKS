package kr.or.nextit.session.serivce;

import org.springframework.stereotype.Service;

import kr.or.nextit.member.service.MemberVo;

@Service
public interface SessionService {
	
	/**
	 * @param memberVo
	 * @return
	 * @throws Exception
	 */
	public MemberVo loginCheck(MemberVo memberVo) throws Exception;

}
