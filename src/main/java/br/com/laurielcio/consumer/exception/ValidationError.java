package br.com.laurielcio.consumer.exception;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lau
 *
 */

public class ValidationError extends StandardError{

	private static final long serialVersionUID = 8642504767390549155L;
	
	private List<FieldMessage> errors = new ArrayList<>();

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}

}
