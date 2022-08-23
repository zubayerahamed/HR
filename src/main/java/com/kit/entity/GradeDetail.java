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

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Aug 22, 2022
 */
@Data
@Entity
@Table(name = "GRADE_DETAIL")
public class GradeDetail implements Serializable{

	private static final long serialVersionUID = 8716037466026579848L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long gradeId;
	private Long transactionId;
	private Long percentOfTransactionId;

	@Enumerated(EnumType.STRING)
	private AmountType type;
	private BigDecimal amount;
}
