package com.util;

public class ResultMessage {
	
	private String resultCode;
	private boolean isSuccess;
	private Object resultDate;
	private String resultDetail;
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public Object getResultDate() {
		return resultDate;
	}
	public void setResultDate(Object resultDate) {
		this.resultDate = resultDate;
	}
	public String getResultDetail() {
		return resultDetail;
	}
	public void setResultDetail(String resultDetail) {
		this.resultDetail = resultDetail;
	}

}
