package com.kit.service;

import java.util.List;

import com.kit.entity.Salary;

/**
 * @author Zubayer Ahamed
 * @since Aug 29, 2022
 */
public interface SalaryService {

	public Salary save(Salary salary);
	public List<Salary> save(List<Salary> salaries);
	public Salary find(Long id);
	public List<Salary> getAllByMonthAndYear(String month, String year);
}
