package com.kit.service;

import java.util.List;

import com.kit.entity.LeaveManager;

/**
 * @author Zubayer Ahamed
 * @since Aug 28, 2022
 */
public interface LeaveManagerService {

	public LeaveManager save(LeaveManager lm);
	public List<LeaveManager> save(List<LeaveManager> lms);
	public List<LeaveManager> getAllByYear(String year);
	public LeaveManager findById(Long id);
}
