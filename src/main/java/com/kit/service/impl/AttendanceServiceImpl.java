package com.kit.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.entity.Attendance;
import com.kit.repository.AttendanceRepository;
import com.kit.service.AttendanceService;

/**
 * @author Zubayer Ahamed
 * @since Aug 25, 2022
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	private AttendanceRepository attRepo;

	@Transactional
	@Override
	public Attendance save(Attendance att) {
		return attRepo.save(att);
	}

	@Transactional
	@Override
	public List<Attendance> save(List<Attendance> atts) {
		return attRepo.saveAll(atts);
	}

	@Override
	public List<Attendance> findByDate(Date date) {
		return attRepo.findAllByDate(date);
	}

	@Override
	public List<Attendance> findByMonthAndYear(String month, String year) {
		return attRepo.findAllByMonthAndYear(month, year);
	}

	@Override
	public Attendance find(Long id) {
		Optional<Attendance> o = attRepo.findById(id);
		return o.isPresent() ? o.get() : null;
	}

}
