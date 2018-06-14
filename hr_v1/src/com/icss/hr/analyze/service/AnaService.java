package com.icss.hr.analyze.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.icss.hr.analyze.dao.AnaDao;
import com.icss.hr.analyze.dto.DeptEmpCount;

public class AnaService {
	private AnaDao dao = new AnaDao();
	
	public List<DeptEmpCount> queryEmpCounts() throws SQLException{
		return dao.queryEmpcount();
	}
	
	public List<HashMap<String, Object>> queryJobAvgSal() throws SQLException {
		return dao.queryJobAvgSal();
	}
	
	public List<HashMap<String, Object>> queryMaxMinSal() throws SQLException{
		return dao.queryMaxMinSal();
	}
}
