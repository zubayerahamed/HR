package com.kit.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.entity.Employee;
import com.kit.repository.EmployeeRepository;
import com.kit.service.EmployeeService;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired private EmployeeRepository empRepo;

	@Transactional
	@Override
	public Employee save(Employee emp) {
		if(emp == null) return null;
		if(emp.getUserId() == null) return null;
		if(emp.getGradeId() == null) return null;
		if(emp.getDepartmentId() == null) return null;
		if(emp.getDesignationId() == null) return null;
		return empRepo.save(emp);
	}

	@Override
	public Employee find(Long id) {
		if(id == null) return null;
		Optional<Employee> op = empRepo.findById(id);
		if(op.isPresent()) return op.get();
		return null;
	}

	@Override
	public List<Employee> getAll() {
		return empRepo.findAll();
	}

	
}
