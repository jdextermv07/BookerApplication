package com.sample.manager;

import java.util.List;

import com.sample.beans.Employee;
import com.sample.dao.EmployeeDao;

public class EmployeeManager {

	public List<Employee> returnList() {
		EmployeeDao empDao = new EmployeeDao();
		return empDao.getEmployee();

	}
}
