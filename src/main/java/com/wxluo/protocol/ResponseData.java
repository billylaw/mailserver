package com.wxluo.protocol;

public class ResponseData {
	
	//返回的信息
	private  String responseStr;
	
	//返回码 0：ok,1:error,2:exception
	private int responseCode;
	
	//返回的数据
	private Object data;

	public String getResponseStr() {
		return responseStr;
	}

	public void setResponseStr(String responseStr) {
		this.responseStr = responseStr;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
