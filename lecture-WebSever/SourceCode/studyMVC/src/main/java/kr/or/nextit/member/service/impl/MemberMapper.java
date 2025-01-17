package kr.or.nextit.member.service.impl;

import java.util.List;

import kr.or.nextit.member.service.MemberSearchVo;
import kr.or.nextit.member.service.MemberVo;

public interface MemberMapper {

	/**
	 * 멤버 매퍼 : 인서트 아이템
	 * 
	 * @param params
	 * @throws Exception
	 */
	public void insertItem(MemberVo params) throws Exception;

	/**
	 * 멤버 매퍼 : 전체 페이지 카운터
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public int selectTotalCount(MemberSearchVo params) throws Exception;

	/**
	 * 멤버 매퍼 : 셀렉트 아이텀즈
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<MemberVo> selectItems(MemberSearchVo params) throws Exception;

	/**
	 * 멤버 매퍼 : 아이디(memberVo)를 입력 받아 멤버 상세 조회
	 * 
	 * @param paramVo
	 * @return
	 * @throws Exception
	 */
	public MemberVo selectViewItem(MemberVo paramVo) throws Exception;

	/**
	 * 멤버 매퍼 : 회원 한 건 업데이트
	 * 
	 * @param paramVo
	 * @return
	 * @throws Exception
	 */
	public void updateItem(MemberVo paramVo) throws Exception;

	/**
	 * 멤버 매퍼 : 회원 한 건 탈퇴 처리
	 * 
	 * @param paramVo
	 * @throws Exception
	 */
	public void deleteItem(MemberVo paramVo) throws Exception;

}
