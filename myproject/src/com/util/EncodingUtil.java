package com.util;

import java.io.UnsupportedEncodingException;

/**
 * Description:   转换编码工具类
 * @author: Eason
 * Create Date: 2014-8-4
 * <pre>
 * 修改记录:
 * 修改后版本			修改人		修改日期			修改内容 
 * 2014-8-4.1		Eason		2014-8-4		create					
 * </pre>
 */
public class EncodingUtil {
	
	/**
	 * Description :用utf8编码字符串
	 * @param s
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static String toUTF8(String s) {
		if(EmptyUtil.isNotEmpty(s)) {
			try {
				return new String(s.getBytes("ISO-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return s;
	}
	
	/**
	 * Description :用gbk编码字符串
	 * @param s
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static String toGBK(String s) {
		if(EmptyUtil.isNotEmpty(s)) {
			try {
				return new String(s.getBytes("ISO-8859-1"),"gbk");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return s;
	}
	
	/**
	 * Description :用gb2312对字符串编码
	 * @param s
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static String toGB2312(String s) {
		if(EmptyUtil.isNotEmpty(s)) {
			try {
				return new String(s.getBytes("ISO-8859-1"),"gb2312");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return s;
	}

}
