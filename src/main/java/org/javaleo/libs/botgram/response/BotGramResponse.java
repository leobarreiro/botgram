package org.javaleo.libs.botgram.response;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
