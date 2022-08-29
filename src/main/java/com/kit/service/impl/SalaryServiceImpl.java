package com.kit.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.entity.Salary;
import com.kit.repository.SalaryRepository;
import com.kit.service.SalaryService;

/**
 * @author Zubayer Ahamed
 * @since Aug 29, 2022
 */
@Service
public class SalaryServiceImpl implements SalaryService {

	@Autowired private SalaryRepository salRepo;

	@Transactional
	@Override
	public Salary save(Salary salary) {
		return salRepo.save(salary);
	}

	@Transactional
	@Override
	public List<Salary> save(List<Salary> salaries) {
		return salRepo.saveAll(salaries);
	}

	@Override
	public Salary find(Long id) {
		Optional<Salary> o = salRepo.findById(id);
		return o.isPresent() ? o.get() : null;
	}

	@Override
	public List<Salary> getAllByMonthAndYear(String month, String year) {
		return salRepo.findAllByMonthAndYear(month, year);
	}

	
}
