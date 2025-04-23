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

@WebServlet("/DeleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
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
		crud.deleteEmployees(Long.valueOf(id));
		response.sendRedirect("fetchAllEmployee");
	}
	@Override
	public void destroy() {
		System.out.println("tomact is stopped");
		crud.closeConnection();
	}


}
