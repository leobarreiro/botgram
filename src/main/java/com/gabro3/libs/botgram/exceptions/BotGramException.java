package com.gabro3.libs.botgram.exceptions;

public class BotGramException extends Exception {

	private static final long serialVersionUID = 1L;

	public BotGramException() {
		super();
	}

	public BotGramException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BotGramException(String message, Throwable cause) {
		super(message, cause);
	}

	public BotGramException(String message) {
		super(message);
	}

	public BotGramException(Throwable cause) {
		super(cause);
	}

}
