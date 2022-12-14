package com.kit.service;

import java.util.Date;
import java.util.List;

import com.kit.entity.Attendance;

/**
 * @author Zubayer Ahamed
 * @since Aug 25, 2022
 */
public interface AttendanceService {

	public Attendance save(Attendance att);
	public List<Attendance> save(List<Attendance> atts);
	public List<Attendance> findByDate(Date date);
	public List<Attendance> findByMonthAndYear(String month, String year);
	public Attendance find(Long id);
	public int totalPresentInMonth(Long userId, String month, String year);
	public int totalAbsentInMonth(Long userId, String month, String year);
	public int totalLateDaysInMonth(Long userId, String month, String year);
	public int totalUnpaidLeaveInMonth(Long userId, String month, String year);
}
