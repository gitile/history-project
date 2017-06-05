package com.gitile.base.utils.lang;

public class StringUtils extends org.apache.commons.lang3.StringUtils {
	
	public static final String LINE = "\r\n";
	public static final String TAB = "\t";
	
	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if (str!=null && str.trim().length()>0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return !isNotEmpty(str);
	}
	
	public static int toInt(String str) {
		try {
			if(isNotEmpty(str)) {
				int result = Integer.valueOf(str);
				return result;
			}
		} catch (Exception e) {
		}
		return 0;
	}
	
	public static short toShort(String str) {
		try {
			if(isNotEmpty(str)) {
				short result = Short.valueOf(str);
				return result;
			}
		} catch (Exception e) {
		}
		return 0;
	}
	

}
