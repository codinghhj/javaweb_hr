package com.icss.hr.dept.pojo;



/**
 * 部门实体类
 * @author Administrator
 *
 */
public class Dept {
	
	private Integer deptId;
	private String deptName;
	private String deptLoc;

	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dept(Integer deptId, String depName, String deptLoc) {
		super();
		this.deptId = deptId;
		this.deptName = depName;
		this.deptLoc = deptLoc;
	}
	
	public Dept(String depName, String deptLoc) {
		super();
		this.deptName = depName;
		this.deptLoc = deptLoc;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDepName() {
		return deptName;
	}
	public void setDepName(String depName) {
		this.deptName = depName;
	}
	public String getDeptLoc() {
		return deptLoc;
	}
	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}
	@Override
	public String toString() {
		return "dept [deptId=" + deptId + ", depName=" + deptName + ", deptLoc="
				+ deptLoc + "]";
	}
	
}
