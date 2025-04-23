package com.flm.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.flm.dao.EmployeeDao;
import com.flm.model.Employee;

@WebServlet("/editEmployee")
public class EditEmployeeSevlet extends HttpServlet {
	private EmployeeDao crud=null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		crud=new EmployeeDao();
		System.out.println("EmployeeDAO Object is created");
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("emp_id");
		Employee emp=crud.getEmployees(Long.valueOf(id));
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("edit_employee.jsp").forward(request, response);
	}
	@Override
	public void destroy() {
		System.out.println("tomact is stopped");
		crud.closeConnection();
	}


}
