package kr.or.nextit.example.dao;

import java.util.List;

import kr.or.nextit.example.dto.MemberVO;

public interface MemberDAO {
    
    public List<MemberVO> selectMember() throws Exception;
}


