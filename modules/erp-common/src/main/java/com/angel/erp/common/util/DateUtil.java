/**
 * Copyright (c) 2017, All Rights Reserved. 
 */
package com.angel.erp.common.util;

import java.text.ParseException;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import com.google.common.base.Strings;

/**
 * 日期时间工具类
 *
 * @date: 2017年12月3日 下午10:43:03
 * @author li_ming 
 */
public class DateUtil {
	/**
	 * 时间类型：d(天)、w(周)、m(月)、y(年)
	 *
	 * @date: 2017年3月23日 下午4:42:52
	 * @author li_ming 
	 */
	public static enum DATETYPE {
		D, W, M, Y
	};
	// 时间格式
	private static String DATEFORMAT = "yyyy-MM-dd";
	private static String TIMEFORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 获取昨天/上周/上月/去年的开始和结束时间
	 *
	 * @param dateType 时间类型：d(天)、w(周)、m(月)、y(年)
	 * @return [开始时间, 结束时间]
	 */
	public static String[] getPeriodDate(DATETYPE dateType) {
		String[] result = new String[2];
		DateTime dt = new DateTime();
		switch (dateType) {
		case D:
			result[0] = dt.minusDays(1).toString(DATEFORMAT);
			result[1] = result[0];
			break;
		case W:
			result[0] = dt.minusWeeks(1).dayOfWeek().withMinimumValue().toString(DATEFORMAT);
			result[1] = dt.minusWeeks(1).dayOfWeek().withMaximumValue().toString(DATEFORMAT);
			break;
		case M:
			result[0] = dt.minusMonths(1).dayOfMonth().withMinimumValue().toString(DATEFORMAT);
			result[1] = dt.minusMonths(1).dayOfMonth().withMaximumValue().toString(DATEFORMAT);
			break;
		case Y:
			result[0] = dt.minusYears(1).dayOfYear().withMinimumValue().toString(DATEFORMAT);
			result[1] = dt.minusYears(1).dayOfYear().withMaximumValue().toString(DATEFORMAT);
			break;
		}
		return result;
	}

	/**
	 * 获取某时间段的开始和结束时间
	 *
	 * @param dateType 时间类型：d(天)、w(周)、m(月)、y(年)
	 * @param num 时间段
	 * @return [开始时间, 结束时间]
	 */
	public static String[] getPeriodDate(DATETYPE dateType, int num) {
		String[] result = new String[2];
		DateTime dt = new DateTime();
		String newDate = "";
		switch (dateType) {
		case D:
			newDate = dt.plusDays(num).toString(DATEFORMAT);
			break;
		case W:
			newDate = dt.plusWeeks(num).toString(DATEFORMAT);
			break;
		case M:
			newDate = dt.plusMonths(num).toString(DATEFORMAT);
			break;
		case Y:
			newDate = dt.plusYears(num).toString(DATEFORMAT);
			break;
		}
		if (num > 0) {
			result[0] = dt.toString(DATEFORMAT);
			result[1] = newDate;
		} else {
			result[0] = newDate;
			result[1] = dt.toString(DATEFORMAT);
		}
		return result;
	}

	/**
	 * 获取环比的开始和结束时间
	 *
	 * @param dateType 时间类型：d(天)、w(周)、m(月)、y(年)
	 * @return [开始时间, 结束时间]
	 */
	public static String[] getMomDate(DATETYPE dateType) {
		String[] result = new String[2];
		DateTime dt = new DateTime();
		switch (dateType) {
		case D:
			result[0] = dt.minusDays(2).toString(DATEFORMAT);
			result[1] = result[0];
			break;
		case W:
			result[0] = dt.minusWeeks(2).dayOfWeek().withMinimumValue().toString(DATEFORMAT);
			result[1] = dt.minusWeeks(2).dayOfWeek().withMaximumValue().toString(DATEFORMAT);
			break;
		case M:
			result[0] = dt.minusMonths(2).dayOfMonth().withMinimumValue().toString(DATEFORMAT);
			result[1] = dt.minusMonths(2).dayOfMonth().withMaximumValue().toString(DATEFORMAT);
			break;
		case Y:
			result[0] = dt.minusYears(2).dayOfYear().withMinimumValue().toString(DATEFORMAT);
			result[1] = dt.minusYears(2).dayOfYear().withMaximumValue().toString(DATEFORMAT);
			break;
		}
		return result;
	}

	/**
	 * 获取同比的开始和结束时间
	 *
	 * @param dateType 时间类型：d(天)、w(周)、m(月)、y(年)
	 * @return [开始时间, 结束时间]
	 */
	public static String[] getAnDate(DATETYPE dateType) {
		String[] result = new String[2];
		DateTime dt = new DateTime();
		switch (dateType) {
		case D:
			result[0] = dt.minusYears(1).minusDays(1).toString(DATEFORMAT);
			result[1] = result[0];
			break;
		case W:
			result[0] = dt.minusYears(1).minusWeeks(1).dayOfWeek().withMinimumValue().toString(DATEFORMAT);
			result[1] = dt.minusYears(1).minusWeeks(1).dayOfWeek().withMaximumValue().toString(DATEFORMAT);
			break;
		case M:
			result[0] = dt.minusYears(1).minusMonths(1).dayOfMonth().withMinimumValue().toString(DATEFORMAT);
			result[1] = dt.minusYears(1).minusMonths(1).dayOfMonth().withMaximumValue().toString(DATEFORMAT);
			break;
		case Y:
			break;
		}
		return result;
	}

	/**
	 * 获取昨天零点时间
	 *
	 * @return 
	 */
	public static String getYesterdayTime() {
		DateTime dt = new DateTime();
		return dt.minusDays(1).withMillisOfDay(0).toString(TIMEFORMAT);
	}

	/**
	 * 取得当前系统时间
	 *
	 * @return 
	 */
	public static String getDateNow() {
		return new DateTime().toString(DATEFORMAT);
	}

	/**
	 * 取得当前系统时间
	 *
	 * @return 
	 */
	public static String getTimeNow() {
		return new DateTime().toString(TIMEFORMAT);
	}

	/**
	 * 格式化时间为 相应的格式
	 *
	 * @param date
	 * @param pattern
	 * @return 
	 * @throws ParseException 
	 */
	public static Date parseStr2Date(String date, String pattern) throws ParseException {
		if (Strings.isNullOrEmpty(date) || Strings.isNullOrEmpty(pattern)) {
			return null;
		}
		return DateTimeFormat.forPattern(pattern).parseDateTime(date).toDate();
	}
}
