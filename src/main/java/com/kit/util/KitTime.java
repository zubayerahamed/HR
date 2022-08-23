package com.kit.util;

import static java.util.Calendar.HOUR_OF_DAY;
import static java.util.Calendar.MINUTE;
import static java.util.Calendar.SECOND;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import com.kit.exception.TimeFormatException;

/**
 * @author Zubayer Ahamed
 * @since Aug 23, 2022
 */
public class KitTime implements Comparable<Object>, Serializable {

	private static final long serialVersionUID = -3104686262221211745L;

	private int hour = 0;
	private int minute = 0;
	private int second = 0;

	public KitTime() {
		super();
	}

	public KitTime(KitTime ob) {
		this(ob.getHour(), ob.getMinute(), ob.getSecond());
	}

	/**
	 * Construct a KitTime instance from <code>HH:mm:ss</code> string.
	 * 
	 * @param time Time value as HH:mm:ss
	 */
	public KitTime(String time) {
		setTime(time);
	}

	/**
	 * Construct a KitTime instance from {@link Calendar}.
	 * 
	 * @param ob {@link Calendar}
	 */
	public KitTime(Calendar ob) {
		this(ob.get(HOUR_OF_DAY), ob.get(MINUTE), ob.get(SECOND));
	}

	/**
	 * Construct a KitTime instance from {@link Date}.
	 * 
	 * @param ob {@link Date}
	 */
	@SuppressWarnings("deprecation")
	public KitTime(Date ob) {
		this(ob.getHours(), ob.getMinutes(), ob.getSeconds());
	}

	public KitTime(int h, int m) {
		this(h, m, 0);
	}

	public KitTime(int h, int m, int s) {
		this.hour = h;
		this.minute = m;
		this.second = s;
	}

	public static KitTime getInstance(Date ob) {
		if (ob == null) ob = Calendar.getInstance().getTime();
		return new KitTime(ob);
	}

	public static KitTime now() {
		return new KitTime(Calendar.getInstance());
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) throws TimeFormatException {
		if (hour <= 23 && hour >= 0) this.hour = hour;
		else throw new TimeFormatException("Invalid value for hour");
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) throws TimeFormatException {
		if (minute <= 59 && minute >= 0) this.minute = minute;
		else throw new TimeFormatException("Invalid value for minute");
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) throws TimeFormatException {
		if (second <= 59 && second >= 0) this.second = second;
		else throw new TimeFormatException("Invalid value for second");
	}

	public String getTime() {
		if (isTimeZero()) return "";
		NumberFormat formatter = new DecimalFormat("#00");
		String time = formatter.format(this.hour) + ":" + formatter.format(this.minute);
		if (this.second > 0) time += ":" + formatter.format(this.second);
		return time;
	}

	public String getT5Time() {
		if (isTimeZero()) return "";
		NumberFormat formatter = new DecimalFormat("#00");
		return formatter.format(this.hour) + ":" + formatter.format(this.minute);
	}

	public void setTime(String time) {
		if (time == null) return;
		if (time.matches("^([0-2][0-9]):([0-5][0-9])(:[0-5][0-9])?$")) {
			int hh = 0, mm = 0, sec = 0;
			String parts[] = time.split(":");
			if (parts.length == 2) {
				hh = Integer.parseInt(parts[0]);
				mm = Integer.parseInt(parts[1]);
			} else {
				hh = Integer.parseInt(parts[0]);
				mm = Integer.parseInt(parts[1]);
				sec = Integer.parseInt(parts[2]);
			}
			if ((hh <= 23) && (mm <= 59) && (sec <= 59)) {
				this.hour = hh;
				this.minute = mm;
				this.second = sec;
			}
		}
	}

	private boolean isTimeZero() {
		boolean isZero = false;
		if (this.hour == 0 && this.minute == 0 && this.second == 0) isZero = true;
		return isZero;
	}

	public long getTimeInSecond() {
		return this.hour * 60 * 60 + this.minute * 30 + this.second;
	}

	public boolean after(KitTime anotherTime) {
		return (compareTo(anotherTime) > 0);
	}

	public boolean before(KitTime anotherTime) {
		return (compareTo(anotherTime) < 0);
	}

	public boolean equals(KitTime anotherTime) {
		return (compareTo(anotherTime) == 0);
	}

	@Override
	public int compareTo(Object o) {
		if (!(o instanceof KitTime)) throw new ClassCastException("Invalid object");
		KitTime tm = (KitTime) o;
		return (int) (this.getTimeInSecond() - tm.getTimeInSecond());
	}

	public KitTime withHour(int hour) {
		try { setHour(hour); } catch (TimeFormatException e) {}
		return this;
	}

	public KitTime withMinute(int minute) {
		try { setMinute(minute); } catch (TimeFormatException e) {}
		return this;
	}

	/**
	 * Returns a copy of {@link KitTime} instance with the specified number of hours added.
	 * 
	 * @param hours Hours to add, may be negative
	 * @return {@link KitTime} copy based on provided instance, not null
	 */
	public KitTime addHour(int hours) {
		KitTime copy = new KitTime(this);
		if (hours == 0) return copy;
		try { copy.setHour(copy.getHour() + hours); } catch (TimeFormatException e) {}
		return copy;
	}

	/**
	 * Returns a copy of {@link KitTime} instance with the specified number of minutes added.
	 *  
	 * @param minutes Minutes to add, may be negative
	 * @return {@link KitTime} copy based on provided instance, not null
	 */
	public KitTime addMinute(int minutes) {
		KitTime copy = new KitTime(this);
		if (minutes == 0) return copy;
		try { copy.setMinute(copy.getMinute() + minutes); } catch (TimeFormatException e) {}
		return copy;
	}

	@Override
	public String toString() {
		return hour + ":" + minute + ":" + second;
	}

	/**
	 * Converts this object into {@link LocalTime}.
	 * 
	 * @return {@link LocalTime} instance representing same time value
	 * @see #getLocalTime(KitTime)
	 */
	public LocalTime toLocalTime() {
		return getLocalTime(this);
	}

	/**
	 * Converts {@link KitTime} object instance into {@link LocalTime}.
	 * 
	 * @param time {@link KitTime} instance
	 * @return {@link LocalTime} instance representing same time value
	 */
	public static LocalTime getLocalTime(KitTime time) {
		return time == null ? null : LocalTime.of(time.getHour(), time.getMinute(), time.getSecond());
	}

}
