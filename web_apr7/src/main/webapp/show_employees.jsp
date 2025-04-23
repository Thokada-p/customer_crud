<%@ page import="java.util.List" %>
<%@ page import="com.flm.dao.EmployeeDao" %>
<%@ page import="com.flm.model.Employee" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Employee info</h1>
<a href="add_employee.html">Add Employee</a>

<table border="1" width="100">
<tr>
<th>Id</th>
<th>FirstName</th>
<th>LastName</th>
<th>Salary</th>
<th>Address</th>
<th>Edit Action</th>
<th>Delete Action</th>
</tr>
<%
List<Employee> employees=(List<Employee>)request.getAttribute("emp");
if(employees.size()==0){
	%>
	<tr>
	<td colspan="7">No Employees Found</td>
	</tr>
<% }


	 for(Employee emp:employees){
		%>
    <tr>
		<td><%=emp.getId() %></td>
		<td><%=emp.getFname() %></td>
		<td><%=emp.getLname() %></td>
		<td><%=emp.getSalary() %></td>
		<td><%=emp.getAddress() %></td>
		<td><a href="editEmployee?emp_id=<%=emp.getId() %>">Edit</a></td>
		<td><a href="DeleteEmployee?emp_id=<%=emp.getId() %>">Delete</a></td>
	</tr>
<%	}
%>
</table>
</body>
</html>