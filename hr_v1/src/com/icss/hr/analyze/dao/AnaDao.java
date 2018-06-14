package com.icss.hr.analyze.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.icss.hr.analyze.dto.DeptEmpCount;
import com.icss.hr.common.DbUtil;
import com.sun.javafx.collections.MappingChange.Map;

public class AnaDao {
	
	public List<DeptEmpCount> queryEmpcount() throws SQLException{

		Connection conn = DbUtil.getConnection();
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select d.dept_name dept_name,count(e.emp_id) emp_count");
		sql.append(" from dept d");
		sql.append(" left outer join emp e on d.dept_id = e.emp_dept_id");
		sql.append(" group by d.dept_name");
		
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<DeptEmpCount> list = new ArrayList<DeptEmpCount>();
		
		while (rs.next()) {
			DeptEmpCount dec = new DeptEmpCount(rs.getString(1), rs.getInt(2));
			list.add(dec);
		}
		rs.close();
		pstmt.close();
		conn.close();
		
		return list;
	}
	
	/**
	 * 查询每种职务的平均工资
	 * @throws SQLException 
	 */
	public ArrayList<HashMap<String, Object>> queryJobAvgSal() throws SQLException {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		
		Connection conn = DbUtil.getConnection();
		
		StringBuffer sql = new StringBuffer();
		sql.append("select j.job_name,trunc(nvl(avg(e.emp_salary),0)) avg_sal");
		sql.append(" from job j");
		sql.append(" left outer join emp e on j.job_id = e.emp_job_id");
		sql.append(" group by j.job_name");
		
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("jobName",rs.getString(1));
			map.put("avgSal", rs.getInt(2));
			System.out.println(map);
			list.add(map);
		}
		rs.close();
		pstmt.cancel();
		conn.close();
		return list;
	}
	
	public ArrayList<HashMap<String, Object>> queryMaxMinSal() throws SQLException {
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		Connection conn = DbUtil.getConnection();
		StringBuffer sql = new StringBuffer();
		sql.append("select d.dept_name,max(e.emp_salary) max_salary,min(e.emp_salary) min_salary");
		sql.append(" from emp e");
		sql.append(" left outer join dept d on e.emp_dept_id = d.dept_id");
		sql.append(" group by d.dept_name");
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("deptName", rs.getString(1));
			map.put("maxSalary", rs.getInt(2));
			map.put("minSalary", rs.getInt(3));
			list.add(map);
		}
		return list;
	}
}
