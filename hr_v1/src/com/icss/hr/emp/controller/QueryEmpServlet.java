package com.icss.hr.emp.controller;

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

/**
 * ��ѯ����Ա������
 * @author Administrator
 *
 */
@WebServlet("/QueryEmpServlet")
public class QueryEmpServlet extends HttpServlet {

 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageString = request.getParameter("pageNum");
	
		//��ǰ�ڼ�ҳ��
		int pageNum = 1;
		try {
			pageNum = Integer.parseInt(pageString);
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//ÿҳ��������
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
		//Gson����
		Gson gson = new GsonBuilder()  
		  .setDateFormat("yyyy-MM-dd")  
		  .create(); 
		//����ܼ�¼����
		int recordCount = 0;
		try {
			recordCount = service.getEmpCount();
			Pager pager = new Pager(recordCount, pageSize, pageNum);
			List<Emp> list = service.queryEmpByPage(pager);
			//��map���ϴ洢��������
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("pager",pager);
			map.put("list",list);
			out.print(gson.toJson(map));
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
		doGet(request, response);
	}

}
