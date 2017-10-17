package com.freecrm.uiAutomation.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeUtil {

	public static String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss");
		Calendar cal = Calendar.getInstance();
		String currentDateTime = dateFormat.format(cal.getTime());
		return currentDateTime;
	}

	public static String getCurrentDate() {
		return getCurrentDateTime().substring(0, 11);
	}

	/*
	 * public static void main(String[] args) {
	 * System.out.println(getCurrentDateTime());
	 * System.out.println(getCurrentDate()); }
	 */

}
