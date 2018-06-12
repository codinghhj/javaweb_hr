package com.icss.hr.pic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
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
import com.icss.hr.pic.pojo.Pic;
import com.icss.hr.pic.service.picService;

/**
 * Servlet implementation class QueryPicServlet
 */
@WebServlet("/QueryPicServlet")
public class QueryPicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

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
		
		picService service = new picService();
		PrintWriter out = response.getWriter();
		//Gson对象
		Gson gson = new GsonBuilder()  
		  .setDateFormat("yyyy-MM-dd")  
		  .create(); 
		//获得总记录数啊
		int recordCount = 0;
		try {
			recordCount = service.getPicCount();
			Pager pager = new Pager(recordCount, pageSize, pageNum);
			List<Pic> list = service.queryPicByPage(pager);
			//用map集合存储俩项数据
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("pager",pager);
			map.put("list",list);
			out.print(gson.toJson(map));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
