package com.room2.member.service;

/**
 * DB: TB_MEMBER
 * 
 * @author pc33
 *
 */

public class MemberVo {

	/* memberVo Fields(8) */
	private String mem_id;
	private String mem_pwd;
	private String mem_name;
	private String mem_phone;
	private String mem_email;
	private String reg_date;
	private String mem_ip;
	private String del_at;

	/* memberVo Getter Setter */
	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pwd() {
		return mem_pwd;
	}

	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_phone() {
		return mem_phone;
	}

	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getMem_ip() {
		return mem_ip;
	}

	public void setMem_ip(String mem_ip) {
		this.mem_ip = mem_ip;
	}

	public String getDel_at() {
		return del_at;
	}

	public void setDel_at(String del_at) {
		this.del_at = del_at;
	}

}
