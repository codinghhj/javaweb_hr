package com.icss.hr.analyze.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icss.hr.analyze.dto.DeptEmpCount;

public interface AnaMapper {
	/**
	 * 部門的人數
	 */
	List<DeptEmpCount> queryEmpcount();
	
	/**
	 * 查询每种职务的平均工资
	 * @throws SQLException 
	 */
	List<Map<String, Object>> queryJobAvgSal();
	
	/**
	 * 部門最低最高工資
	 * @return
	 */
	List<Map<String, Object>> queryMaxMinSal();
	
}
