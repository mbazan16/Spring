package com.sb.ln.exceptions;

public class ServicioException extends Exception {
	private int code;

	public ServicioException() {
		super();
	}

	public ServicioException(int code) {
		super();
		this.code = code;
	}

	public ServicioException(String message, int code) {
		super(message);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}
