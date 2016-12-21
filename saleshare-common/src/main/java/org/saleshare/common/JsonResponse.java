package org.saleshare.common;

import java.util.Map;

public class JsonResponse {
	
	/**响应码:成功*/
	public static final int SUCCESS = 1;
	
	/**响应码:失败*/
	public static final int FAIL = 0;
	
	/**响应码*/
	private int code;
	
	/**相应描述*/
	private String msg;
	
	/**响应数据*/
	private Map<String,Object> data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

}
