package com.kit.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.entity.LeaveManager;
import com.kit.repository.LeaveManagerRepository;
import com.kit.service.LeaveManagerService;

/**
 * @author Zubayer Ahamed
 * @since Aug 28, 2022
 */
@Service
public class LeaveManagerServiceImpl implements LeaveManagerService {

	@Autowired
	private LeaveManagerRepository lmRepo;

	@Transactional
	@Override
	public LeaveManager save(LeaveManager lm) {

		return lmRepo.save(lm);
	}

	@Transactional
	@Override
	public List<LeaveManager> save(List<LeaveManager> lms) {
		return lmRepo.saveAll(lms);
	}

	@Override
	public List<LeaveManager> getAllByYear(String year) {
		return lmRepo.findAllByYear(year);
	}

	@Override
	public LeaveManager findById(Long id) {
		Optional<LeaveManager> o = lmRepo.findById(id);
		return o.isPresent() ? o.get() : null;
	}

}
