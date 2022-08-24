package com.kit.service;

import java.util.List;

import com.kit.entity.Transaction;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
public interface TransactionService {

	public Transaction save(Transaction trn);
	public Transaction find(Long id);
	public List<Transaction> getAll();
}
