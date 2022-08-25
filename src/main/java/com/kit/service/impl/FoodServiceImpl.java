package com.kit.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.entity.Food;
import com.kit.repository.FoodRepository;
import com.kit.service.FoodService;

/**
 * @author Zubayer Ahamed
 * @since Aug 25, 2022
 */
@Service
public class FoodServiceImpl implements FoodService {

	@Autowired private FoodRepository foodRepo;

	@Transactional
	@Override
	public Food save(Food food) {
		return foodRepo.save(food);
	}

	@Transactional
	@Override
	public List<Food> save(List<Food> foods) {
		return foodRepo.saveAll(foods);
	}

	@Override
	public List<Food> findByDate(Date date) {
		return foodRepo.findAllByDate(date);
	}

	@Override
	public List<Food> findByMonthAndYear(String month, String year) {
		return foodRepo.findAllByMonthAndYear(month, year);
	}

	@Override
	public Food find(Long id) {
		Optional<Food> o = foodRepo.findById(id);
		return o.isPresent() ? o.get() : null;
	}
}
