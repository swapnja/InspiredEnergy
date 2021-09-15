
package com.Base;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStampPageHandler {

	public static String AppendTimeStamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		String formattedDate = sdf.format(date);
		return formattedDate;
	}
}