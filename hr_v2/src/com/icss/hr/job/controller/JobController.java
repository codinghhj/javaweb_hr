package com.icss.hr.job.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icss.hr.job.pojo.Job;
import com.icss.hr.job.service.JobService;

@Controller
public class JobController {
	
	@Autowired
	private JobService service;
	
	@RequestMapping("/job/add")
	public void addJob(Job job,HttpServletRequest request,HttpServletResponse response) throws SQLException{
		service.addJob(job);
	}
	
	@ResponseBody
	@RequestMapping("/job/query")
	public List<Job> queryJob(HttpServletRequest request,HttpServletResponse response) throws SQLException{
		return service.queryJob();
	}
	
	@RequestMapping("/job/delete")
	public void addJob(Integer jobId,HttpServletRequest request,HttpServletResponse response) throws SQLException{
		service.deleteJob(jobId);
	}
	
	@ResponseBody
	@RequestMapping("/job/get")
	public Job getJob(Integer jobId,HttpServletRequest request,HttpServletResponse response) throws SQLException{
		return service.queryJobById(jobId);
	}
	
	@RequestMapping("/job/update")
	public void updateJob(Job job,HttpServletRequest request,HttpServletResponse response) throws SQLException{
		service.updateJob(job);
	}
	
}
