package com.raze.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ParameterUtils {
	
    private ParameterUtils(){
    }
	 
	public static ParameterUtils getInstance(){
	        return new ParameterUtils();
	}

	public Map<String, Object> getParameter(Map<String, Object> requests) {
		Map<String, Object> comprehensive = new HashMap<String, Object>();
		Iterator<Entry<String, Object>> iterator = requests.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, Object> entry = iterator.next();
			String key = entry.getKey();
			String[] array = (String[]) entry.getValue();
			StringBuffer stringBuffer = new StringBuffer();
			for(int token=0; token<array.length; token++){
				stringBuffer.append(array[token]);
			}
			String value = "";
			try {
				value = URLDecoder.decode(stringBuffer.toString(), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			comprehensive.put(key, value);
		}
		return comprehensive;
	}
	
}
