package com.icss.hr.analyze.service;

import java.sql.SQLException;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.hr.analyze.dao.AnaMapper;
import com.icss.hr.analyze.dto.DeptEmpCount;

@Service
@Transactional(readOnly=true)
public class AnaService {
	
	@Autowired
	private AnaMapper dao;
	
	public List<DeptEmpCount> queryEmpCounts() throws SQLException{
		return dao.queryEmpcount();
	}
	
	public List<Map<String, Object>> queryJobAvgSal() throws SQLException {
		return dao.queryJobAvgSal();
	}
	
	public List<Map<String, Object>> queryMaxMinSal() throws SQLException{
		return dao.queryMaxMinSal();
	}
}
