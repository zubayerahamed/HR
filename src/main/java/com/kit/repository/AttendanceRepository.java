package com.kit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.entity.Attendance;

/**
 * @author Zubayer Ahamed
 * @since Aug 23, 2022
 */
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long>{

}
