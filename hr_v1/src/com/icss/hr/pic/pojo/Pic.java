package com.icss.hr.pic.pojo;


import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * 图片库的实体类·
 * @author Administrator
 *
 */
public class Pic {
	
	private Integer picId;
	
	private String picName;
	
	private String picInfo;
	
	private Long picSize;
	
	private String picAuthor;
	
	private InputStream picData;
	
	private Timestamp picDateTime;

	public Pic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pic(Integer picId, String picName, String picInfo, Long picSize,
			String picAuthor,InputStream picData, Timestamp timestamp) {
		super();
		this.picId = picId;
		this.picName = picName;
		this.picInfo = picInfo;
		this.picSize = picSize;
		this.picAuthor = picAuthor;
		this.picData = picData;
		this.picDateTime = timestamp;
	}

	public Pic(String picName, String picInfo, Long picSize,
			String picAuthor, InputStream picData, Timestamp picDateTime) {
		super();
		this.picName = picName;
		this.picInfo = picInfo;
		this.picSize = picSize;
		this.picAuthor = picAuthor;
		this.picData = picData;
		this.picDateTime = picDateTime;
	}
	public Pic(String picName, String picInfo, Long picSize,
			String picAuthor, InputStream picData) {
		super();
		this.picName = picName;
		this.picInfo = picInfo;
		this.picSize = picSize;
		this.picAuthor = picAuthor;
		this.picData = picData;
	
	}
	public Integer getPicId() {
		return picId;
	}

	public void setPicId(Integer picId) {
		this.picId = picId;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getPicInfo() {
		return picInfo;
	}

	public void setPicInfo(String picInfo) {
		this.picInfo = picInfo;
	}

	public Long getPicSize() {
		return picSize;
	}

	public void setPicSize(Long picSize) {
		this.picSize = picSize;
	}

	public String getPicAuthor() {
		return picAuthor;
	}

	public void setPicAuthor(String picAuthor) {
		this.picAuthor = picAuthor;
	}

	public InputStream getPicData() {
		return picData;
	}

	public void setPicData(InputStream picData) {
		this.picData = picData;
	}

	public Timestamp getPicDateTime() {
		return picDateTime;
	}

	public void setPicDateTime(Timestamp picDateTime) {
		this.picDateTime = picDateTime;
	}

	@Override
	public String toString() {
		return "Pic [picId=" + picId + ", picName=" + picName + ", picInfo="
				+ picInfo + ", picSize=" + picSize + ", picAuthor=" + picAuthor
				+ ", picData=" + picData + ", picDateTime=" + picDateTime + "]";
	}
	
	
	
}
