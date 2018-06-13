package com.icss.hr.job.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.hr.job.dao.JobMapper;
import com.icss.hr.job.pojo.Job;

/**
 * 职务的业务
 * @author Administrator
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class JobService {
	
	@Autowired
	private JobMapper dao;
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
	@Transactional(readOnly=true)
	public Job queryJobById(Integer jobId) throws SQLException {
		return dao.queryById(jobId);
	}
	/**
	 * 查询所有部门
	 * @throws SQLException 
	 */
	@Transactional(readOnly=true)
	public List<Job> queryJob() throws SQLException {
		return dao.query();
	}
}
