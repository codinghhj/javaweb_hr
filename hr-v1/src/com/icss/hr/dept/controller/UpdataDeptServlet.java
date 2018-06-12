package com.icss.hr.dept.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.DeptService;


@WebServlet("/UpdataDeptServlet")
public class UpdataDeptServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
		//输出流
		PrintWriter out = response.getWriter();
		//获得表单数据
		Integer deptId = Integer.parseInt(request.getParameter("deptId"));
		String deptName = request.getParameter("deptName");
		String deptLoc = request.getParameter("deptLoc");
		Dept dept = new Dept(deptId,deptName,deptLoc);	
		//调用业务功能
		DeptService service = new DeptService();
		try {
			service.updateDept(dept);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.print("修改部门成功");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
