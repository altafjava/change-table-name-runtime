package com.javaaltaf.config;

import java.util.Calendar;
import org.hibernate.EmptyInterceptor;

public class CustomInterceptor extends EmptyInterceptor {

	@Override
	public String onPrepareStatement(String sql) {

		System.err.println("Before Modifying SQL =" + sql);
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		String tableName = "ATTENDANCE_" + month + "_" + year;
		sql = sql.replace("ATTENDANCE_1_2019 ", tableName);
		System.err.println("After Modifying SQL =" + sql);

		return sql;
	}
}
