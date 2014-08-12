package com;

public class BaseServiceImpl {
	
	private BaseAction baseAction = new BaseAction();
	
	public Object getBean(String beanId) {
		return baseAction.getBean(beanId);
	}

}
