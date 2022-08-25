package com.kit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.kit.converter.KitTimeConverter;
import com.kit.enums.LeaveType;
import com.kit.util.KitTime;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Aug 23, 2022
 */
@Data
@Entity
@Table(name = "ATTENDANCE")
public class Attendance implements Serializable {

	private static final long serialVersionUID = 2967385567793679316L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long userId;
	private String deviceUserId;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String month;
	private String year;
	@Convert(converter = KitTimeConverter.class)
	private KitTime intime;
	@Convert(converter = KitTimeConverter.class)
	private KitTime outtime;
	private int late;
	private int overTime;
	private boolean present;
	private boolean publicHoliday;
	private boolean govtHoliday;
	private boolean personalLeave;
	@Enumerated(EnumType.STRING)
	private LeaveType personalLeaveType;
	private String personalLeaveReason;

	@Transient
	private String username;
}
