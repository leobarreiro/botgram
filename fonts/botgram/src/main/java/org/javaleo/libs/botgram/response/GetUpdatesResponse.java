package org.javaleo.libs.botgram.response;

import java.util.List;

import org.javaleo.libs.botgram.model.Update;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetUpdatesResponse extends BotGramResponse {

	private static final long serialVersionUID = 1L;

	@Expose
	@SerializedName("result")
	private List<Update> updates;

	public List<Update> getUpdates() {
		return updates;
	}

	public void setUpdates(List<Update> updates) {
		this.updates = updates;
	}

}
