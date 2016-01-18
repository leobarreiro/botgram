package org.javaleo.libs.botgram.response;

import java.beans.Transient;
import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public abstract class BotGramResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private int httpResponseCode;
	private Boolean ok;
	private String description;

	@Transient
	public int getHttpResponseCode() {
		return httpResponseCode;
	}

	public void setHttpResponseCode(int httpResponseCode) {
		this.httpResponseCode = httpResponseCode;
	}

	@SerializedName("ok")
	public Boolean getOk() {
		return ok;
	}

	public void setOk(Boolean ok) {
		this.ok = ok;
	}

	@SerializedName("description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
