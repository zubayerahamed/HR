package com.kit.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.entity.GradeDetail;
import com.kit.repository.GradeDetailRepository;
import com.kit.service.GradeDetailService;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
@Service
public class GradeDetailServiceImpl implements GradeDetailService{

	@Autowired private GradeDetailRepository grdRepo;

	@Transactional
	@Override
	public GradeDetail save(GradeDetail gr) {
		if(gr == null) return null;
		if(gr.getGradeId() == null) return null;
		if(gr.getTransactionId() == null) return null;
		if(gr.getAmount().compareTo(BigDecimal.ZERO) == -1) return null;
		return grdRepo.save(gr);
	}

	@Override
	public GradeDetail find(Long id) {
		if(id == null) return null;
		Optional<GradeDetail> op = grdRepo.findById(id);
		if(op.isPresent()) return op.get();
		return null;
	}

	@Override
	public List<GradeDetail> getAll(Long gradeId) {
		return grdRepo.findAllByGradeId(gradeId);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		grdRepo.delete(find(id));
	}

}
