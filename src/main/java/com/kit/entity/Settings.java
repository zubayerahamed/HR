package com.kit.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

import com.kit.converter.KitTimeConverter;
import com.kit.enums.Days;
import com.kit.util.KitTime;

import lombok.Data;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
@Data
@Entity
@Table(name = "SETTINGS")
public class Settings implements Serializable{

	private static final long serialVersionUID = -6383544523056927687L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String companyName;
	private String address;
	private String phone1;
	private String phone2;
	private String mobile1;
	private String mobile2;
	private String mobile3;
	@Lob
	private byte[] photo;
	@Convert(converter = KitTimeConverter.class)
	private KitTime officeInTime;
	@Convert(converter = KitTimeConverter.class)
	private KitTime officeOutTime;
	private int officeHour;
	private BigDecimal foodBill;
	private int allocatedLeave;
	private int maxCarryLeaveFromPrevYear;

	private boolean sat;
	private boolean sun;
	private boolean mon;
	private boolean tue;
	private boolean wed;
	private boolean thu;
	private boolean fri;

	@Transient
	private String holidays;
	@Transient
	private String inTimeF;
	@Transient
	private String outTimeF;

	public String getInTimeF() {
		if(officeInTime == null) return "";
		return officeInTime.getT5Time();
	}
	public String getOutTimeF() {
		if(officeOutTime == null) return "";
		return officeOutTime.getT5Time();
	}

	public String getHolidays() {
		this.holidays = "";
		if(Boolean.TRUE.equals(sat)) holidays += Days.SAT.name() + ',';
		if(Boolean.TRUE.equals(sun)) holidays += Days.SUN.name() + ',';
		if(Boolean.TRUE.equals(mon)) holidays += Days.MON.name() + ',';
		if(Boolean.TRUE.equals(tue)) holidays += Days.TUE.name() + ',';
		if(Boolean.TRUE.equals(wed)) holidays += Days.WED.name() + ',';
		if(Boolean.TRUE.equals(thu)) holidays += Days.THU.name() + ',';
		if(Boolean.TRUE.equals(fri)) holidays += Days.FRI.name() + ',';

		if(!StringUtils.hasText(holidays)) return holidays;

		int lastComma = holidays.lastIndexOf(',');
		String finalString = holidays.substring(0, lastComma);
		holidays = finalString;
		return holidays;
	}
}
