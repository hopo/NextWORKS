package kr.or.nextit.attach.service;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

@SuppressWarnings("serial")
public class AttachVo implements Serializable {

	private String fileGroup;
	private String fileId;

	private String fileType;
	private String fileOriginalFileName;
	private long fileSize;

	private String fileSavePath;
	private String fileSaveFileName;

	private String fileFlag; // ;;;삭제 유무 'Y/N'
	private String fileRegUser;
	private String fileRegDate;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getFileGroup() {
		return fileGroup;
	}

	public void setFileGroup(String fileGroup) {
		this.fileGroup = fileGroup;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileOriginalFileName() {
		return fileOriginalFileName;
	}

	public void setFileOriginalFileName(String fileOriginalFileName) {
		this.fileOriginalFileName = fileOriginalFileName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileSavePath() {
		return fileSavePath;
	}

	public void setFileSavePath(String fileSavePath) {
		this.fileSavePath = fileSavePath;
	}

	public String getFileSaveFileName() {
		return fileSaveFileName;
	}

	public void setFileSaveFileName(String fileSaveFileName) {
		this.fileSaveFileName = fileSaveFileName;
	}

	public String getFileFlag() {
		return fileFlag;
	}

	public void setFileFlag(String fileFlag) {
		this.fileFlag = fileFlag;
	}

	public String getFileRegUser() {
		return fileRegUser;
	}

	public void setFileRegUser(String fileRegUser) {
		this.fileRegUser = fileRegUser;
	}

	public String getFileRegDate() {
		return fileRegDate;
	}

	public void setFileRegDate(String fileRegDate) {
		this.fileRegDate = fileRegDate;
	}

}