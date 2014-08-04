package com.constant;

/**
 * Description:   整个工程的编码方式枚举类
 * @author: Eason
 * Create Date: 2014-8-4
 * <pre>
 * 修改记录:
 * 修改后版本			修改人		修改日期			修改内容 
 * 2014-8-4.1		Eason		2014-8-4		create					
 * </pre>
 */
public enum Encoding {
	
	UTF_8("UTF-8"),GBK("GBK");
	
	private String encoding;
	
	private Encoding(String v) {
		encoding=v;
	}
	
	public String getEncoding() {
		return encoding;
	}

	@Override
	public String toString() {
		return encoding;
	}
	
	
	
}
