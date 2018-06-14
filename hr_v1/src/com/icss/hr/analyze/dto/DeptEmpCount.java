package com.icss.hr.analyze.dto;
/**
 * DTO对象，封装分组查询的结果
 * @author Administrator
 *
 */
public class DeptEmpCount {
	private String deptName;
	
	private int empCount;

	public DeptEmpCount(String deptName, int empCount) {
		super();
		this.deptName = deptName;
		this.empCount = empCount;
	}

	public DeptEmpCount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getEmpCount() {
		return empCount;
	}

	public void setEmpCount(int empCount) {
		this.empCount = empCount;
	}

	@Override
	public String toString() {
		return "DeptEmpCount [deptName=" + deptName + ", empCount=" + empCount
				+ "]";
	}
	
	
}
