package org.javaleo.libs.botgram.response;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public abstract class BotGramResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private int httpResponseCode;
	private String protocol;
	private String bufferContent;

	@Expose
	@SerializedName("ok")
	private Boolean ok;

	@Expose
	@SerializedName("description")
	private String description;

	public int getHttpResponseCode() {
		return httpResponseCode;
	}

	public void setHttpResponseCode(int httpResponseCode) {
		this.httpResponseCode = httpResponseCode;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getBufferContent() {
		return bufferContent;
	}

	public void setBufferContent(String bufferContent) {
		this.bufferContent = bufferContent;
	}

	public Boolean getOk() {
		return ok;
	}

	public void setOk(Boolean ok) {
		this.ok = ok;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
