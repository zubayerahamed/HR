package com.kit.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.entity.Food;

/**
 * @author Zubayer Ahamed
 * @since Aug 25, 2022
 */
@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

	List<Food> findAllByDate(Date date);
	List<Food> findAllByMonthAndYear(String month, String year);
	List<Food> findAllByUserIdAndMonthAndYear(Long userId, String month, String year);
}
