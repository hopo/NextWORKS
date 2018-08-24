package kr.or.nextit.mber.service;

import java.util.List;

import javax.servlet.http.Part;

import kr.or.nextit.member.service.MemberSearchVo;
import kr.or.nextit.member.service.MemberVo;

public interface MberService {

	/**
	 * 아이디 체크
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public MemberVo joinIdCheck(MemberVo params) throws Exception;

	/**
	 * 회원 등록 그리고.. 첨부파일 1건
	 * 
	 * @param memberVo
	 * @param attachPart
	 * @return
	 * @throws Exception
	 */
	public MemberVo insertMemberItem(MemberVo memberVo, List<Part> attachPart) throws Exception;

	/**
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
