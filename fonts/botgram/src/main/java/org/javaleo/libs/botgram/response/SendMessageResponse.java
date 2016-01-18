package org.javaleo.libs.botgram.response;

import org.javaleo.libs.botgram.model.Message;

import com.google.gson.annotations.SerializedName;

public class SendMessageResponse extends BotGramResponse {

	private static final long serialVersionUID = 1L;
	
	@SerializedName("result")
	private Message message;

}
