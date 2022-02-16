package com.rasheed.app.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Employee {

	private int empId;
	private String employeeName;
	private int deptId;
	private String status = "active";
	private int salary;

	public int getEmpId()
	{
		return empId;
	}

	public void setEmpId(int empId) 
	{
		this.empId = empId;
	}

	public String getEmployeeName() 
	{
		return employeeName;
	}

	public void setEmployeeName(String employeeName) 
	{
		this.employeeName = employeeName;
	}

	public int getDeptId()
	{
		return deptId;
	}

	public Employee(int empId, String employeeName, int deptId, String status, int salary)
	{
		super();
		this.empId = empId;
		this.employeeName = employeeName;
		this.deptId = deptId;
		this.status = status;
		this.salary = salary;
	}

	@Override
	public String toString()
	{
		return "Employee [empId=" + empId + ", employeeName=" + employeeName + ", deptId=" + deptId + ", status="
				+ status + ", salary=" + salary + "]";
	}

	public void setDeptId(int deptId)
	{
		this.deptId = deptId;
	}

	public String getStatus() 
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public int getSalary()
	{
		return salary;
	}

	public void setSalary(int salary) 
	{
		this.salary = salary;
	}

	public static void main(String[] args) 
	{
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(101, "Siva", 101, "active", 2000));
		empList.add(new Employee(102, "Reddy", 101, "active", 5000));
		empList.add(new Employee(103, "Raju", 102, "inactive", 6000));
		empList.add(new Employee(104, "sivam", 102, "inactive", 4000));
		empList.add(new Employee(105, "Bob", 103, "active", 3500));
		empList.add(new Employee(106, "alice", 103, "inactive", 3500));
		empList.add(new Employee(107, "srinu", 101, "active", 3500));

		// print employees based on dept
		Map<Integer, List<Employee>> emp = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptId, Collectors.toList()));

		emp.entrySet().forEach(entry -> {

			System.out.println("key" + entry.getKey() + "corresponding dept" + entry.getValue());
		}

		);

		// find the count of employees working in each department

		Map<Integer, Long> empCountByDept = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptId, Collectors.counting()));

		empCountByDept.entrySet().forEach(entry -> {
			System.out.println("key" + entry.getKey() + "---------" + entry.getValue());
		});

		// find the active employees and inactive employees
		Long ong = empList.stream().filter(e -> e.status.equalsIgnoreCase("active")).count();

		System.out.println("active employees" + ong);

		// find the employee having max salary
		OptionalInt l = empList.stream().mapToInt(Employee::getSalary).max();

		// find the employee having max salary
		Optional<Employee> mployee = empList.stream().max(Comparator.comparing(Employee::getSalary));

		System.out.println(mployee.get());

		// get max salary in each department
		Map<Integer, Optional<Employee>> map3 = empList.stream().collect(Collectors.groupingBy(Employee::getDeptId,
				Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));

	}

}
