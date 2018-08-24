package kr.or.nextit.session.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.member.service.MemberVo;
import kr.or.nextit.session.service.SessionService;

@Service("SessionService") // *LoginController @Resource
public class SessionServiceImpl implements SessionService {

	@Autowired
	private SessionMapper sessionMapper;

	@Override
	public MemberVo loginCheck(MemberVo memberVo, HashMap<String, Object> params) throws Exception {

		MemberVo result = null;

		result = sessionMapper.selectLoginCheck(params);

		if (memberVo.getMemId().equals(result.getMemId())) {

			result.setResult(true);
			result.setMessage("*** 정상 로그인 되었다");

			return result;

		} else {

			// result.setResult(false);
			// result.setMessage("*** 로그인 실패다");
			// return result;

			throw new Exception("*** 로그인 실패다");

		}

	}

}
