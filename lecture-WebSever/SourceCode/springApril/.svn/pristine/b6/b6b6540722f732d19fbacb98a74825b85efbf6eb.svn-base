package kr.or.nextit.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.nextit.member.service.MemberService;
import kr.or.nextit.member.service.MemberVo;

@Service("MemberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;

	@Override
	public List<MemberVo> selectMemberList() throws Exception {
		return memberMapper.selectMemberList();
	}

	@Override
	public MemberVo selectMemberView(MemberVo memberVo) throws Exception {
		return memberMapper.selectMemberView(memberVo);
	}

	@Override
	public void insertMember(MemberVo memberVo) throws Exception {
		memberMapper.insertMember(memberVo);
	}
	
	@Override
	public void updateUpMember(MemberVo memberVo) throws Exception {
		memberMapper.updateUpMember(memberVo);
	}
	
	@Override
	public void updateDelMember(MemberVo memberVo) throws Exception {
		memberMapper.updateDelMember(memberVo);
	}

}
