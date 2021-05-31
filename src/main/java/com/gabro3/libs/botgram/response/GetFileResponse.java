package com.gabro3.libs.botgram.response;

import java.io.Serializable;

import com.gabro3.libs.botgram.model.TelegramFile;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetFileResponse extends BotGramResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("result")
	private TelegramFile file;

	public TelegramFile getFile() {
		return file;
	}

	public void setFile(TelegramFile file) {
		this.file = file;
	}

}
