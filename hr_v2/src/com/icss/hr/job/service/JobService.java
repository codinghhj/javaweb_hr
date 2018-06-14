package com.icss.hr.job.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.hr.job.dao.JobMapper;
import com.icss.hr.job.pojo.Job;

/**
 * ְ���ҵ��
 * @author Administrator
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class JobService {
	
	@Autowired
	private JobMapper dao;
	/**
	 * ���Ӳ���
	 * @throws SQLException 
	 */
	public void addJob(Job job) throws SQLException{
		dao.insert(job);
	}
	/**
	 * �޸Ĳ���
	 * @throws SQLException 
	 */
	public void updateJob(Job job) throws SQLException{
		dao.update(job);
	}
	/**
	 * ɾ������
	 * @throws SQLException 
	 */
	public void deleteJob(Integer jobId) throws SQLException {
		dao.delete(jobId);
	}
	/**
	 * ��ѯ��������
	 * @throws SQLException 
	 */
	@Transactional(readOnly=true)
	public Job queryJobById(Integer jobId) throws SQLException {
		return dao.queryById(jobId);
	}
	/**
	 * ��ѯ���в���
	 * @throws SQLException 
	 */
	@Transactional(readOnly=true)
	public List<Job> queryJob() throws SQLException {
		return dao.query();
	}
}
