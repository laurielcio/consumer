package br.com.laurielcio.consumer.exception;

/**
 * 
 * @author Lau
 *
 */

public class ConvertException extends RuntimeException{

	private static final long serialVersionUID = 7987999084186285303L;

	public ConvertException(String msg) {
		super(msg);
	}
	
	public ConvertException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
