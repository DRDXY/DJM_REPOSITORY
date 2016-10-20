package com.raze.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * <p>汉字转换拼音的工具类</p>
 * @author DJM
 */
public class PinyinUtil {
	
    private PinyinUtil(){
    }
    
    public static PinyinUtil getInstance(){
        return new PinyinUtil();
    }
    
    public String toPinyin(String chineseCharacter){
        String pinyin = "";
        for(Character chara: chineseCharacter.toCharArray()){
            Pattern pt = Pattern.compile("[\\u4e00-\\u9fa5]+");
            Matcher mt = pt.matcher(chara.toString());
            if(mt.matches()){
                HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
                format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
                String[] hyArr = null;
                try {
                    hyArr = PinyinHelper.toHanyuPinyinStringArray(chara, format);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
                pinyin = pinyin.concat(hyArr[0]);
            }else{
                //���˿հ��ַ�
                Pattern blankPt = Pattern.compile("\\s+"); 
                Matcher blankMt = blankPt.matcher(chara.toString());
                if(!blankMt.matches()){
                    pinyin = pinyin.concat(chara.toString());
                }
            }
        }
        return pinyin;
    }

}
