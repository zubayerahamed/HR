package com.kit.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Aug 22, 2022
 */
@Data
@Entity
@Table(name = "SALARY_INCREMENT")
public class SalaryIncrement implements Serializable {

	private static final long serialVersionUID = -8627640801421571533L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private BigDecimal previousSalary;
	private BigDecimal newSalary;
	private String startFromMonth;
	private String startFromYear;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private BigDecimal deviation;
}
