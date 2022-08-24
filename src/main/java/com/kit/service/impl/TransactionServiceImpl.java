package com.kit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.kit.entity.Transaction;
import com.kit.repository.TransactionRepository;
import com.kit.service.TransactionService;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired private TransactionRepository trnRepo;

	@Override
	public Transaction save(Transaction trn) {
		if(trn == null) return null;
		if(!StringUtils.hasText(trn.getName())) return null;
		return trnRepo.save(trn);
	}

	@Override
	public Transaction find(Long id) {
		if(id == null) return null;
		Optional<Transaction> op = trnRepo.findById(id);
		if(op.isPresent()) return op.get();
		return null;
	}

	@Override
	public List<Transaction> getAll() {
		return trnRepo.findAll();
	}

}
