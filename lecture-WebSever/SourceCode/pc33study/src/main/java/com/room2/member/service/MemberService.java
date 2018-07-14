package com.room2.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * "Member관련 서비스를 위한 인터페이스"
 * @author pc33
 *
 */
public interface MemberService {

	public List<MemberVo> selectMemberList(HttpServletRequest req);

	public MemberVo selectMemberItem(String mem_id);
}
