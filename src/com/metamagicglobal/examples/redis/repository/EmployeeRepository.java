package com.metamagicglobal.examples.redis.repository;

import java.util.Map;

import com.metamagicglobal.examples.redis.entity.Employees;


public interface EmployeeRepository 
{
		public void addEmployee(Employees employee);
		
		public Employees getEmployeeById(String id);
		
		public Map<Object, Object> getAllEmployees();
		
		void updateEmployee(Employees employee);

		public void	delEmployeeById(String id);
}
