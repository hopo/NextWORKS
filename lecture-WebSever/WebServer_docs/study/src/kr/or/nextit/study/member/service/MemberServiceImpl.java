package kr.or.nextit.study.member.service;

import kr.or.nextit.study.ex03.StringUtiles;

public class MemberServiceImpl implements MemberService {

	@Override
	public MemberVo setMemberInfo(MemberVo memberVo) {
		// TODO 회원 정보 받아오기

		// ! 가공중 실패 유무 체크
		try {
			// System.out.println(memberVo.getId());
			// System.out.println(memberVo.getName());
			// System.out.println(memberVo.getGender());

			String[] flag = memberVo.getFlag();

			// !! 배열로 받은 플래그를 출력하기 위해 StringUtiles를 호출
			memberVo.setFlagDisplay(StringUtiles.getFlag(flag));

			memberVo.setResult(true);
			memberVo.setMessage("정상처리 되었다.");

			return memberVo;
		} catch (Exception e) {
			memberVo.setResult(false);
			memberVo.setMessage(e.getMessage());

			return memberVo;
		}

	}

}
