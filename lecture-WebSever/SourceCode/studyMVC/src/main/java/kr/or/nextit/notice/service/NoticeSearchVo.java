package kr.or.nextit.notice.service;

import org.apache.commons.lang3.builder.ToStringBuilder;

import kr.or.nextit.com.util.PagingVo;

@SuppressWarnings("serial")
public class NoticeSearchVo extends PagingVo {

	private String searchType;
	private String searchText;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

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