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
	private long late;
	private long overTime;
	private boolean present;
	private boolean publicHoliday;
	private boolean govtHoliday;
	private boolean personalLeave;
	@Enumerated(EnumType.STRING)
	private LeaveType personalLeaveType;
	private String personalLeaveReason;
	private boolean approved;
	private boolean homeOffice;

	@Transient
	private String username;
	@Transient
	private String leaveType;
	@Transient
	private String selectedLeaveType;
	@Transient
	private String inTimeF;
	@Transient
	private String outTimeF;

	public String getInTimeF() {
		if(intime == null) return "";
		return intime.getT5Time();
	}
	public String getOutTimeF() {
		if(outtime == null) return "";
		return outtime.getT5Time();
	}
	

	public String getSelectedLeaveType() {
		if(personalLeaveType != null) return personalLeaveType.name();
		return "";
	}
}
