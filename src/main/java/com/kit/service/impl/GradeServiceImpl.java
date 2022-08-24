package com.kit.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.kit.entity.Grade;
import com.kit.repository.GradeRepository;
import com.kit.service.GradeService;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
@Service
public class GradeServiceImpl implements GradeService {

	@Autowired private GradeRepository grRepo;

	@Transactional
	@Override
	public Grade save(Grade gr) {
		if(gr == null) return null;
		if(!StringUtils.hasText(gr.getCode())) return null;
		return grRepo.save(gr);
	}

	@Override
	public Grade find(Long id) {
		if(id == null) return null;
		Optional<Grade> op = grRepo.findById(id);
		if(op.isPresent()) return op.get();
		return null;
	}

	@Override
	public List<Grade> getAll() {
		return grRepo.findAll();
	}
}
