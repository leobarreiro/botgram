package org.javaleo.libs.botgram.response;

import java.io.Serializable;

import org.javaleo.libs.botgram.model.TelegramFile;

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
