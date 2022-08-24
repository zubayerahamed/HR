package com.kit.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.entity.Settings;
import com.kit.repository.SettingsRepository;
import com.kit.service.SettingsService;

/**
 * @author Zubayer Ahamed
 * @since Aug 25, 2022
 */
@Service
public class SettingsServiceImpl implements SettingsService{
	
	@Autowired private SettingsRepository sRepo;

	@Transactional
	@Override
	public Settings save(Settings s) {
		if(s == null) return null;
		return sRepo.save(s);
	}

	@Override
	public Settings find(Long id) {
		Optional<Settings> o = sRepo.findById(id);
		return o.isPresent() ? o.get() : null; 
	}

	@Override
	public List<Settings> getAll() {
		return sRepo.findAll();
	}

	
}
