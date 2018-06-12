package com.icss.hr.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.icss.hr.emp.service.EmpService;

/**
 * 修改密码
 * @author Administrator
 *
 */
@WebServlet("/UpdateEmpPwdServlet")
public class UpdateEmpPwdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String empPwd = request.getParameter("empPwd");
	
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String empLoginName = (String) session.getAttribute("empLoginName");
		EmpService service = new EmpService();
		
		try {
			service.updateEmpPwd(empLoginName, empPwd);
			out.print("修改密码成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
