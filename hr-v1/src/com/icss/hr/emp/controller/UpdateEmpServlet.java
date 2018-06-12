package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.DeptService;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;
import com.icss.hr.job.pojo.Job;
import com.icss.hr.job.service.JobService;

/**
 * Servlet implementation class UpdateEmpServlet
 */
@WebServlet("/UpdateEmpServlet")
public class UpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Integer empId = Integer.parseInt(request.getParameter("empId"));
		String empName = request.getParameter("empName");
		String empLoginName = request.getParameter("empLoginName");
		String empPwd = request.getParameter("empPwd");
		String empEmail = request.getParameter("empEmail");
		String empPhone = request.getParameter("empPhone");
		String empHireDate = request.getParameter("empHireDate");
		String empSalary = request.getParameter("empSalary");
		String deptId = request.getParameter("deptId");
		String jobId = request.getParameter("jobId");
		String empInfo = request.getParameter("empInfo");
		
		Dept dept;
		try {
			dept = new DeptService().queryDeptById(Integer.parseInt(deptId));
			Job job = new JobService().queryJobById(Integer.parseInt(jobId));
			Emp emp = new Emp(empId,empName,empLoginName,empPwd,empEmail,empPhone,Date.valueOf(empHireDate),Double.parseDouble(empSalary),dept,job,null,empInfo);
			EmpService service = new EmpService();
			service.updateEmp(emp);
			out.print("修改员工成功");
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
