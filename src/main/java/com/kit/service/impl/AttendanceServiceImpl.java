package com.kit.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.kit.entity.Attendance;
import com.kit.entity.Settings;
import com.kit.repository.AttendanceRepository;
import com.kit.service.AttendanceService;
import com.kit.service.SettingsService;
import com.kit.util.KitTime;
import com.kit.util.Util;

/**
 * @author Zubayer Ahamed
 * @since Aug 25, 2022
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {

	@Autowired
	private AttendanceRepository attRepo;
	@Autowired
	private SettingsService setService;

	@Transactional
	@Override
	public Attendance save(Attendance att) {
		return attRepo.save(att);
	}

	@Transactional
	@Override
	public List<Attendance> save(List<Attendance> atts) {
		Settings set = setService.getAll().stream().findFirst().orElse(null);

		for(Attendance i : atts) {
			i.setMonth(Util.getMonthFromDate(i.getDate()));
			i.setYear(Util.getYearFromDate(i.getDate()));
			i.setIntime(new KitTime(i.getInTimeF()));
			i.setOuttime(new KitTime(i.getOutTimeF()));
			if(i.isPresent()) {
				i.setLate(new Util().getLateAttendanceInMin(set.getOfficeInTime(), i.getIntime()));
				i.setOverTime(new Util().getOvertimeDutyInMin(i.getIntime(), i.getOuttime(), set.getOfficeHour()));
			}
			if(i.isHomeOffice() && StringUtils.hasText(i.getInTimeF()) &&StringUtils.hasText(i.getOutTimeF())) {
				i.setLate(new Util().getLateAttendanceInMin(set.getOfficeInTime(), i.getIntime()));
				i.setOverTime(new Util().getOvertimeDutyInMin(i.getIntime(), i.getOuttime(), set.getOfficeHour()));
			}
		}

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
