package com.common;

import com.BaseAction;

public class PageAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1448889355454862624L;
	
	private String page = (String) servletRequest.getParameter("page");
	private String rows = (String) servletRequest.getParameter("rows");
	protected int pageNo = Integer.parseInt((page == null || page == "0") ? "1":page);
	protected int pageSize = Integer.parseInt((rows == null || rows == "0") ? "1":rows);
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}

}
