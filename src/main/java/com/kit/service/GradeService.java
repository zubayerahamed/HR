package com.kit.service;

import java.util.List;

import com.kit.entity.Grade;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
public interface GradeService {

	public Grade save(Grade gr);
	public Grade find(Long id);
	public List<Grade> getAll();
}
