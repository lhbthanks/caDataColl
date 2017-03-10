package com.classnet.util;

public class WebUtils {

	public static boolean isEmpty(String str){
		return str==null||"".equals(str);
	}
	
	public static Integer StringToInt(String str){
		try{
			return Integer.parseInt(str);
		}catch(Exception e){
			return 0;
		}
	}
	
	/**
	 * 字符串内码转换 GB2312
	 */
	public static String interlize(String ori) {
		if (ori == null || ori.length() == 0) {
			return "";
		}
		String newstr = "";
		try {
			byte[] byte1 = ori.getBytes("EUC_CN");
			newstr = new String(byte1, "GB2312");
			return newstr;
		} catch (Exception e) {
			e.printStackTrace();
			return newstr;
		}
	}
}
