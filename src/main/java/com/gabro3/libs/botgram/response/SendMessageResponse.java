package com.gabro3.libs.botgram.response;

import com.gabro3.libs.botgram.model.Message;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendMessageResponse extends BotGramResponse {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("result")
	private Message message;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

}
