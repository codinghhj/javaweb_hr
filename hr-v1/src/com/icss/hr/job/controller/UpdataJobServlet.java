package com.icss.hr.job.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.job.pojo.Job;
import com.icss.hr.job.service.JobService;


@WebServlet("/UpdataJobServlet")
public class UpdataJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Integer jobId = Integer.parseInt(request.getParameter("jobId"));
		String jobName = request.getParameter("jobName");
		Integer jobMinSal = Integer.parseInt(request.getParameter("jobMinSal"));
		Integer jobMaxSal = Integer.parseInt(request.getParameter("jobMaxSal"));
		JobService service = new JobService();
		Job job = new Job(jobId,jobName,jobMinSal,jobMaxSal);
		try {
			 service.updateJob(job);
			 out.print("ÐÞ¸Ä³É¹¦");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
