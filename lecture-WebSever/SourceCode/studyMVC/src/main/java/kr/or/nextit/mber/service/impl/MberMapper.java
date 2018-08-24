package kr.or.nextit.mber.service.impl;

import java.util.List;

import kr.or.nextit.member.service.MemberSearchVo;
import kr.or.nextit.member.service.MemberVo;

public interface MberMapper {

	/**
	 * id체크를 위한 인터페이스 Mber매퍼
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public MemberVo selectIdCheck(MemberVo params) throws Exception;

	/**
	 * 회원 정보 등록
	 * 
	 * @param memberVo
	 * @throws Exception
	 */
	public void insertMemberItem(MemberVo memberVo) throws Exception;

	/**
	 * 회원 목록을 가져온다
	 * 
	 * @param memberSearchVo
	 * @return
	 * @throws Exception
	 */
	public List<MemberVo> selectMemberList(MemberSearchVo memberSearchVo) throws Exception;

	/**
	 * @param memberSearchVo
	 * @return
	 * @throws Exception
	 */
	public int selectTotalCount(MemberSearchVo memberSearchVo) throws Exception;
}
