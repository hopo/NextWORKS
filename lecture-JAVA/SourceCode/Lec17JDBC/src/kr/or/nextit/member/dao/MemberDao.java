package kr.or.nextit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.nextit.member.model.Member;

// * Data Access Object
// ; CRUD
public class MemberDao {

	// ! Singleton Pattern.
	// ;; 메서드만 있는 클래스다 보니 객체를 여러개 생성할 필요가 없다.
	private static MemberDao instance = new MemberDao();

	private MemberDao() {
	}

	// ;; 외부에서 호출만
	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}

	// ! 회원 정보 목록 조회
	// ;; call하는 쪽에서 conn을 생성 그리고 exception 처리
	public List<Member> selectMemberList(Connection conn) throws SQLException {
		StringBuffer query = new StringBuffer();

		query.append(" SELECT			 ");
		query.append("       mem_id		 ");
		query.append("     , mem_pwd	 ");
		query.append("     , mem_name	 ");
		query.append("     , mem_phone	 ");
		query.append("     , mem_email	 ");
		query.append("     , reg_date	 ");
		query.append(" FROM				 ");
		query.append(" 		tb_member	 ");

		PreparedStatement pstmt = conn.prepareStatement(query.toString());

		ResultSet rs = pstmt.executeQuery();
		List<Member> memberList = new ArrayList<>();

		while (rs.next()) {

			Member member = new Member();

			member.setMem_id(rs.getString("mem_id"));
			member.setMem_pwd(rs.getString("mem_pwd"));
			member.setMem_name(rs.getString("mem_name"));
			member.setMem_phone(rs.getString("mem_phone"));
			member.setMem_email(rs.getString("mem_email"));
			member.setReg_date(rs.getString("reg_date"));

			memberList.add(member);
		}

		return memberList;
	}

	// ! 회원 정보 조회
	public Member selectMember(Connection conn, String mem_id) throws SQLException {

		StringBuffer query = new StringBuffer();

		query.append(" SELETE			 ");
		query.append("       mem_id		 ");
		query.append("     , mem_pwd	 ");
		query.append("     , mem_name	 ");
		query.append("     , mem_phone	 ");
		query.append("     , mem_email	 ");
		query.append("     , reg_date	 ");
		query.append(" FROM				 ");
		query.append(" 		tb_member	 ");
		query.append(" WHERE ");
		query.append(" 		mem_id = ?   ");

		PreparedStatement pstmt = conn.prepareStatement(query.toString());

		pstmt.setString(1, mem_id);
		ResultSet rs = pstmt.executeQuery();

		Member member = null;

		if (rs.next()) {
			member = new Member();

			member.setMem_id(rs.getString("mem_id"));
			member.setMem_pwd(rs.getString("mem_pwd"));
			member.setMem_name(rs.getString("mem_name"));
			member.setMem_phone(rs.getString("mem_phone"));
			member.setMem_email(rs.getString("mem_email"));
			member.setReg_date(rs.getString("reg_date"));
		}

		return member;
	}

	// ! 회원 등록(C)
	public int insertMember(Connection conn, Member member) throws SQLException {

		StringBuffer query = new StringBuffer();

		query.append(" INSERT INTO tb_member ( ");
		query.append("       mem_id		  	   ");
		query.append("     , mem_pwd	   	   ");
		query.append("     , mem_name		   ");
		query.append("     , mem_phone		   ");
		query.append("     , mem_email		   ");
		query.append("     , reg_date 		   ");
		query.append(" ) VALUES (			   ");
		query.append(" 	   	 ?				   "); // ?: 1
		query.append(" 	   , ?				   "); // ?: 2
		query.append(" 	   , ?				   "); // ?: 3
		query.append(" 	   , ?				   "); // ?: 4
		query.append(" 	   , ?				   "); // ?: 5
		query.append(" 	   , sysdate		   ");
		query.append(" )				  	   ");

		PreparedStatement pstmt = conn.prepareStatement(query.toString());

		int i = 1;
		pstmt.setString(i++, member.getMem_id());
		pstmt.setString(i++, member.getMem_pwd());
		pstmt.setString(i++, member.getMem_name());
		pstmt.setString(i++, member.getMem_phone());
		pstmt.setString(i++, member.getMem_email());

		int updCnt = pstmt.executeUpdate();

		return updCnt;
	}

	// ! 회원 수정(U)
	public int updateMember(Connection conn, Member member) throws SQLException {

		StringBuffer query = new StringBuffer();

		query.append(" UPDATE					");
		query.append("     tb_member 			");
		query.append(" SET 						");
		query.append("       mem_pwd = ?		");
		query.append("     , mem_name = ?		");
		query.append("     , mem_phone = ?		");
		query.append("     , mem_email = ?		");
		query.append(" WHERE					");
		query.append(" 		 mem_id = ? 		");

		PreparedStatement pstmt = conn.prepareStatement(query.toString());

		int i = 1;
		pstmt.setString(i++, member.getMem_pwd());
		pstmt.setString(i++, member.getMem_name());
		pstmt.setString(i++, member.getMem_phone());
		pstmt.setString(i++, member.getMem_email());
		pstmt.setString(i++, member.getMem_id());

		int updCnt = pstmt.executeUpdate();

		return updCnt;
	}

	// ! 회원 삭제(D)
	public int deleteMember(Connection conn, String mem_id) throws SQLException {

		StringBuffer query = new StringBuffer();

		query.append(" DELETE FROM		");
		query.append("     tb_member 	");
		query.append(" WHERE			");
		query.append(" 	   mem_id = ?	");

		PreparedStatement pstmt = conn.prepareStatement(query.toString());

		pstmt.setString(1, mem_id);

		int updCnt = pstmt.executeUpdate(); // ;; 바인딩

		return updCnt;
	}

}
