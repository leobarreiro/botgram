package com.gabro3.libs.botgram.model;

import java.io.Serializable;

public class BotGramHttpResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private int code;
	private String protocol;
	private String content;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
