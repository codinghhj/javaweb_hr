package com.icss.hr.emp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;
import com.sun.corba.se.spi.activation.Server;

/**
 * Ա��������
 * 
 * @author Administrator
 *
 */
@Controller
public class EmpController {

	@Autowired
	private EmpService service;

	/**
	 * ����Ա��
	 * 
	 * @param emp
	 * @param request
	 * @param response
	 */
	@RequestMapping("/emp/add")
	public void addEmp(Emp emp, HttpServletRequest request, HttpServletResponse response) {
		
		service.addEmp(emp);
	}

	/**
	 * ��ҳ��ѯԱ��
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/emp/query")
	public Map<String, Object> queryEmp(String pageNum, String pageSize, HttpServletRequest request,
			HttpServletResponse response) {

		int pageNumInt = 1;

		try {
			pageNumInt = Integer.parseInt(pageNum);
		} catch (Exception e) {

		}

		int pageSizeInt = 10;

		try {
			pageSizeInt = Integer.parseInt(pageSize);
		} catch (Exception e) {

		}

		Pager pager = new Pager(service.getEmpCount(), pageSizeInt, pageNumInt);
		List<Emp> list = service.queryEmpByPage(pager);

		HashMap<String, Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("list", list);

		return map;
	}

	/**
	 * ɾ��Ա��
	 * 
	 * @param empId
	 */
	@RequestMapping("/emp/delete")
	public void deleteEmp(Integer empId,HttpServletRequest request,
			HttpServletResponse response) {

		service.deleteEmp(empId);

	}

	/**
	 * ����ָ��id��Ա��
	 * 
	 * @param empId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/emp/get")
	public Emp queryEmpById(Integer empId,HttpServletRequest request,
			HttpServletResponse response) {

		return service.queryEmpById(empId);
	}

	/**
	 * �޸�Ա��
	 */
	@RequestMapping("/emp/update")
	public void updateEmp(Emp emp, HttpServletRequest request, HttpServletResponse response) {

		service.updateEmp(emp);
	}
	
	/**
	 * �жϵ�¼���Ƿ����
	 */
	@ResponseBody
	@RequestMapping("/emp/checkLoginName")
	public boolean checkLoginName(String empLoginName,HttpServletRequest request, HttpServletResponse response) {
		
		return service.checkLoginName(empLoginName);		
	}
	
	/**
	 * ��½��֤
	 */
	@ResponseBody
	@RequestMapping("/emp/login")
	public int checkLogin(String empLoginName,String empPwd,HttpServletRequest request, HttpServletResponse response) {
		
		int result = service.checkLogin(empLoginName, empPwd);
		
		//��½�ɹ�����session�д洢��½��ʶ
		if (result == 3) {
			HttpSession session = request.getSession();
			session.setAttribute("empLoginName", empLoginName);
		}
				
		return result;		
	}		
	
	/**
	 * ��õ�ǰ�û���ͷ������
	 */
	@ResponseBody
	@RequestMapping("/emp/getEmpPic")
	public String getEmpPic(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String empLoginName = (String) session.getAttribute("empLoginName");
		
		String empPic = service.queryEmpPic(empLoginName);
		return empPic;
	}
	
	/**
	 * ����ͷ��
	 */
	@RequestMapping("/emp/updateEmpPic")
	public void updateEmpPic(String imgBase64,HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String empLoginName = (String) session.getAttribute("empLoginName");
		
		service.updateEmpPic(empLoginName, imgBase64);
	}
	
	/**
	 * ���ص�ǰ�û�������
	 */
	@ResponseBody
	@RequestMapping("/emp/getEmpPwd")
	public String getEmpPwd(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String empLoginName = (String) session.getAttribute("empLoginName");
		
		String empPwd = service.queryEmpPwd(empLoginName);
		return empPwd;
	}		
	
	/**
	 * �޸�����
	 */
	@RequestMapping("/emp/updateEmpPwd")
	public void updateEmpPwd(String empPwd,HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String empLoginName = (String) session.getAttribute("empLoginName");
		
		service.updateEmpPwd(empLoginName, empPwd);		
	}
	
	/**
	 * ������ҳ��ѯԱ��
	 */
	@ResponseBody
	@RequestMapping("/emp/queryByCondition")
	public Map<String, Object> queryByCondition(String deptId,String jobId,String empName,
			String pageNum,String pageSize,HttpServletRequest request, HttpServletResponse response) {
		
		Integer deptIdInt = null;
		
		try {
			deptIdInt = Integer.parseInt(deptId);
		} catch (Exception e) {
			
		}
		
		Integer jobIdInt = null;
		
		try {
			jobIdInt = Integer.parseInt(jobId);
		} catch (Exception e) {
			
		}
		
		int pageNumInt = 1;

		try {
			pageNumInt = Integer.parseInt(pageNum);
		} catch (Exception e) {

		}

		int pageSizeInt = 10;

		try {
			pageSizeInt = Integer.parseInt(pageSize);
		} catch (Exception e) {

		}
		
		int recordCount = service.getEmpCountByCondition(deptIdInt, jobIdInt, empName);
		
		Pager pager = new Pager(recordCount, pageSizeInt, pageNumInt);		
		List<Emp> list = service.queryEmpByCondition(deptIdInt, jobIdInt, empName, pager);
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("list", list);

		return map;
	}
	

}