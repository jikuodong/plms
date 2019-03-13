package com.jikuodong.plms.utils;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 字符串相关方法
 */
public class StringUtil {

	/**
	 * 将以逗号分隔的字符串转换成字符串数组
	 *
	 * @param valStr
	 * @return String[]
	 */
	public static String[] strList(String valStr) {
		int i = 0;
		String TempStr = valStr;
		String[] returnStr = new String[valStr.length() + 1 - TempStr.replace(",", "").length()];
		valStr = valStr + ",";
		while (valStr.indexOf(',') > 0) {
			returnStr[i] = valStr.substring(0, valStr.indexOf(','));
			valStr = valStr.substring(valStr.indexOf(',') + 1, valStr.length());

			i++;
		}
		return returnStr;
	}


	/**
	 * String[]处理数据
	 * @param obj
	 * @return
	 */
	public static String[] stringtoString(String[] obj){
		String str[]={"0","0","0","0","0","0","0","0","0","0","0","0"};
		if(obj.length>0){
			if(obj.length<12){
				int size = obj.length-1;
				for(int i=0;i<size;i++){
					str[i] = obj[i];
				}
				str[11] = obj[size];
				obj = str;
			}
			int i = Integer.parseInt(obj[0]);
			float j = Float.parseFloat(obj[11]);
			int k = Integer.parseInt(obj[10]);
			int l = Integer.parseInt(obj[8]);
			obj[3] = String.valueOf(i-j+k+l);
			float f = Float.parseFloat(obj[2]);
			obj[2] = String.valueOf((float)(Math.round(f*1000))/1000);
			return obj;
		}
		return str;
	}

	/**
	 * 转String，null时返回""
	 * @param obj
	 * @return
	 */
	public static String toStringOrEmpty(Object obj){
		if(null != obj) {
			return String.valueOf(obj);
		}
		return "";
	}

	/**
	 * 获取A第n次出现某字符B的下标
	 * @param string1 被匹配的字符A
	 * @param string2  匹配的字符B
	 * @param num 字符出现的次数n
	 * @return
	 */
	public static int getCharacterPosition(String string1, String string2, int num){
	    //这里是获取"/"符号的位置
	    Matcher slashMatcher = Pattern.compile(string2).matcher(string1);
	    int mIdx = 0;
	    while(slashMatcher.find()) {
	       mIdx++;
	       //当"/"符号第三次出现的位置
	       if(mIdx == num){
	          break;
	       }
	    }
	    return slashMatcher.start();
	 }

	/**
	 * 字符串转编码格式
	 * @param str 字符串
	 * @param newCharset 编码格式
	 * @return 转码后的字符串
	 * @throws UnsupportedEncodingException
	 */
	public static String changeCharSet(String str, String newCharset) throws UnsupportedEncodingException {
        if (str != null) {
            // 用默认字符编码解码字符串。
            byte[] bs = str.getBytes("UTF-8");
            // 用新的字符编码生成字符串
            return new String(bs, newCharset);
        }
        return str;
    }

	/**
	 * String[]去除重复
	 */
	public static String[] dislodge(String[] str){
		List<String> list = Arrays.asList(str);
		Set<String> set = new HashSet<String>(list);

		String[] rid=(String[])set.toArray(new String[0]);
		return rid;
	}

}
