package com.kit.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.kit.entity.Department;
import com.kit.repository.DepartmentRepository;
import com.kit.service.DepartmentService;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired private DepartmentRepository depRepo;

	@Transactional
	@Override
	public Department save(Department dep) {
		if(dep == null) return null;
		if(!StringUtils.hasText(dep.getName())) return null;
		return depRepo.save(dep);
	}

	@Override
	public Department find(Long id) {
		if(id == null) return null;
		Optional<Department> op = depRepo.findById(id);
		if(op.isPresent()) return op.get();
		return null;
	}

	@Override
	public List<Department> getAll() {
		return depRepo.findAll();
	}

	
}
