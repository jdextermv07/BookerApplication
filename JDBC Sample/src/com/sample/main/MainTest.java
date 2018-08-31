package com.sample.main;

import java.util.List;

import com.sample.beans.Employee;
import com.sample.manager.EmployeeManager;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EmployeeManager empMan = new EmployeeManager();
		List<Employee> employees = empMan.returnList();
		
		for(Employee emp:employees) {
			System.out.println(emp.getEmployeeNumber());
			System.out.println(emp.getFirstname());
			System.out.println(emp.getLastname());
			System.out.println("=================");
		}
	}

}
