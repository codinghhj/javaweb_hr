package com.icss.hr.dept.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.DeptService;

/**
 * Servlet implementation class GetDeptServlet
 */
@WebServlet("/GetDeptServlet")
public class GetDeptServlet extends HttpServlet {
	
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new GsonBuilder()  
		  .setDateFormat("yyyy-MM-dd")  
		  .create();
		response.setContentType("text/html;charset=utf-8");
		Integer deptId = Integer.parseInt(request.getParameter("deptId"));
		PrintWriter out = response.getWriter();
		DeptService service = new DeptService();
		try {
			Dept dept = service.queryDeptById(deptId);
			out.print(gson.toJson(dept));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
