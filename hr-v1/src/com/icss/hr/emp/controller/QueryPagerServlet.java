package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.icss.hr.common.Pager;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;

/**
 * Servlet implementation class QueryPager
 */
@WebServlet("/QueryPagerServlet")
public class QueryPagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryPagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageString = request.getParameter("pageNum");
		
		//当前第几页啦
		int pageNum = 1;
		try {
			pageNum = Integer.parseInt(pageString);
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//每页数据条数
		String pageSizeString = request.getParameter("pageSize");
		int pageSize = 10;
		try {
			pageSize = Integer.parseInt(pageSizeString);
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		EmpService service = new EmpService();
		PrintWriter out = response.getWriter();
		//Gson对象
		Gson gson = new GsonBuilder()  
		  .setDateFormat("yyyy-MM-dd")  
		  .create(); 
		//获得总记录数啊
		int recordCount = 0;
		try {
			recordCount = service.getEmpCount();
			Pager pager = new Pager(recordCount, pageSize, pageNum);
			
			
			out.print(gson.toJson(pager));
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
