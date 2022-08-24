package com.kit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kit.entity.Settings;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
@Repository
public interface SettingsRepository extends JpaRepository<Settings, Long>{

}
