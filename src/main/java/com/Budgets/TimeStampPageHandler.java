
package com.Budgets;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStampPageHandler {

	public static String AppendTimeStamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
		String formattedDate = sdf.format(date);
		return formattedDate;
	}

	public static String FileNameTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy HH.mm.ss");
		String formattedDate = sdf.format(date);
		return formattedDate;
	}
}