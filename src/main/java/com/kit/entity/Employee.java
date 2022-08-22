package com.kit.entity;

import java.io.Serializable;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private long userId;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String mobile;
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Lob
	private byte[] photo;
	private Long gradeId;
	@Temporal(TemporalType.DATE)
	private Date joiningDate;
	@Temporal(TemporalType.DATE)
	private Date resignDate;
	@Temporal(TemporalType.DATE)
	private Date permanentDate;

	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	private String bankName;
	private String bankAccount;
	private String tin;
	private boolean status;

	private Long departmentId;
	private Long designationId;
}
