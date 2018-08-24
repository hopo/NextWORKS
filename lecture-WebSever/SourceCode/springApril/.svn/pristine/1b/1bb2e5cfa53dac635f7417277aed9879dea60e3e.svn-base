package kr.or.nextit.session.serivce.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.member.service.MemberVo;
import kr.or.nextit.session.serivce.SessionService;


@Service("SessionService")
public class SessionServiceImpl implements SessionService {
	
	@Autowired
	private SessionMapper sessionMapper;
	
	@Override
	public MemberVo loginCheck(MemberVo memberVo) throws Exception {
		
		MemberVo result = sessionMapper.loginCheck(memberVo);
		
		if(memberVo.getMemId().equals(result.getMemId())) {
			result.setResult(true);
			result.setMessage("***LOGIN SUCCESS");

			return result;
		} else {
			
			throw new Exception("***LOGIN FAIL");
		}
	}

}
