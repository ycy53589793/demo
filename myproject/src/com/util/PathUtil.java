package com.util;

import org.apache.struts2.ServletActionContext;

/**
 * Description:   文件路径工具类
 * @author: Eason
 * Create Date: 2014-8-4
 * <pre>
 * 修改记录:
 * 修改后版本			修改人		修改日期			修改内容 
 * 2014-8-4.1		Eason		2014-8-4		create					
 * </pre>
 */
public class PathUtil {
	
	//上下文
	private static final String CONTEXT = "common\\json\\";
	//后缀
	private static final String SUFFIX = ".json";
	
	/**
	 * Description :获取正确的json文件路径
	 * @param fileName
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static String getRightJsonPath(String fileName) {
		String contextPath=CONTEXT+fileName+SUFFIX;
		String realPath=ServletActionContext.getServletContext().getRealPath("/")+contextPath;
		return realPath;
	}
	
	/*
	public static String getRightPropertiesPath(String path) {
		String realPath=ServletActionContext.getServletContext().getRealPath("/")+path.replaceAll("/", "\\\\");
		return realPath;
	}
	*/

}
