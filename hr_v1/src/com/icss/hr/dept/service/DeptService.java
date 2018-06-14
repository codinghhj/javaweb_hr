package com.icss.hr.dept.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.pojo.Dept;
/**
 * 部门的业务层
 * @author Administrator
 *
 */
public class DeptService {
	private DeptDao dao = new DeptDao();
	/**
	 * 增加部门
	 * @throws SQLException 
	 */
	public void addDept(Dept dept) throws SQLException {
		dao.insert(dept);
	}
	/**
	 * 修改部门
	 * @throws SQLException 
	 */
	public void updateDept(Dept dept) throws SQLException {
		dao.update(dept);
	}
	/**
	 * 删除部门
	 * @param deptId
	 * @throws SQLException
	 */
	public void deleteDept(Integer deptId) throws SQLException {
		dao.delete(deptId);
	}
	/**
	 * 查询单个部门
	 * @throws SQLException 
	 */
	public Dept queryDeptById(Integer deptId) throws SQLException {
		return dao.queryById(deptId);
	}
	/**
	 * 查询所有部门数据
	 * @throws SQLException 
	 */
	public List<Dept> queryDept() throws SQLException {
		return dao.query();
	}
} 
