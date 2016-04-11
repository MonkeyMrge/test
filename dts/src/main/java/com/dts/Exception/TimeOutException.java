package com.dts.Exception;

public class TimeOutException extends Exception {

	private static final long serialVersionUID = 1L;

	public TimeOutException() {
		super();
	}

	public TimeOutException(String msg) {
		super(msg);
	}

	public TimeOutException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public TimeOutException(Throwable cause) {
		super(cause);
	}
}
