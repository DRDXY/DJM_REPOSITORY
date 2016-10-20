package com.raze.common.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * <p>Map工具类</p>
 * @author DJM
 */
public class MapUtil {
	
	//清除键值对中的值的字符串两侧的空白字符
	public static Map<String, Object> trimValue(Map<String, Object> parameters){
		Map<String, Object> comprehensiveMap = new HashMap<String, Object>();
		Set<Entry<String, Object>> set = parameters.entrySet();
		for (Entry<String, Object> entry : set) {
			String key = entry.getKey();
			Object value = entry.getValue();
			String valueType = entry.getValue().getClass().getSimpleName();
			if(valueType.equals("String")){
				value = value.toString().trim();
			}
			comprehensiveMap.put(key, value);
		}
		return comprehensiveMap;
	}
	
}
