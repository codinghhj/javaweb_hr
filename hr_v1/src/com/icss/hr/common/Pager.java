package com.icss.hr.common;

public class Pager {
	private int recordCount; //总记录数
	private int pageSize = 10; //每页多少条
	private int pageCount; //共几页
	private int pageNum; //当前页码
	private int start;
	private int end;
	public Pager(int recordCount,int pageNum) {
		this(recordCount,10, pageNum);
	}
	
	public Pager(int recordCount,int pageSize,int pageNum) {
		this.recordCount = recordCount;
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.pageCount = this.recordCount / this.pageSize;
		//计算共几页
		if(this.recordCount % this.pageSize != 0) {
			this.pageCount ++;
		}
		//计算当前页码
		if(this.pageNum < 1)
			this.pageNum = 1;
		if(this.pageNum > this.pageCount)
			this.pageNum = this.pageCount;
		
		//计算记录起始和终止位置
		this.start = (this.pageNum - 1) * this.pageSize + 1;
		this.end = this.pageNum * this.pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	@Override
	public String toString() {
		return "Pager [recordCount=" + recordCount + ", pageSize=" + pageSize
				+ ", pageCount=" + pageCount + ", pageNum=" + pageNum
				+ ", start=" + start + ", end=" + end + "]";
	}

}
