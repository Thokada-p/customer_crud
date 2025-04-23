package com.flm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flm.model.Employee;

public class EmployeeDao {
	private static Connection con=null;
	private Connection getConnection() {
		System.out.println("Entered into getConnection() method");
		String driver="com.mysql.cj.jdbc.Driver";
		String user="root";
		String pwd="1234";
		String url="jdbc:mysql://localhost:3306/flm";
		if(con==null) {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection(url, user, pwd);
			System.out.println("connection object is created");
		}catch(Exception ex) {
			System.out.println("Connection err: "+ex.getMessage());
		}
		}
		return con;
	}
	public void closeConnection() {
		System.out.println("Entered into closeConnection()");
		try {
			con.close();
			System.out.println("connection object is destroyed");
			
		}catch(Exception ex) {
			System.out.println("Connection err: "+ex.getMessage());
		}
	}
	
public List<Employee> getAllEmployees(){
	System.out.println("Entered.. into getAllEmloyee()");
	List<Employee> employees=new ArrayList<Employee>();
	
	
	try(Statement stmt=getConnection().createStatement();
		ResultSet rs=stmt.executeQuery("select * from employee");){
	
		    
		   while(rs.next()) {
		    	long id=rs.getInt("id");
		    	String fname=rs.getString("firstName");
		    	String lname=rs.getString("lastName");
		    	double salary=rs.getDouble("salary");
		    	String address=rs.getString("address");
		    	
		    	Employee emp=new Employee(id,fname,lname,salary,address);
		    	employees.add(emp);
		    		
		   }

		   
	  } catch(SQLException ex) {
		System.out.println("Error:"+ex.getMessage());
	}
	 return employees;
}
public void SaveEmployees(Employee emp){
	System.out.println("Entered.. into SaveEmloyees()");
	try(PreparedStatement pst=getConnection().prepareStatement(
			"insert into employee(firstName,lastName,salary,address) values(?,?,?,?)");){
		  pst.setString(1, emp.getFname());
		  pst.setString(2, emp.getLname());
		  pst.setDouble(3, emp.getSalary());
		  pst.setString(4, emp.getAddress());
		    		
		   pst.execute();

		   
} catch(SQLException ex) {
		System.out.println("Error:"+ex.getMessage());
	}
	 
}

public void deleteEmployees(Long id) {
	System.out.println("Entered.. into deleteEmloyees()");
	try (PreparedStatement pst = getConnection().prepareStatement("delete from employee where id=?");) {
		
		pst.setLong(1, id);

		pst.executeUpdate();

	} catch (SQLException ex) {
		System.out.println("Error:" + ex.getMessage());
	}

}
public Employee getEmployees(Long id) {
	System.out.println("Entered into getEmployee()");
	Employee emp=null;
	
	try(PreparedStatement pst=getConnection().prepareStatement("select * from employee where id=?")){
		pst.setLong(1, id);
		ResultSet rs=pst.executeQuery();
		rs.next();//Loop akarledu-->one time execute chalu
		String fname=rs.getString("firstName");
		String lname=rs.getString("lastName");
		double salary=rs.getDouble("salary");
		String address=rs.getString("address");
		emp=new Employee(id,fname,lname,salary,address);
	}catch (SQLException ex) {
		System.out.println("Error:" + ex.getMessage());
	}
	return emp;
	
	
}
public void updateEmployees(Employee emp){
	System.out.println("Entered.. into UpdateEmloyees()");
	try(PreparedStatement pst=getConnection().prepareStatement(
			"update employee set firstName=?,lastName=?,salary=?,address=? where id=?");){
		  pst.setString(1, emp.getFname());
		  pst.setString(2, emp.getLname());
		  pst.setDouble(3, emp.getSalary());
		  pst.setString(4, emp.getAddress());
		  pst.setLong(5,emp.getId());
		   pst.execute();

		   
} catch(SQLException ex) {
		System.out.println("Error:"+ex.getMessage());
	}
	 
}
}
