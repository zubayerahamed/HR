package com.kit.service;

import java.util.List;

import com.kit.entity.GradeDetail;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
public interface GradeDetailService {

	public GradeDetail save(GradeDetail gr);
	public GradeDetail find(Long id);
	public List<GradeDetail> getAll(Long gradeId);
	public void delete(Long id);
}
