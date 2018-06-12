package com.icss.hr.job.service;

import java.sql.SQLException;
import java.util.List;

import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.pojo.Job;

/**
 * ְ���ҵ��
 * @author Administrator
 *
 */
public class JobService {
	private JobDao dao = new JobDao();
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
	public Job queryJobById(Integer jobId) throws SQLException {
		return dao.queryById(jobId);
	}
	/**
	 * ��ѯ���в���
	 * @throws SQLException 
	 */
	public List<Job> queryJob() throws SQLException {
		return dao.query();
	}
}
