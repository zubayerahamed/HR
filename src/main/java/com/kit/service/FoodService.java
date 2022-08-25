package com.kit.service;

import java.util.Date;
import java.util.List;

import com.kit.entity.Food;

/**
 * @author Zubayer Ahamed
 * @since Aug 25, 2022
 */
public interface FoodService {

	public Food save(Food food);
	public List<Food> save(List<Food> foods);
	public List<Food> findByDate(Date date);
	public List<Food> findByMonthAndYear(String month, String year);
	public Food find(Long id);
}
