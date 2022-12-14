package com.kit.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.entity.Attendance;

/**
 * @author Zubayer Ahamed
 * @since Aug 23, 2022
 */
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long>{

	public List<Attendance> findAllByDate(Date date);
	public List<Attendance> findAllByMonthAndYear(String month, String year);
	public List<Attendance> findAllByUserIdAndMonthAndYear(Long userId, String month, String year);
}
