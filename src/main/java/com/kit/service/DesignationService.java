package com.kit.service;

import java.util.List;

import com.kit.entity.Designation;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
public interface DesignationService {

	public Designation save(Designation dep);
	public Designation find(Long id);
	public List<Designation> getAll();
}
