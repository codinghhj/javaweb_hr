package com.icss.hr.analyze.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.icss.hr.analyze.dto.DeptEmpCount;
import com.icss.hr.analyze.service.AnaService;

/**
 * 查询部门人数
 * @author Administrator
 *
 */
@WebServlet("/QueryDeptEmpCountServlet")
public class QueryDeptEmpCountServlet extends HttpServlet implements Servlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		AnaService service = new AnaService();
		Gson gson = new Gson();
		try {
			List<DeptEmpCount> list = service.queryEmpCounts();
			out.print(gson.toJson(list));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
