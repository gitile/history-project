package com.gitile.chinalife.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	public static String NowDatetime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datetime = sdf.format(new Date());
		return datetime;
	}
	
	public static String getText(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String datetime = sdf.format(date);
		return datetime;
	}

	public static String getNowDateString(int addOrSubDay) {
		Calendar c = Calendar.getInstance();
        c.setTime(new Date());   //设置当前日期
        c.add(Calendar.DATE, addOrSubDay); //日期加addOrSubDay
        Date date = c.getTime(); //结果
		return DateUtils.getText(date);
	}
	
}
