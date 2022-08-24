package com.kit.service;

import java.util.List;

import com.kit.entity.Department;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
public interface DepartmentService {

	public Department save(Department dep);
	public Department find(Long id);
	public List<Department> getAll();
}
