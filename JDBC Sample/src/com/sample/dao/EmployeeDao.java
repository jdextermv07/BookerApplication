package com.sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sample.beans.Employee;

public class EmployeeDao {

	public List<Employee> getEmployee(){
		
		List<Employee> employees = new ArrayList<Employee>();
		
		ConnectionManager conmgr = new ConnectionManager();
		Connection conn = conmgr.connect();
		
		String query = "select employee_number,firstname,lastname from employees";
		
		try {
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				
				Employee employee = new Employee();
				
				employee.setEmployeeNumber(rs.getString("employee_number"));
				employee.setFirstname(rs.getString("firstname"));
				employee.setLastname(rs.getString("lastname"));
				
				employees.add(employee);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return employees;
		
	}
	
	public Employee getEmployeeByEmployeeNumber(String employeeNumber) {
		Employee emp = new Employee();
		ConnectionManager connmgr = new ConnectionManager();
		Connection conn = connmgr.connect();
		
		String sql = "select employee_number,firstname,lastname from employee where employee_number = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employeeNumber);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setEmployeeNumber(rs.getString("employee_number"));
				employee.setFirstname(rs.getString("firstname"));
				employee.setLastname(rs.getString("lastname"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return emp;
	}
	
	public int addEmployee(Employee employee) {
		int result = 0;
		ConnectionManager connmgr = new ConnectionManager();
		Connection conn = connmgr.connect();
		
		String sql = "insert into employee(employee_number,firstname,lastname) values (?,?,?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getEmployeeNumber());
			ps.setString(2, employee.getFirstname());
			ps.setString(3, employee.getLastname());
			
			result = ps.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	
	
}
