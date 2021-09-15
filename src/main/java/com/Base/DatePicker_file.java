
package com.Base;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatePicker_file {

	public static String datePick() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String appendDate = dtf.format(now);
		return appendDate;
	}
}