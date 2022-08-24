package com.kit.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.kit.entity.Designation;
import com.kit.repository.DesignationRepository;
import com.kit.service.DesignationService;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
@Service
public class DesignationServiceImpl implements DesignationService {

	@Autowired private DesignationRepository desRepo;

	@Transactional
	@Override
	public Designation save(Designation dep) {
		if(dep == null) return null;
		if(!StringUtils.hasText(dep.getName())) return null;
		return desRepo.save(dep);
	}

	@Override
	public Designation find(Long id) {
		if(id == null) return null;
		Optional<Designation> op = desRepo.findById(id);
		if(op.isPresent()) return op.get();
		return null;
	}

	@Override
	public List<Designation> getAll() {
		return desRepo.findAll();
	}
}
