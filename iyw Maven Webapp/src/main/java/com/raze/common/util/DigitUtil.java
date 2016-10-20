package com.raze.common.util;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author:DJM
 * @Date:04/20/2015
 * @Description:数字工具类
 */
public class DigitUtil {
	
	/*取整*/
	public static int obtainWithoutDecimal(Object obj){
		if(obj==null||obj.equals("")){
			return 0;
		}
		
		Pattern pt = Pattern.compile("^[0-9]+\\.{0,1}[0-9]{0,}$");
		Matcher mt = pt.matcher(obj.toString());
		if(!mt.matches()){
			return 0;
		}
		
		Double whole = Double.valueOf(obj.toString());
		Double floo = Math.floor(whole);
		DecimalFormat df = new DecimalFormat("0");
		return Integer.parseInt(df.format(floo));
		
	}
	
}
