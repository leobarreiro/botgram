package com.gabro3.libs.botgram.response;

import com.gabro3.libs.botgram.model.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetMeResponse extends BotGramResponse {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("result")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
