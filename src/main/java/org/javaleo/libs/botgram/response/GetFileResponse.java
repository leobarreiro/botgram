package org.javaleo.libs.botgram.response;

import java.io.Serializable;

import org.javaleo.libs.botgram.model.TelegramFile;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class GetFileResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@SerializedName("ok")
	private Boolean ok;

	@SerializedName("result")
	private TelegramFile file;

}
