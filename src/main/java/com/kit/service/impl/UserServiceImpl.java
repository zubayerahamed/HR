package com.kit.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kit.entity.User;
import com.kit.repository.UserRepository;
import com.kit.service.UserService;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired private UserRepository usRepo;

	@Transactional
	@Override
	public User save(User us) {
		if(us == null) return null;
		if(us.getUsername() == null) return null;
		return usRepo.save(us);
	}

	@Override
	public User find(Long id) {
		Optional<User> op = usRepo.findById(id);
		if(op.isPresent()) return op.get();
		return null;
	}

	@Override
	public List<User> getAll() {
		return usRepo.findAll();
	}

	
}
