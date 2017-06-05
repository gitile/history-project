package com.gitile.base.utils.lang;

/**
 * 树形类别工具类
 */
public class CategoryUtils {

	public static final String TOP_CATEGORY_CODE = "A";

	public static final String ROOT_CATEGORY_CODE = "A001";

	public static final String DEFAULT_CATEGORY_CODE_FORMAT = "000";
	
	
	/**
	 * 创建新的子类别（父子类别，类别格式A001B001C001） 
	 * 输入参数：@param parentCode 父类类别 　　　　　
	 */
	public static String getChildCategory(String parentCode) {
		if (StringUtils.isEmpty(parentCode)) {
		} else {
			char num = parentCode.charAt(parentCode.length() - 4);
			parentCode = parentCode + (++num);
		}
		String newNum = NumberUtils.numberFormat(1, DEFAULT_CATEGORY_CODE_FORMAT);
		return parentCode + newNum;
	}

	/**
	 * 创建同级下一类别（类别，类别格式A001B001C001） 
	 * 输入参数：
	 * @param categoryCode 类别
	 */
	public static String getNextCategory(String categoryCode) {
		if (StringUtils.isEmpty(categoryCode)) {
			return getChildCategory(ROOT_CATEGORY_CODE);
		}
		String num = categoryCode.substring(categoryCode.length() - 3,
				categoryCode.length());
		categoryCode = categoryCode.substring(0, categoryCode.length() - 3);
		int nextNum = Integer.parseInt(num) + 1;
		String newNum = NumberUtils.numberFormat(nextNum,
				DEFAULT_CATEGORY_CODE_FORMAT);
		return categoryCode + newNum;
	}

}
