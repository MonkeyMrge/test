package com.dts.Exception;

public class RetryOutException extends Exception {

	private static final long serialVersionUID = 1L;

	public RetryOutException() {
		super();
	}

	public RetryOutException(String msg) {
		super(msg);
	}

	public RetryOutException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public RetryOutException(Throwable cause) {
		super(cause);
	}
}
