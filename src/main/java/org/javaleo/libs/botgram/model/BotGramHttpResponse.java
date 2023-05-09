package org.javaleo.libs.botgram.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class BotGramHttpResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private int code;
	private String protocol;
	private String content;

}
