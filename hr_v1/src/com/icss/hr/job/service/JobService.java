package com.icss.hr.job.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.pojo.Job;

/**
 * 职务的业务
 * @author Administrator
 *
 */
public class JobService {
	private JobDao dao = new JobDao();
	/**
	 * 增加部门
	 * @throws SQLException 
	 */
	public void addJob(Job job) throws SQLException{
		dao.insert(job);
	}
	/**
	 * 修改部门
	 * @throws SQLException 
	 */
	public void updateJob(Job job) throws SQLException{
		dao.update(job);
	}
	/**
	 * 删除部门
	 * @throws SQLException 
	 */
	public void deleteJob(Integer jobId) throws SQLException {
		dao.delete(jobId);
	}
	/**
	 * 查询单个部门
	 * @throws SQLException 
	 */
	public Job queryJobById(Integer jobId) throws SQLException {
		return dao.queryById(jobId);
	}
	/**
	 * 查询所有部门
	 * @throws SQLException 
	 */
	public List<Job> queryJob() throws SQLException {
		return dao.query();
	}
}
