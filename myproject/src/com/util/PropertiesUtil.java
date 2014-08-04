package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Description:   properties资源文件工具类
 * @author: Eason
 * Create Date: 2014-8-4
 * <pre>
 * 修改记录:
 * 修改后版本			修改人		修改日期			修改内容 
 * 2014-8-4.1		Eason		2014-8-4		create					
 * </pre>
 */
public class PropertiesUtil {
	
	/**
	 * Description :获取properties文件属性值，并转成整形
	 * @param filePath
	 * @param key
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static Integer getValueToInteger(String filePath,String key) {
		String value=getValue(filePath,key);
		Integer res=new Integer(value);
		return res;
	}
	
	/**
	 * Description :获取properties文件属性值
	 * @param filePath
	 * @param key
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static String getValue(String filePath,String key) {
		
        Properties props=getProperties(filePath);
        String value = props.getProperty(key);
        
        return value;
    }
	
	/**
	 * Description :根据输入流读取properties文件
	 * @param ips
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static Properties getProperties(InputStream ips) {
		
		Properties props = new Properties();
		try {
			props.load(ips);
//			Iterator<Object> its=props.keySet().iterator();
//			while(its.hasNext()) {
//				String key=(String)its.next();
//				if(Constant.PARENT.equals(key)) {
//					String path=(String)props.get(key);
//					props.putAll(getProperties(path));
//				}
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return props;
	}
	
	/**
	 * Description :根据路径读取properties文件
	 * @param filePath
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
    public static Properties getProperties(String filePath) {
    	
        Properties props = new Properties();
        InputStream ips = null;
        
    	ips=PropertiesUtil.class.getResourceAsStream(filePath);
        props=getProperties(ips);
        
        if(ips != null){
            try {
                ips.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return props;
    }
    
}
