package com.kit.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.kit.entity.Settings;
import com.kit.service.SettingsService;

/**
 * @author Zubayer Ahamed
 * @since Aug 24, 2022
 */
@Component
public class Util {

	@Autowired private SettingsService settingService;

	private static final SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
	private static final SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

	public Settings getSettings() {
		return settingService.getAll().stream().findFirst().orElse(null);
	}

	public static String getMonthFromDate(Date date) {
		if(date == null) return null;
		return monthFormat.format(date).toUpperCase();
	}

	public static String getYearFromDate(Date date) {
		if(date == null) return null;
		return yearFormat.format(date).toUpperCase();
	}

	public long getOvertimeDutyInMin(KitTime inTime, KitTime outTime, int officeHour) {
		Calendar expected = Calendar.getInstance();
		expected.set(Calendar.HOUR_OF_DAY, inTime.getHour());
		expected.set(Calendar.MINUTE, inTime.getMinute());
		expected.set(Calendar.SECOND, 0);

		Calendar current = Calendar.getInstance();
		current.set(Calendar.HOUR_OF_DAY, outTime.getHour());
		current.set(Calendar.MINUTE, outTime.getMinute());
		current.set(Calendar.SECOND, 0);

		long differenceInMilliSeconds = Math.abs(current.getTime().getTime() - expected.getTime().getTime());
		long differenceHours = differenceInMilliSeconds / (60 * 60 * 1000) % 24;
		long differenceInMinutes = differenceInMilliSeconds / (60 * 1000) % 60;

		long totalMin  = differenceHours * 60 + differenceInMinutes;

		return totalMin - officeHour;
	}

	public long getLateAttendanceInMin(KitTime expectedInTime, KitTime actualInTime) {
		Calendar expected = Calendar.getInstance();
		expected.set(Calendar.HOUR_OF_DAY, expectedInTime.getHour());
		expected.set(Calendar.MINUTE, expectedInTime.getMinute());
		expected.set(Calendar.SECOND, 0);

		Calendar current = Calendar.getInstance();
		current.set(Calendar.HOUR_OF_DAY, actualInTime.getHour());
		current.set(Calendar.MINUTE, actualInTime.getMinute());
		current.set(Calendar.SECOND, 0);

		long differenceInMilliSeconds = current.getTime().getTime() - expected.getTime().getTime();
		long differenceHours = differenceInMilliSeconds / (60 * 60 * 1000) % 24;
		long differenceInMinutes = differenceInMilliSeconds / (60 * 1000) % 60;

		long totalMin  = differenceHours * 60 + differenceInMinutes;

		return totalMin < 0 ? 0 : totalMin;
	}
	

	/**
	 * Get total days of month
	 * @param month
	 * @param year
	 * @return
	 * @throws ParseException
	 */
	public int totalDaysOfMonth(String month, String year) throws ParseException {
		if(StringUtils.hasText(month) || StringUtils.hasText(year)) return 0;
		String month1stDate = year + "-" + month + "-" + "01"; 

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(month1stDate);

		Calendar selectedMonth = Calendar.getInstance();
		selectedMonth.setTime(date);
		return selectedMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Get total days of month
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public int totalDaysOfMonth(Date date) {
		Calendar selectedMonth = Calendar.getInstance();
		selectedMonth.setTime(date);
		return selectedMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Get total days of month
	 * @param date
	 * @param sdf
	 * @return
	 * @throws ParseException
	 */
	public int totalDaysOfMonth(String date, SimpleDateFormat sdf) throws ParseException {
		Calendar selectedMonth = Calendar.getInstance();
		selectedMonth.setTime(sdf.parse(date));
		return selectedMonth.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
}
