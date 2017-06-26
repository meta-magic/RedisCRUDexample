package com.metamagicglobal.examples.redis.test;

import java.util.Map;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.metamagicglobal.examples.redis.entity.Employees;
import com.metamagicglobal.examples.redis.entity.Employees.Gender;
import com.metamagicglobal.examples.redis.repository.EmployeeRepository;

public class EmployeeTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new ClassPathResource("resources/spring-config.xml").getPath());
		EmployeeRepository empRepo = (EmployeeRepository) context.getBean("empRepo");

		Employees emp = new Employees();
		emp.setId("101");
		emp.setAge(55);
		emp.setGender(Gender.Female);
		emp.setName("Jenny Joe");

		empRepo.addEmployee(emp);

		Employees emp2 = new Employees();
		emp2.setId("102");
		emp2.setAge(60);
		emp2.setGender(Gender.Male);
		emp2.setName("John Doe");

		empRepo.addEmployee(emp2);

		Employees emp3 = new Employees();
		emp3.setId("103");
		emp3.setAge(25);
		emp3.setGender(Gender.Male);
		emp3.setName("Ken Peg");

		empRepo.addEmployee(emp3);

		Map<Object, Object> empMap = empRepo.getAllEmployees();

		System.out.println("Display All Employees");

		System.out.println(empMap);

		System.out.println("Find Employee by ID  : " + empRepo.getEmployeeById("103"));
		emp3.setAge(40);
		empRepo.updateEmployee(emp3);
		System.out.println("Employee after update  : " + empRepo.getEmployeeById("103"));
		
		System.out.println("Deleting Employee ID : 102 ");

		empRepo.delEmployeeById("102");
		
		System.out.println("Display All Employees");

		empMap = empRepo.getAllEmployees();

		System.out.println(empMap);

		context.close();

	}
}
