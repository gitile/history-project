package com.gitile.base.utils;

import com.gitile.base.utils.idcard.IdcardInfoExtractor;

/**
 * 身份证号码测试
 *
 */
public class IdCardTest {

	public static void main(String[] args) {
		IdcardInfoExtractor idcardInfo=new IdcardInfoExtractor("332527198809091111");  
        System.out.println("出生日期:"+idcardInfo.getYear()+"-"+idcardInfo.getMonth()+"-"+idcardInfo.getDay());  
        System.out.println("性别:"+idcardInfo.getGender());  
        System.out.println("年龄:"+idcardInfo.getAge());  
        System.out.println("省份:"+idcardInfo.getProvince());
	}
}
