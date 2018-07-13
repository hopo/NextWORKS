package kr.or.nextit.common.service;

public class CodeVo {
	
	// ; 구체적 데이터를 담는 필드들의 테이블이라기 보다,
	// ;게시판 구성에 필요한 데이터 코드에 대한 테이블

	// * on DB table name : tb_com_code
	private String codeParents;
	private String codeId;
	private String codeName;
	private String codeDescription;
	private String regDate;
	private String useAt;

	// * Getter Setter
	public String getCodeParents() {
		return codeParents;
	}

	public void setCodeParents(String codeParents) {
		this.codeParents = codeParents;
	}

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getCodeDescription() {
		return codeDescription;
	}

	public void setCodeDescription(String codeDescription) {
		this.codeDescription = codeDescription;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getUseAt() {
		return useAt;
	}

	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}

}
