package com.icss.hr.emp.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.type.IntegerTypeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icss.hr.common.Pager;
import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;
import com.icss.hr.job.pojo.Job;
import com.sun.javafx.binding.StringFormatter;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@RequestMapping("/emp/login")
	public void Login(String empLoginName,String empPwd,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws SQLException, IOException{
		
		Integer res = service.checkLogin(empLoginName, empPwd);
		//當登陸成功
		if(res == 3) {
			session.setAttribute("empLoginName", empLoginName);
			System.out.println(session.getAttribute("empLoginName"));
		}
		System.out.println("登錄成功" + res);
		response.getWriter().print(res);
		
	}
	
	//獲取頭像
	@RequestMapping("/emp/getPic")
	public void getPic(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws SQLException, IOException{
		String empLoginName = (String) session.getAttribute("empLoginName");
		String pic = service.queryEmpPic(empLoginName);
		response.getWriter().print(pic);
	}
	
	//修改頭像
	@RequestMapping("/emp/updatePic")
	public void updatePic(String imgBase64,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws SQLException, IOException{
		String empLoginName = (String) session.getAttribute("empLoginName");
		service.updateEmpPic(empLoginName, imgBase64);
	}
	
	//分页查询员工列表
	@ResponseBody
	@RequestMapping("/emp/query")
	public Map<String,Object> queryEmp(String pageNum,String pageSize) throws NumberFormatException, SQLException{
		
		if(pageSize == null) {
			pageSize = "10";
		}
		if(pageNum == null) {
			pageNum = "1";
		}
		Pager pager = new Pager(service.getEmpCount(), Integer.parseInt(pageSize), Integer.parseInt(pageNum));
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("list", service.queryEmpByPage(pager));
		map.put("pager", pager);
		return map;
		
	}
	
	//检验登陆名是否已经存在
	@RequestMapping("/emp/checkLoginName")
	public void checkLoginName(String empLoginName,HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException{
		boolean res = service.checkLoginName(empLoginName);
		response.getWriter().print(res);
	}
	
	//添加新用户
	@RequestMapping("/emp/add")
	public void addEmp(Emp emp,String empHiredate,String deptId,String jobId,HttpServletRequest request,HttpServletResponse response) throws SQLException{
		emp.setHireDate(Date.valueOf(empHiredate));
		Dept dept = new Dept();
		dept.setDeptId(Integer.parseInt(deptId));
		Job job = new Job();
		job.setJobId(Integer.parseInt(jobId));
		emp.setDept(dept);
		emp.setJob(job);
		service.addEmp(emp);
	}
	
	/**
	 * 根据id查询用户信息
	 */
	@ResponseBody
	@RequestMapping("/emp/queryById")
	public Emp queryEmpById(String empId,HttpServletRequest request,HttpServletResponse response) throws NumberFormatException, SQLException{
		return service.queryEmpById(Integer.parseInt(empId));
	}
	
	/**
	 * 更新用户信息
	 * @param emp
	 * @param empHiredate
	 * @param deptId
	 * @param jobId
	 * @param request
	 * @param response
	 * @throws SQLException
	 */
	@RequestMapping("/emp/update")
	public void update(Emp emp,String empHiredate,String deptId,String jobId,HttpServletRequest request,HttpServletResponse response) throws SQLException{
		try {
			emp.setHireDate(Date.valueOf(empHiredate));
			Dept dept = new Dept();
			dept.setDeptId(Integer.parseInt(deptId));
			Job job = new Job();
			job.setJobId(Integer.parseInt(jobId));
			emp.setDept(dept);
			emp.setJob(job);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		service.updateEmp(emp);
	}
	
	@RequestMapping("/emp/delete")
	public void delete(String empId,HttpServletRequest request,HttpServletResponse response) throws SQLException{
		
		service.deleteEmp(Integer.parseInt(empId));
	}
	

	@RequestMapping("/emp/getEmpPwd")
	public void getEmpPwd(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws SQLException, IOException{
		String empLoginName = (String) session.getAttribute("empLoginName");
		response.getWriter().print(service.queryEmpPwd(empLoginName).getEmpPwd());
	}
	
	@RequestMapping("/emp/updateEmpPwd")
	public void updateEmpPwd(String empPwd,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws SQLException, IOException{
		String empLoginName = (String) session.getAttribute("empLoginName");
		service.updateEmpPwd(empLoginName, empPwd);
	}

}
