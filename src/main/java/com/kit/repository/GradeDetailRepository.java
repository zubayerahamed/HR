package com.kit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.entity.GradeDetail;

/**
 * @author Zubayer Ahamed
 * @since Aug 22, 2022
 */
@Repository
public interface GradeDetailRepository extends JpaRepository<GradeDetail, Long> {

	List<GradeDetail> findAllByGradeId(Long gradeId);
}
