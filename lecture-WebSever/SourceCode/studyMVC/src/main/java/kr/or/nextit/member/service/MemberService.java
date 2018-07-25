package kr.or.nextit.member.service;

import java.util.List;

public interface MemberService {
	// ;;;Exception은 Controller 부분에서 처리하게 throws

	/**
	 * 멤버 서비스 : 회원 등록
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public MemberVo insertItem(MemberVo params) throws Exception;

	/**
	 * 멤버 서비스 : 회원 목록 가지고 오기
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<MemberVo> selectItems(MemberVo params) throws Exception;

	/**
	 * 멤버 서비스 : 회원 상세 가져오기
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public MemberVo selectViewItem(MemberVo params) throws Exception;

	/**
	 * 멤버 서비스 : 회원 한건 수정
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public MemberVo updateItem(MemberVo params) throws Exception;

	/**
	 * 멤버 서비스 : 회원 한건 삭제 (수정)
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public MemberVo deleteItem(MemberVo params) throws Exception;

}
