package com.icss.hr.dept.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.DeptService;

/**
 * 部門控制器
 * @author Administrator
 *
 */
@Controller
public class DeptController {

	@Autowired	
	private DeptService service;
	
	@RequestMapping("/dept/add")
	public void addDept(Dept dept,HttpServletRequest request,HttpServletResponse response) {
	
		service.addDept(dept);
		
	}
	
	/**
	 * 查詢部門
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/dept/query")
	public List<Dept> queryDept(HttpServletRequest request,HttpServletResponse response) {
		return service.queryDept();
	}
	
	@RequestMapping("/dept/delete")
	public void deleteDept(Integer deptId,HttpServletRequest request,HttpServletResponse response){
		service.deleteDept(deptId);
	}
	
	@ResponseBody
	@RequestMapping("/dept/get")
	public Dept queryDeptById(Integer deptId,HttpServletRequest request,HttpServletResponse response) {
		return service.queryDeptById(deptId);
	}
	
	@RequestMapping("/dept/update")
	public void queryDeptById(Dept dept,HttpServletRequest request,HttpServletResponse response) {
		service.updateDept(dept);
	}
}
