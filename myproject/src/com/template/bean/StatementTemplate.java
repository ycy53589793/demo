package com.template.bean;

import freemarker.template.Template;

public class StatementTemplate {
	
	private String type;
	private Template template;
	
	public StatementTemplate() {
		
	}
	public StatementTemplate(String type,Template template) {
		this.type=type;
		this.template=template;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Template getTemplate() {
		return template;
	}
	public void setTemplate(Template template) {
		this.template = template;
	}
	
}
