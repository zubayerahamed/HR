package com.kit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.entity.Salary;

/**
 * @author Zubayer Ahamed
 * @since Aug 22, 2022
 */
@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {

	List<Salary> findAllByMonthAndYear(String month, String year);
}
