package com.kit.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Aug 29, 2022
 */
@Data
//@Entity
//@Table(name = "SALARY_DEDUCTION")
public class SalaryDeduction implements Serializable {

	private static final long serialVersionUID = 2527495982442523137L;

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long salaryId;

	

}
