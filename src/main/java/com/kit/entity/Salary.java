package com.kit.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Aug 22, 2022
 */
@Data
@Entity
@Table(name = "SALARY")
public class Salary implements Serializable {

	private static final long serialVersionUID = -8356774197287708145L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long userId;

	private String year;
	private String month;
	@Temporal(TemporalType.DATE)
	private Date date;

	private BigDecimal totalSalary = BigDecimal.ZERO;
	@Transient
	private List<SalaryBreakdown> breakdown;
	private BigDecimal payableAfterBreakDown = BigDecimal.ZERO;
	private int totalLeaveTakenInYear;
	private int totalWorkingDaysInMonth;
	private int totalAttendInMonth;
	private int leaveTakenInMonth;
	private int totalLateInMonth;
	private int totalUndeclearedTaskInMonth;
	private int totalUnpaidLeaveInMonth;
	private BigDecimal unpaidLeaveAmount = BigDecimal.ZERO;
	private int totalFoodDaysInMonth;
	private BigDecimal foodBillInMonth = BigDecimal.ZERO;
	private BigDecimal netPayable = BigDecimal.ZERO;

	private boolean approved;

	@Transient
	private String username;
}
