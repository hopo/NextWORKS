package kr.or.nextit.common.service;

import java.util.List;

public interface ComService {
	
	/**
	 * 성별을 가지고 오는 녀석
	 * @return List<CodeVo>
	 */
	public List<CodeVo> selectCodeSex();

}
