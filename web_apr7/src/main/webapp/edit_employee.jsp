<%@page import="com.flm.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Employee</title>
</head>
<body>
<h1>Edit Employee</h1>
<%
Employee emp=(Employee)request.getAttribute("emp");
%>
<form action="updateEmployee" method="post">
<table border="1">
<tr>
<td>Id:</td>
<td><input readonly="readonly" name="emp_id" value="<%=emp.getId() %>"></td>
</tr>
<tr>
<td>FirstName:</td>
<td><input type="text" name="f_name" value="<%=emp.getFname() %>"></td>
</tr>
<tr>
<td>LastName:</td>
<td><input type="text" name="l_name" value="<%=emp.getFname() %>"></td>
</tr>
<tr>
<td>Salary:</td>
<td><input type="number" name="emp_salary" value="<%=emp.getSalary() %>"></td>
</tr>
<tr>
<td>Address:</td>
<td><input type="text" name="emp_address" value="<%=emp.getAddress() %>"></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="Update_Employee">&nbsp;&nbsp;<a href="fetchAllEmployee">Cancel</a></td>
</tr>

</table>
</form>
</body>
</html>