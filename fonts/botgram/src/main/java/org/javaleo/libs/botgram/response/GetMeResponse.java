package org.javaleo.libs.botgram.response;

import org.javaleo.libs.botgram.model.User;

import com.google.gson.annotations.SerializedName;

public class GetMeResponse extends BotGramResponse {

	private static final long serialVersionUID = 1L;
	
	@SerializedName("result")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
