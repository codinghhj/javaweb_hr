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
	 * ��½��֤
	 * @param empLoginName �û���
	 * @param empPwd ����
	 * @return ��½��֤�����1.�û������� 2.������� 3.��½�ɹ�
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
	 * ����½���Ƿ����
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
	 * ������Ա��
	 * @param emp
	 * @throws SQLException 
	 */
	public void addEmp(Emp emp) throws SQLException{
		dao.insert(emp);
	}
	/**
	 *ͨ��Ա��iD��ѯ����Ա������
	 * @param empId
	 * @return
	 * @throws SQLException
	 */
	@Transactional(readOnly=true)
	public Emp queryEmpById(Integer empId) throws SQLException {
		return dao.queryById(empId);
	}
	/**
	 * ����Ա�����ܼ�¼����
	 * @return
	 * @throws SQLException 
	 */
	@Transactional(readOnly=true)
	public int getEmpCount() throws SQLException {
		return dao.getCount();
	}
	/**
	 * ��ҳ��ѯԱ������
	 * @param pager
	 * @return
	 * @throws SQLException
	 */
	@Transactional(readOnly=true)
	public List<Emp> queryEmpByPage(Pager pager) throws SQLException{
		return dao.queryByPage(pager);
	}
	/**
	 * �޸�Ա������
	 * @param emp
	 * @throws SQLException 
	 */
	public void updateEmp(Emp emp) throws SQLException{
		dao.update(emp);
	}
	/**
	 * ɾ��һ��Ա��
	 * @param empId
	 * @throws SQLException
	 */
	public void deleteEmp(Integer empId) throws SQLException{
		dao.delete(empId);
	}
	/**
	 * ��ѯ�û�ͷ��
	 * @param empLoginName
	 * @return
	 * @throws SQLException 
	 */
	@Transactional(readOnly=true)
	public String queryEmpPic(String empLoginName) throws SQLException {
		return dao.queryEmpPic(empLoginName);
	}
	/**
	 * ����Ա��ͷ��
	 * @param empLoginName
	 * @param empPic
	 * @throws SQLException
	 */
	public void updateEmpPic(String empLoginName,String empPic) throws SQLException {
		dao.updateEmpPic(empLoginName, empPic);
	}
	/**
	 * �޸�����
	 * @param EmpLoginName
	 * @param empPwd
	 * @throws SQLException
	 */
	public void updateEmpPwd(String EmpLoginName,String empPwd) throws SQLException{
		dao.updateEmpPwd(EmpLoginName, empPwd);
	}
	/**
	 * ��ѯ��ǰ����
	 * @param empLoginName
	 * @return
	 * @throws SQLException
	 */
	@Transactional(readOnly=true)
	public Emp queryEmpPwd(String empLoginName) throws SQLException {
		return dao.queryByName(empLoginName);
	}
}
