package com.jikuodong.plms.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {

	private DateUtil() {}

	private static final Logger log = LogManager.getLogger(DateUtil.class);

	private static final String SDF_YEAR = "yyyy";
	private static final String SDF_DAY = "yyyy-MM-dd";
	private static final String SDF_LOCAL_DAY = "yyyy年MM月dd日";
	private static final String SDF_DAYS = "yyyyMMdd";
	private static final String SDF_TIME = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 获取YYYY格式
	 *
	 * @return
	 */
	public static String getYear() {
		return new SimpleDateFormat(SDF_YEAR).format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD格式
	 *
	 * @return
	 */
	public static String getDay() {
		return new SimpleDateFormat(SDF_DAY).format(new Date());
	}

	/**
	 * 获取YYYYMMDD格式
	 *
	 * @return
	 */
	public static String getDays() {
		return new SimpleDateFormat(SDF_DAYS).format(new Date());
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 *
	 * @return
	 */
	public static String getTime() {
		return new SimpleDateFormat(SDF_TIME).format(new Date());
	}

	/**
	 * 获取yyyy年MM月dd日格式
	 *
	 * @return
	 */
	public static String getLocalDay() {
		return new SimpleDateFormat(SDF_LOCAL_DAY).format(new Date());
	}

	public static Date getNow() {
		return Calendar.getInstance().getTime();
	}

	public static long getTimeStamp() {
		return Calendar.getInstance().getTimeInMillis();
	}

	/**
	 * @Title: compareDate
	 * @Description: (日期比较 ， 如果s > = e 返回true 否则返回false)
	 * @param s
	 * @param e
	 * @return boolean
	 * @throws @author
	 *             luguosui
	 */
	public static boolean compareDate(String s, String e) {
		Date ds = formatDate(s);
		Date de = formatDate(e);
		if (ds != null && de != null) {
			return ds.getTime() >= de.getTime();
		} else {
			return false;
		}
	}

	/**
	 * 格式化日期
	 *
	 * @return
	 */
	public static Date formatDate(String date) {
		return formatDate(date, SDF_DAY);
	}

	/**
	 * 格式化日期
	 *
	 * @return
	 */
	public static Date formatDate(String date, String formatType) {
		DateFormat fmt = new SimpleDateFormat(formatType);
		try {
			return fmt.parse(date);
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
			return null;
		}
	}

	public static Date toDate(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date toDate(int year, int month, int day) {
		return toDate(CommonUtils.toString(Integer.valueOf(year)), CommonUtils.toString(Integer.valueOf(month)),
				CommonUtils.toString(Integer.valueOf(day)));
	}

	public static Date toDate(String year, String month, String day) {
		if (month.length() == 1) {
			month = CommonUtils.concat("0", month);
		}
		if (day.length() == 1) {
			day = CommonUtils.concat("0", day);
		}
		return toDate(CommonUtils.concat(year, month, day), "yyyyMMdd");
	}

	/**
	 * date类型转换为String类型
	 *
	 * @param date
	 *            Date类型的时间
	 * @param formatType
	 *            格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
	 * @return
	 */
	public static String dateToString(Date date, String formatType) {
		return  new SimpleDateFormat(formatType).format(date);
	}

	/**
	 * 校验日期是否合法
	 *
	 * @return
	 */
	public static boolean isValidDate(String s) {
		DateFormat fmt = new SimpleDateFormat(SDF_DAY);
		try {
			fmt.parse(s);
			return true;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
	}

	public static int getDiffYear(String startTime, String endTime) {
		DateFormat fmt = new SimpleDateFormat(SDF_DAY);
		try {
			return (int) (((fmt.parse(endTime).getTime() - fmt.parse(startTime).getTime()) / (1000 * 60 * 60 * 24))
					/ 365);
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}

	/**
	 * <li>功能描述：时间相减得到天数
	 *
	 * @param beginDateStr
	 * @param endDateStr
	 * @return long
	 * @author Administrator
	 */
	public static long getDaySub(String beginDateStr, String endDateStr) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat(SDF_DAY);
		Date beginDate = format.parse(beginDateStr);
		Date endDate = format.parse(endDateStr);
		return (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
	}

	/**
	 * <li>功能描述：时间相减得到小时数
	 *
	 * @param beginDateStr
	 * @param endDateStr
	 * @return long
	 * @author Administrator
	 */
	public static long getHourSub(String beginDateStr, String endDateStr) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat(SDF_TIME);
		Date beginDate = format.parse(beginDateStr);
		Date endDate = format.parse(endDateStr);
		return (endDate.getTime() - beginDate.getTime()) / (60 * 60 * 1000);
	}

	/**
	 * 得到n天之后的日期
	 *
	 * @param days
	 * @return
	 */
	public static String getAfterDayDate(String days) {
		int daysInt = Integer.parseInt(days);
		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();
		SimpleDateFormat sdfd = new SimpleDateFormat(SDF_TIME);
		return sdfd.format(date);
	}

	/**
	 * 得到n天之后的日期
	 *
	 * @param days
	 *            startDate 需要计算的时间
	 * @return Date 计算后的时间
	 */
	public static Date getDateByDay(String startDate, int days) {
		Date start = formatDate(startDate);
		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.setTime(start);
		canlendar.add(Calendar.DATE, days); // 日期减 如果不够减会将月变动
		return canlendar.getTime();
	}

	/**
	 * UTC本地时间
	 *
	 * @param utcTime
	 * @return
	 */
	public static String utc2GMT8(String utcTime) throws ParseException{
		SimpleDateFormat utcFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		utcFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date gpsUTCDate = utcFormatter.parse(utcTime);
		SimpleDateFormat localFormatter = new SimpleDateFormat(SDF_TIME);
		localFormatter.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
		return localFormatter.format(gpsUTCDate.getTime());
	}

	/**
	 * 得到n天之后是周几
	 *
	 * @param days
	 * @return
	 */
	public static String getAfterDayWeek(String days) {
		int daysInt = Integer.parseInt(days);
		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("E");
		return sdf.format(date);
	}

	/**
	 *
	 * describe 获取当时时间（默认格式化："yyyy/MM/dd HH:mm:ss"）
	 * @author xmc
	 * @date 2019/3/12 10:56
	 * @param  * @param
	 * @return java.lang.String
	 */
	public static String getCurrentTime() {
		return getCurrentTime("yyyy/MM/dd HH:mm:ss");
	}

	/**
	 * 自定义格式化时间
	 *
	 * @param format
	 * @return
	 */
	public static String getCurrentTime(String format) {
		Calendar ca = Calendar.getInstance();
		SimpleDateFormat sdf = null;
		if ((format != null) && (!"".equals(format))) {
			sdf = new SimpleDateFormat(format);
		} else {
			sdf = new SimpleDateFormat(SDF_TIME);
		}
		return sdf.format(ca.getTime());
	}

	/**
	 * 将时间戳转换为时间
	 *
	 * @param timeStamp
	 *            时间戳
	 * @param formatType
	 *            格式
	 */
	public static String timeStampToDate(long timeStamp, String formatType) {
		SimpleDateFormat format = new SimpleDateFormat(formatType);
		Date date = new Date(timeStamp);
		return format.format(date);
	}

	public static Date addSecond(Date firstDate, int second) {
		Calendar initDate = Calendar.getInstance();
		initDate.setTime(firstDate);
		initDate.add(13, second);
		return initDate.getTime();
	}

	public static Date addHour(Date firstDate, int hour) {
		Calendar initDate = Calendar.getInstance();
		initDate.setTime(firstDate);
		initDate.add(Calendar.HOUR, hour);
		return initDate.getTime();
	}

	public static Date addDay(Date firstDate, int day) {
		Calendar initDate = Calendar.getInstance();
		initDate.setTime(firstDate);
		initDate.add(5, day);
		return initDate.getTime();
	}

	public static String addDay(String firstDate, int day, String formart) {
		return addDay(toDate(firstDate, formart), day, formart);
	}

	public static String addDay(Date firstDate, int day, String formart) {
		Calendar initDate = Calendar.getInstance();
		initDate.setTime(firstDate);
		initDate.add(5, day);
		return toString(initDate.getTime(), formart);
	}

	public static String toString(Date date) {
		return toString(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static String toString(Date date, String format) {
		SimpleDateFormat sdf = null;
		if (CommonUtils.isNotBlank(format)) {
			sdf = new SimpleDateFormat(format);
		} else {
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}

		return sdf.format(date);
	}
}
