package com.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	
	private static final String SPRINGCONTEXT = "applicationContext.xml";
	
	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(SPRINGCONTEXT);
	
	public static Object getBean(String beanId) {
		return applicationContext.getBean(beanId);
	}

}
