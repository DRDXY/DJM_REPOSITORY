package com.raze.common.util;

import java.text.DecimalFormat;

/**
 * @Author:DJM
 * @Date:04/20/2015
 * @Description:计算工具类
 */
public class CalculateUtil {
	
	/*求商*/
	public static String quotient(Object numerator, Object denominator){
		//判断是否为null
		if(numerator==null||denominator==null){
			return "0";
		}
		//判断是否为0
		if(numerator.toString().trim().equals("0")||denominator.toString().trim().equals("0")){
			return "0";
		}
		DecimalFormat df = new DecimalFormat("0.000");
		Double numerator1 = Double.valueOf(numerator.toString());
		Double denominator1 = Double.valueOf(denominator.toString());
		String value = df.format(numerator1/denominator1);
		return value;
	}

}
