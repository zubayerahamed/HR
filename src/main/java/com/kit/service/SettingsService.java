package com.kit.service;

import java.util.List;

import com.kit.entity.Settings;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
public interface SettingsService {

	public Settings save(Settings dep);
	public Settings find(Long id);
	public List<Settings> getAll();
}
