package kr.or.nextit.board.service;

public class BoardVo {

	// Fields
	private String idx;
	private String board_type;
	private String title;
	private String contents;
	private String reg_date;
	private String up_date;
	private String reg_user;

	private String message;
	private boolean result;

	// Getter and Setter
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getBoard_type() {
		return board_type;
	}

	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getUp_date() {
		return up_date;
	}

	public void setUp_date(String up_date) {
		this.up_date = up_date;
	}

	public String getReg_user() {
		return reg_user;
	}

	public void setReg_user(String reg_user) {
		this.reg_user = reg_user;
	}

}
