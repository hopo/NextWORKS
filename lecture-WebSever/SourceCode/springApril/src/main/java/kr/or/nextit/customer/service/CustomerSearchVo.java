package kr.or.nextit.customer.service;

import java.io.Serializable;

import kr.or.nextit.comm.util.PagingVo;

@SuppressWarnings("serial")
public class CustomerSearchVo extends PagingVo implements Serializable {

	private String searchType;
	private String searchText;

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

}
