package com.kit.service;

import java.util.List;

import com.kit.entity.User;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
public interface UserService {

	public User save(User us);
	public User find(Long id);
	public List<User> getAll();
}
