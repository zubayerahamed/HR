package com.kit.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.kit.enums.Gender;
import com.kit.enums.PaymentType;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Aug 22, 2022
 */
@Data
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

	private static final long serialVersionUID = -6745623177627598263L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long userId;
	private Long gradeId;
	private Long departmentId;
	private Long designationId;

	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String mobile;
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Lob
	private byte[] photo;
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	@Temporal(TemporalType.DATE)
	private Date resignDate;
	@Temporal(TemporalType.DATE)
	private Date permanentDate;
	private BigDecimal totalSalary;
	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	private BigDecimal bankAmount;
	private BigDecimal cashAmount;
	private BigDecimal checkAmount;
	private String bankName;
	private String bankAccount;
	private String tin;
	private boolean status;


}
