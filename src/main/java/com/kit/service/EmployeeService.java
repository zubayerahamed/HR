package com.kit.service;

import java.util.List;

import com.kit.entity.Employee;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
public interface EmployeeService {

	public Employee save(Employee emp);
	public Employee find(Long id);
	public List<Employee> getAll();
	public Employee getByUserId(Long userId);
}
