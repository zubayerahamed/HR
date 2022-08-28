package com.kit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.entity.LeaveManager;

/**
 * @author Zubayer Ahamed
 * @since Aug 27, 2022
 */
@Repository
public interface LeaveManagerRepository extends JpaRepository<LeaveManager, Long>{

}
