package com.kit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.entity.GradeDetail;

/**
 * @author Zubayer Ahamed
 * @since Aug 22, 2022
 */
@Repository
public interface GradeDetailRepository extends JpaRepository<GradeDetail, Long> {

}
