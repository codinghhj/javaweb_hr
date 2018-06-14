package com.icss.hr.emp.service;

import java.sql.SQLException;
import java.util.List;

import org.ietf.jgss.Oid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.dao.EmpMapper;
import com.icss.hr.emp.pojo.Emp;
import com.sun.javafx.binding.StringFormatter;

@Service
@Transactional(rollbackFor=Exception.class)
public class EmpService {
	
	@Autowired
	private EmpMapper dao;
	/**
	 * 登陆验证
	 * @param empLoginName 用户名
	 * @param empPwd 密码
	 * @return 登陆验证结果：1.用户不存在 2.密码错误 3.登陆成功
	 * @throws SQLException 
	 */
	public int checkLogin(String empLoginName,String empPwd) throws SQLException {
		Emp emp = dao.queryByName(empLoginName);
		if(emp == null){
			return 1;
		}
		if(empPwd == null) {
			empPwd = "";
		}
		if(empPwd.equals(emp.getEmpPwd())) {
			return 3;
		}
		return 2;
	}
	/**
	 * 检查登陆名是否存在
	 * @param empLoginName
	 * @return
	 * @throws SQLException 
	 */
	public boolean checkLoginName(String empLoginName) throws SQLException {
		Emp emp = dao.queryByName(empLoginName);
		if(emp != null) {
			return true;
		}
		return false;
	}
	/**
	 * 增加新员工
	 * @param emp
	 * @throws SQLException 
	 */
	public void addEmp(Emp emp) throws SQLException{
		dao.insert(emp);
	}
	/**
	 *通过员工iD查询单个员工数据
	 * @param empId
	 * @return
	 * @throws SQLException
	 */
	@Transactional(readOnly=true)
	public Emp queryEmpById(Integer empId) throws SQLException {
		return dao.queryById(empId);
	}
	/**
	 * 返回员工的总记录数啊
	 * @return
	 * @throws SQLException 
	 */
	@Transactional(readOnly=true)
	public int getEmpCount() throws SQLException {
		return dao.getCount();
	}
	/**
	 * 分页查询员工数据
	 * @param pager
	 * @return
	 * @throws SQLException
	 */
	@Transactional(readOnly=true)
	public List<Emp> queryEmpByPage(Pager pager) throws SQLException{
		return dao.queryByPage(pager);
	}
	/**
	 * 修改员工数据
	 * @param emp
	 * @throws SQLException 
	 */
	public void updateEmp(Emp emp) throws SQLException{
		dao.update(emp);
	}
	/**
	 * 删除一个员工
	 * @param empId
	 * @throws SQLException
	 */
	public void deleteEmp(Integer empId) throws SQLException{
		dao.delete(empId);
	}
	/**
	 * 查询用户头像
	 * @param empLoginName
	 * @return
	 * @throws SQLException 
	 */
	@Transactional(readOnly=true)
	public String queryEmpPic(String empLoginName) throws SQLException {
		return dao.queryEmpPic(empLoginName);
	}
	/**
	 * 更新员工头像
	 * @param empLoginName
	 * @param empPic
	 * @throws SQLException
	 */
	public void updateEmpPic(String empLoginName,String empPic) throws SQLException {
		dao.updateEmpPic(empLoginName, empPic);
	}
	/**
	 * 修改密码
	 * @param EmpLoginName
	 * @param empPwd
	 * @throws SQLException
	 */
	public void updateEmpPwd(String EmpLoginName,String empPwd) throws SQLException{
		dao.updateEmpPwd(EmpLoginName, empPwd);
	}
	/**
	 * 查询当前密码
	 * @param empLoginName
	 * @return
	 * @throws SQLException
	 */
	@Transactional(readOnly=true)
	public Emp queryEmpPwd(String empLoginName) throws SQLException {
		return dao.queryByName(empLoginName);
	}
}
