package com.kit.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kit.enums.AmountType;
import com.kit.enums.TransactionType;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Aug 29, 2022
 */
@Data
@Entity
@Table(name = "SALARY_BREAKDOWN")
public class SalaryBreakdown implements Serializable {

	private static final long serialVersionUID = -4363625944108595364L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long salaryId;
	private String name;
	@Enumerated(EnumType.STRING)
	private TransactionType trnType;
	@Enumerated(EnumType.STRING)
	private AmountType amountType;
	private BigDecimal amount;
	private String gradeName;
}
