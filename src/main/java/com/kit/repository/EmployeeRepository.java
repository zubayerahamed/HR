package com.kit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.entity.Employee;

/**
 * @author Zubayer Ahamed
 * @since Aug 22, 2022
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Employee findByUserId(Long userId);
}
