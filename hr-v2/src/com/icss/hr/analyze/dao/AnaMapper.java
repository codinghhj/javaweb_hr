package com.icss.hr.analyze.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icss.hr.analyze.dto.DeptEmpCount;

public interface AnaMapper {
	/**
	 * ���T���˔�
	 */
	List<DeptEmpCount> queryEmpcount();
	
	/**
	 * ��ѯÿ��ְ���ƽ������
	 * @throws SQLException 
	 */
	List<Map<String, Object>> queryJobAvgSal();
	
	/**
	 * ���T�����߹��Y
	 * @return
	 */
	List<Map<String, Object>> queryMaxMinSal();
	
}
