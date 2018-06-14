package com.icss.hr.analyze.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icss.hr.analyze.dto.DeptEmpCount;
import com.icss.hr.analyze.service.AnaService;

@Controller
public class AnaController {
	
	@Autowired
	private AnaService service;
	
	@ResponseBody
	@RequestMapping("/ana/queryDeptEmpCount")
	public List<DeptEmpCount> queryDeptEmpCount() throws SQLException{
		return service.queryEmpCounts();
	}
	
	@ResponseBody
	@RequestMapping("/emp/queryJobAvgSal")
	public List<Map<String, Object>> queryJobAvgSal() throws SQLException {
		return service.queryJobAvgSal();
	}
	
	@ResponseBody
	@RequestMapping("/emp/queryMaxMinSal")
	public List<Map<String, Object>> queryMaxMinSal() throws SQLException {
		return service.queryMaxMinSal();
	}
	
}
