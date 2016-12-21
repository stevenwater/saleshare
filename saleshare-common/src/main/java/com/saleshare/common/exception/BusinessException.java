package com.saleshare.common.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	/**未知异常*/
	public static final int UNKNOWN_ERROR = -1;
	
	/**参数异常*/
	public static final int INVALID_ARGUMENT_ERROR = -1;
	
	private int errorCode = UNKNOWN_ERROR;

	public BusinessException() {
		super();
	}
	
	public BusinessException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
